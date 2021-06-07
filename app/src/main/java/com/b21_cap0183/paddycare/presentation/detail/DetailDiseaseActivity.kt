package com.b21_cap0183.paddycare.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.databinding.ActivityDetailDiseaseBinding
import com.b21_cap0183.paddycare.databinding.ContentDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailDiseaseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DISEASE = "extra_disease"
    }

    private lateinit var activityDetailDiseaseBinding: ActivityDetailDiseaseBinding
    private lateinit var contentDetailBinding: ContentDetailBinding

    private val detailDiseaseViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailDiseaseBinding = ActivityDetailDiseaseBinding.inflate(layoutInflater)
        setContentView(activityDetailDiseaseBinding.root)
        contentDetailBinding = activityDetailDiseaseBinding.contentDetail

        setSupportActionBar(activityDetailDiseaseBinding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        val detailDisease = intent.getParcelableExtra<Disease>(EXTRA_DISEASE)
        populateDisease(detailDisease)
    }

    private fun populateDisease(diseaseEntity: Disease?) {
        if (diseaseEntity != null) {
            supportActionBar?.title = diseaseEntity.diseaseName
            Glide.with(this)
                .load(diseaseEntity.diseaseImage)
                .into(activityDetailDiseaseBinding.detImage)
            contentDetailBinding.detDesc.text = diseaseEntity.diseaseDescription
            contentDetailBinding.detSolution.text = diseaseEntity.diseaseSolution
        }
    }
}