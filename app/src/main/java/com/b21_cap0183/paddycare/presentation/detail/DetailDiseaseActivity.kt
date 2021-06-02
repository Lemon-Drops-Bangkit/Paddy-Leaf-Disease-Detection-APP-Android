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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val diseaseId = extras.getInt(EXTRA_DISEASE)
                viewModel.setSelectedId(diseaseId)
                populateDisease(viewModel.getDisease())

        }

        BottomSheetBehavior.from(activityDetailDiseaseBinding.sheet).apply {
            peekHeight = 500
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun populateDisease(diseaseEntity: DiseaseEntity) {
        activityDetailDiseaseBinding.detTitle.text = diseaseEntity.diseaseName
        activityDetailDiseaseBinding.detStatus.text = "Healthy"
        Glide.with(this)
                .load(diseaseEntity.diseasePicture)
                .into(activityDetailDiseaseBinding.detImage)
        contentDetailBinding.detDesc.text = diseaseEntity.diseaseDesc
        contentDetailBinding.txtInfo.text = "Healthy"

    }
}