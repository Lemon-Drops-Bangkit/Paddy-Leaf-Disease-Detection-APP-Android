package com.b21_cap0183.paddycare.presentation.result

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.databinding.ActivityResultDetectionBinding
import com.b21_cap0183.paddycare.databinding.ContentDetailResultBinding
import com.b21_cap0183.paddycare.presentation.main.MainActivity
import com.bumptech.glide.Glide

class ResultDetectionActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RESULT = "extra_result"
        const val EXTRA_ACT = "extra_activity"
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
        val fromAct = intent.getIntExtra(EXTRA_ACT, 0)
        activityResultDetectionBinding.toolbar.setNavigationOnClickListener {
            when (fromAct) {
                1 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else -> finish()
            }
        }

        val detailResult = intent.getParcelableExtra<Result>(EXTRA_RESULT)

        Glide.with(this)
            .load(Uri.parse(detailResult?.resultImage))
            .into(activityResultDetectionBinding.resImage)
        populateResult(detailResult)

    }

    private fun populateResult(resultEntity: Result?) {
        if (resultEntity != null) {
            contentDetailResultBinding.apply {
                resultName.text = resultEntity.resultName
                resultDesc.text = resultEntity.resultDesc
                resultSolution.text = resultEntity.resultSolution?.replace(",", ", ")
            }
        }
    }
}