package com.b21_cap0183.paddycare.presentation.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.databinding.ActivityResultDetectionBinding
import com.b21_cap0183.paddycare.databinding.ContentDetailBinding
import com.b21_cap0183.paddycare.databinding.ContentDetailResultBinding

class ResultDetectionActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RESULT = "extra_result"
    }

    private lateinit var activityResultDetectionBinding: ActivityResultDetectionBinding
    private lateinit var contentDetailResultBinding: ContentDetailResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityResultDetectionBinding = ActivityResultDetectionBinding.inflate(layoutInflater)
        setContentView(activityResultDetectionBinding.root)

        setSupportActionBar(activityResultDetectionBinding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            title = getString(R.string.resultdetection)
        }

        val detailResult = intent.getParcelableExtra<Result>(EXTRA_RESULT)
        populateResult(detailResult)
    }

    private fun populateResult(resultEntity: Result?) {
        if (resultEntity != null) {
            contentDetailResultBinding.resultName.text = resultEntity.resultName
            contentDetailResultBinding.resultDesc.text = resultEntity.resultDesc
            contentDetailResultBinding.resultSolution.text = resultEntity.resultSolution
        }
    }
}