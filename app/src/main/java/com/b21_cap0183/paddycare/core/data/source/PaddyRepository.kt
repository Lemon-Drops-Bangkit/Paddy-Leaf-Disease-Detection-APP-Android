package com.b21_cap0183.paddycare.core.data.source

import androidx.lifecycle.LiveData
import com.b21_cap0183.paddycare.core.data.source.local.LocalDataSource
import com.b21_cap0183.paddycare.core.data.source.local.entity.ResultEntity
import com.b21_cap0183.paddycare.core.data.source.remote.RemoteDataSource
import com.b21_cap0183.paddycare.core.data.source.remote.network.ApiResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.DiseaseResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.ResultResponse
import com.b21_cap0183.paddycare.core.domain.model.Disease
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.core.domain.repository.IPaddyRepository
import com.b21_cap0183.paddycare.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaddyRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IPaddyRepository {

    override fun getAllDisease(): Flow<Resource<List<Disease>>> =
        object : NetworkBoundResource<List<Disease>, List<DiseaseResponse>>() {
            override fun loadFromDB(): Flow<List<Disease>> {
                return localDataSource.getAllDisease().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Disease>?): Boolean =
                data == null || data.isEmpty()
//                true

            override suspend fun createCall(): Flow<ApiResponse<List<DiseaseResponse>>> =
                remoteDataSource.getAllDisease()

            override suspend fun saveCallResult(data: List<DiseaseResponse>) {
                val diseaseList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertDisease(diseaseList)
            }

        }.asFlow()

    override fun getDiseaseById(id: Int): LiveData<Resource<Disease>> {
        TODO("Not yet implemented")
    }

    override fun getAllResult(): LiveData<Resource<List<Result>>> {
        TODO("Not yet implemented")
    }

    override fun getResultById(id: Int): Flow<Resource<Result>> =
        object: NetworkBoundResource<Result, ResultResponse>() {
            override fun loadFromDB(): Flow<Result> {
                TODO("belum tau euy")
            }

            override fun shouldFetch(data: Result?): Boolean =
                data == null || data.resultId != null

            override suspend fun createCall(): Flow<ApiResponse<ResultResponse>> =
                remoteDataSource.getResult()

            override suspend fun saveCallResult(data: ResultResponse) {
                val resultEntity = ResultEntity(
                    resultId = data.id.toInt(),
                    resultName = data.label,
                    resultDesc = data.description,
                    resultSolution = data.solution
                )
                localDataSource.updateResult(resultEntity)
            }
        }.asFlow()

}