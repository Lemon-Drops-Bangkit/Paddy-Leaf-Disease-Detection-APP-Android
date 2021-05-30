package com.b21_cap0183.paddycare.presentation.disease

import androidx.lifecycle.ViewModel
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.utils.DataDummy

class DiseaseViewModel : ViewModel() {

    fun getDiseases(): List<DiseaseEntity> = DataDummy.generateDiseases()
}