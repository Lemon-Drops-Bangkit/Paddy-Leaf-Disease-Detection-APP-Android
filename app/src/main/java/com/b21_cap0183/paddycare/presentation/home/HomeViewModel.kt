package com.b21_cap0183.paddycare.presentation.home

import androidx.lifecycle.*
import com.b21_cap0183.paddycare.core.domain.usecase.PaddyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(paddyUseCase: PaddyUseCase) : ViewModel() {

    private var _image = MutableLiveData<File>()
    private val image: LiveData<File> get() = _image

    fun setSelectedFile(image: File) {
        this._image.value = image
    }

    val result = Transformations.switchMap(image) { image ->
        paddyUseCase.postResult(image).asLiveData()
    }
}