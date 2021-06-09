package com.b21_cap0183.paddycare.presentation.history

import com.b21_cap0183.paddycare.core.domain.model.Result

interface HistoryFragmentCallback {
    fun onDeleteClick(result: Result)
}