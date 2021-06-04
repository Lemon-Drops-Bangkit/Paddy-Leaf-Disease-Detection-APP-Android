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
                diseaseName = it.label,
                diseaseDescription = it.description,
                diseaseSolution = it.solution,
                diseaseImage = it.image
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
                diseaseDescription = it.diseaseDescription,
                diseaseSolution = it.diseaseSolution,
                diseaseImage = it.diseaseImage
            )
        }

    fun mapDomainToEntity(input: Disease) = Disease(
        diseaseId = input.diseaseId,
        diseaseName = input.diseaseName,
        diseaseDescription = input.diseaseDescription,
        diseaseSolution = input.diseaseSolution,
        diseaseImage = input.diseaseImage
    )
}