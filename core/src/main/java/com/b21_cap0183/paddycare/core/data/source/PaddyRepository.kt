package com.b21_cap0183.paddycare.core.data.source

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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.File
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

    override fun getAllResult(): Flow<Resource<List<Result>>> =
        object : NetworkBoundResource<List<Result>, List<ResultResponse>>() {
            override fun loadFromDB(): Flow<List<Result>> {
                return localDataSource.getAllResult()
                    .map { DataMapper.mapResultEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Result>?): Boolean =
                false

            override suspend fun createCall(): Flow<ApiResponse<List<ResultResponse>>> {
                return emptyFlow()
            }

            override suspend fun saveCallResult(data: List<ResultResponse>) {
                DataMapper.mapResultResponsesToEntities(data)
            }

        }.asFlow()

    override fun postResult(image: File): Flow<Resource<Result>> =
        object : NetworkBoundResource<Result, ResultResponse>() {
            override fun loadFromDB(): Flow<Result> {
                return localDataSource.getResult().map {
                    when {
                        it.size == 1 -> DataMapper.mapEntityToDomain(it[0])
                        it.size > 1 -> DataMapper.mapEntityToDomain(it[it.size - 1])
                        else -> Result()
                    }
                }
            }

            override fun shouldFetch(data: Result?): Boolean =
                data?.resultImage != image.toString()

            override suspend fun createCall(): Flow<ApiResponse<ResultResponse>> =
                remoteDataSource.getResult(image)

            override suspend fun saveCallResult(data: ResultResponse) {
                val resultEntity = DataMapper.mapResultResponseToEntity(data, image)
                localDataSource.insertResult(resultEntity)
            }
        }.asFlow()

    override fun deleteResult(resultEntity: ResultEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteResult(resultEntity)
        }
    }
}