package com.b21_cap0183.paddycare.presentation.disease

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.core.domain.usecase.PaddyUseCase
import com.b21_cap0183.paddycare.core.utils.DataDummy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiseaseViewModel @Inject constructor(paddyUseCase: PaddyUseCase) : ViewModel() {
    val diseases = paddyUseCase.getAllDisease().asLiveData()
}