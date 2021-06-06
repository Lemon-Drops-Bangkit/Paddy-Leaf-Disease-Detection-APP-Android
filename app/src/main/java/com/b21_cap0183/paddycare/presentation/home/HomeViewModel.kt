package com.b21_cap0183.paddycare.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.b21_cap0183.paddycare.core.domain.usecase.PaddyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(paddyUseCase: PaddyUseCase) : ViewModel() {

    private var image: File = File.createTempFile("asds", ".jpg")

    fun setSelectedFile(image: File) {
        this.image = image
    }

    val result = image?.let { paddyUseCase.postResult(it).asLiveData() }
}