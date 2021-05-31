package com.b21_cap0183.paddycare.core.utils

import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.data.source.remote.response.DiseaseResponse
import com.b21_cap0183.paddycare.core.domain.model.Disease

object DataMapper {
    fun mapResponsesToEntities(input: List<DiseaseResponse>): List<DiseaseEntity> {
        val diseaseList = ArrayList<DiseaseEntity>()
        input.map {
            val disease = DiseaseEntity(
                diseaseId = it.id,
                diseaseName = it.name,
                diseaseDesc = it.desc,
                diseasePicture = it.picture
            )
            diseaseList.add(disease)
        }
        return diseaseList
    }

    fun mapEntitiesToDomain(input: List<DiseaseEntity>): List<Disease> =
        input.map {
            Disease(
                diseaseId = it.diseaseId,
                diseaseName = it.diseaseName,
                diseaseDesc = it.diseaseDesc,
                diseasePicture = it.diseasePicture
            )
        }

    fun mapDomainToEntity(input: Disease) = Disease(
        diseaseId = input.diseaseId,
        diseaseName = input.diseaseName,
        diseaseDesc = input.diseaseDesc,
        diseasePicture = input.diseasePicture
    )
}