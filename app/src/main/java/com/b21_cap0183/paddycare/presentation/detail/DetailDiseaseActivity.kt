package com.b21_cap0183.paddycare.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.b21_cap0183.paddycare.databinding.ActivityDetailDiseaseBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailDiseaseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DISEASE = "extra_disease"
    }

    private lateinit var activityDetailDiseaseBinding: ActivityDetailDiseaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailDiseaseBinding = ActivityDetailDiseaseBinding.inflate(layoutInflater)
        setContentView(activityDetailDiseaseBinding.root)

        BottomSheetBehavior.from(activityDetailDiseaseBinding.sheet).apply {
            peekHeight = 310
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}