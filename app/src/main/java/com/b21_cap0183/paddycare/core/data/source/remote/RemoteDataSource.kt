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
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okio.IOException
import java.io.File
import java.io.InputStream
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

    suspend fun getResult(image: File): Flow<ApiResponse<ResultResponse>> {
        return flow {
            try {
                val part = MultipartBody.Part.createFormData(
                    "images",
                    image.name,
                    image.asRequestBody("images/*".toMediaType())
                )
                val response = apiService.postPredict(part)
                if (response != null) {
                    emit(ApiResponse.Success(response))
                    Log.d("asdasdasd", response.label)
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: IOException){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}