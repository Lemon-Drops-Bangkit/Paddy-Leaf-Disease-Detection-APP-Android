package com.b21_cap0183.paddycare.core.utils

import androidx.core.net.toUri
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
                resultSolution = it.solution,
                resultImage = "",
                resultDate = ""
            )
            resultList.add(result)
        }
        return resultList
    }

//    fun mapResultResponseToEntity(input: ResultResponse): ResultEntity {
//        val resultEntity = ArrayList<ResultEntity>()
//        resultEntity.add(ResultEntity(
//            resultId = input.id,
//            resultName = input.label,
//            resultDesc = input.description,
//            resultSolution = input.solution,
//            resultImage = input.toString()
//        ))
//    }

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

    fun mapResultEntitiesToDomain(input: List<ResultEntity>): List<Result> =
        input.map {
            Result(
                resultId = it.resultId,
                resultName = it.resultName,
                resultDesc = it.resultDesc,
                resultSolution = it.resultSolution,
                resultImage = it.resultImage,
                resultDate = it.resultDate
            )
        }
}