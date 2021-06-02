package com.b21_cap0183.paddycare.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.databinding.ActivityDetailDiseaseBinding
import com.b21_cap0183.paddycare.databinding.ContentDetailBinding
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailDiseaseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DISEASE = "extra_disease"
    }

    private lateinit var activityDetailDiseaseBinding: ActivityDetailDiseaseBinding
    private lateinit var contentDetailBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailDiseaseBinding = ActivityDetailDiseaseBinding.inflate(layoutInflater)
        setContentView(activityDetailDiseaseBinding.root)
        contentDetailBinding = activityDetailDiseaseBinding.contentDetail

        setSupportActionBar(activityDetailDiseaseBinding.toolbar)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val diseaseId = extras.getInt(EXTRA_DISEASE)
                viewModel.setSelectedId(diseaseId)
                populateDisease(viewModel.getDisease())

        }

    }

    private fun populateDisease(diseaseEntity: DiseaseEntity) {
        supportActionBar?.title = diseaseEntity.diseaseName
        Glide.with(this)
                .load(diseaseEntity.diseasePicture)
                .into(activityDetailDiseaseBinding.detImage)
        contentDetailBinding.detDesc.text = diseaseEntity.diseaseDescription
        contentDetailBinding.detSolution.text = diseaseEntity.diseaseSolution
    }
}