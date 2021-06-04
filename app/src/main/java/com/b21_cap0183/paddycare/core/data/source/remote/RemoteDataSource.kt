package com.b21_cap0183.paddycare.core.data.source.remote

import android.util.Log
import com.b21_cap0183.paddycare.core.data.source.remote.network.ApiResponse
import com.b21_cap0183.paddycare.core.data.source.remote.network.ApiService
import com.b21_cap0183.paddycare.core.data.source.remote.response.DiseaseResponse
import com.b21_cap0183.paddycare.core.data.source.remote.response.ResultResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllDisease(): Flow<ApiResponse<List<DiseaseResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getAllDisease()
                val result = response.result
                if (result.isNotEmpty()) {
                    emit(ApiResponse.Success(response.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getResult(): Flow<ApiResponse<ResultResponse>> {
        return flow {
            try {
                val response = apiService.postPredict()
                if (response != null) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}