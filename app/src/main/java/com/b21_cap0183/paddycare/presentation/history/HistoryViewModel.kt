package com.b21_cap0183.paddycare.presentation.history

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.core.domain.usecase.PaddyUseCase
import com.b21_cap0183.paddycare.core.utils.DataMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val paddyUseCase: PaddyUseCase) : ViewModel() {
    val history = paddyUseCase.getAllResult().asLiveData()

    fun setSelectedData(data: Result) {
        Log.d("data", data.toString())
        paddyUseCase.deleteResult(DataMapper.mapDomainToEntity(data))
    }
}