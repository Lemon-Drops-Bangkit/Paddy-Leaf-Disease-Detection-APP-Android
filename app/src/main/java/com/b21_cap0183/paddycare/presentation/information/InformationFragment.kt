package com.b21_cap0183.paddycare.presentation.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.b21_cap0183.paddycare.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {

    private lateinit var fragmentInformationBinding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentInformationBinding =
            FragmentInformationBinding.inflate(layoutInflater, container, false)
        return fragmentInformationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}