package com.b21_cap0183.paddycare.presentation.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.b21_cap0183.paddycare.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

   private lateinit var fragmentHistoryBinding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHistoryBinding = FragmentHistoryBinding.inflate(layoutInflater, container, false)

        return fragmentHistoryBinding.root
    }
}