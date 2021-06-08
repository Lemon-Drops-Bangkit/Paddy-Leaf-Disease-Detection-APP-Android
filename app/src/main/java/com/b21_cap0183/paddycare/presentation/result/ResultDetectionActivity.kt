package com.b21_cap0183.paddycare.presentation.result

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.databinding.ActivityResultDetectionBinding
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

        contentDetailResultBinding = activityResultDetectionBinding.contentDetailResult

        setSupportActionBar(activityResultDetectionBinding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.resultdetection)
        }

        activityResultDetectionBinding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val detailResult = intent.getParcelableExtra<Result>(EXTRA_RESULT)
        populateResult(detailResult)

    }

    private fun populateResult(resultEntity: Result?) {
        if (resultEntity != null) {
            contentDetailResultBinding.apply {
                resultName.text = resultEntity.resultName
                resultDesc.text = resultEntity.resultDesc
                resultSolution.text = resultEntity.resultSolution
            }
        }
    }
}