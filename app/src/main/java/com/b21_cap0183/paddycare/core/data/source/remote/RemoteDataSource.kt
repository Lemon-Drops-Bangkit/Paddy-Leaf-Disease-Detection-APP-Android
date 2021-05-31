package com.b21_cap0183.paddycare.core.data.source.remote

import com.b21_cap0183.paddycare.core.data.source.remote.network.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

//    suspend fun getAllDisease(): Flow<ApiResponse<List<DiseaseResponse>>> {
//        //get data from remote api
//        return flow {
//            emit(List<DiseaseResponse>())
//        }.flowOn(Dispatchers.IO)
//    }
}