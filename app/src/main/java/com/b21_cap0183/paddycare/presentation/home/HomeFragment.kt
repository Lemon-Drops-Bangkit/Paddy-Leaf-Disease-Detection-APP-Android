package com.b21_cap0183.paddycare.presentation.home

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.b21_cap0183.paddycare.databinding.FragmentHomeBinding
import com.b21_cap0183.paddycare.presentation.detail.DetailDiseaseActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn
import java.io.File
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var photo: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(false)

        photo = fragmentHomeBinding.picture
        val button = fragmentHomeBinding.btnTakePicture

        button.setOnClickListener {
            takePhoto()
        }

        homeViewModel.result?.observe(viewLifecycleOwner, { image ->
            Log.d("Hello", "Passed")
            if (image != null) {
                Log.d("Observe", image.data.toString())
                image.data
                Toast.makeText(context, image.message, Toast.LENGTH_SHORT).show()
            } else {
                Log.d("Observe else", image?.data.toString())
            }
        })
    }

    private fun takePhoto() {
        ImagePicker.with(this)
            .crop()	    			            //Crop image(Optional), Check Customization for more option
            .compress(1024)			//Final image size will be less than 1 MB(Optional)
            .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
            //  Path: /storage/sdcard0/Android/data/package/files/Pictures/ImagePicker
            .saveDir(File(activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!, "ImagePicker"))
            .createIntent { intent ->
                startForProfileImageResult.launch(intent)
            }
    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {
                    //Image Uri will not be null for RESULT_OK
                    val fileUri = data?.data!!
                    val mFileUri = fileUri.toFile()

                    photo.setImageURI(fileUri)
                    homeViewModel.setSelectedFile(mFileUri)
                }
                ImagePicker.RESULT_ERROR -> {
                    Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context, "Task Cancelled", Toast.LENGTH_SHORT).show()
                }
            }
        }


    private fun showLoading(state: Boolean) {
        if (state) {
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentHomeBinding.progressBar.visibility = View.INVISIBLE
        }
    }
}