package com.b21_cap0183.paddycare.presentation.detail

import androidx.lifecycle.ViewModel
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.utils.DataDummy

class DetailViewModel : ViewModel() {

    private var id: Int = 0

    fun setSelectedId(id: Int) {
        this.id = id
    }

//    fun getDisease(): DiseaseEntity {
//        lateinit var disease: DiseaseEntity
//        val diseaseEntities = DataDummy.generateDiseases()
//        for(diseaseEntity in diseaseEntities) {
//            if (diseaseEntity.diseaseId == id) disease = diseaseEntity
//        }
//        return disease
//    }
}