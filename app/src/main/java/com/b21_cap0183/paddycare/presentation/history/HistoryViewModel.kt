package com.b21_cap0183.paddycare.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "History of disease detection is blank"
    }
    val text: LiveData<String> = _text
}