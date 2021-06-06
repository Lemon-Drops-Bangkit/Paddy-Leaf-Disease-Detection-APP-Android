package com.b21_cap0183.paddycare.core.utils

import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import com.b21_cap0183.paddycare.core.data.source.remote.response.DiseaseResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.ResultResponse
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.core.domain.model.Result

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

    fun mapResultResponsesToEntities(input: List<ResultResponse>) : List<ResultEntity> {
        val resultList = ArrayList<ResultEntity>()
        input.map {
            val result = ResultEntity(
                resultId = it.id,
                resultName = it.label,
                resultDesc = it.description,
                resultSolution = it.solution
            )
            resultList.add(result)
        }
        return resultList
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

    fun mapResultEntityToDomain(input: ResultEntity): Result =
        Result(
            resultId = input.resultId,
            resultName = input.resultName,
            resultDesc = input.resultDesc,
            resultSolution = input.resultSolution
        )

    fun mapDomainToEntity(input: ResultEntity) = Result(
        resultId = input.resultId,
        resultName = input.resultName,
        resultDesc = input.resultDesc,
        resultSolution = input.resultSolution
    )
}