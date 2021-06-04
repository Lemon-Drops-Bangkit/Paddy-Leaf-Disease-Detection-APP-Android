package com.b21_cap0183.paddycare.presentation.home

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.b21_cap0183.paddycare.databinding.FragmentHomeBinding
import com.b21_cap0183.paddycare.presentation.detail.DetailDiseaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn
import java.io.File
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var photoFile: File
    private val FILE_NAME = "photo.jpg"
    private val REQUEST_CODE = 42

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
        fragmentHomeBinding.btnTakePicture.setOnClickListener {
            takePhoto()
        }
    }

    private fun takePhoto() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoFile(FILE_NAME)

        val fileProvider = FileProvider.getUriForFile(
            requireContext(),
            "com.b21_cap0183.fileprovider",
            photoFile
        )
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_CODE)
        } else {
            Toast.makeText(requireContext(), "Unable to open Camera", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDirectory = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        showLoading(false)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
            fragmentHomeBinding.picture.setImageBitmap(takenImage)
            fragmentHomeBinding.btnTakePicture.text = "Re-take Picture"

            val delay: Long = 3000
            Handler(Looper.getMainLooper()).postDelayed({
                showLoading(true)
                val intent = Intent(context, DetailDiseaseActivity::class.java)
                intent.putExtra(DetailDiseaseActivity.EXTRA_DISEASE, 1)
                startActivity(intent)
            }, delay)
            showLoading(false)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
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