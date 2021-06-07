package com.b21_cap0183.paddycare.presentation.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.databinding.ActivityResultDetectionBinding

class ResultDetectionActivity : AppCompatActivity() {

    private lateinit var activityResultDetectionBinding: ActivityResultDetectionBinding

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
    }
}