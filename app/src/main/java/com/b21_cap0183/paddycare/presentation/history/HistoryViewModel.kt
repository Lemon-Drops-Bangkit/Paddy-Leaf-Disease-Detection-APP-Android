package com.b21_cap0183.paddycare.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.b21_cap0183.paddycare.core.domain.usecase.PaddyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(paddyUseCase: PaddyUseCase) : ViewModel() {
    val history = paddyUseCase.getAllResult().asLiveData()

    //val deleteHistory() = paddyUseCase.deleteResult()
}