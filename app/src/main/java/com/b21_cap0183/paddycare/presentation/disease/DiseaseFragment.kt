package com.b21_cap0183.paddycare.presentation.disease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21_cap0183.paddycare.databinding.FragmentDiseaseBinding

class DiseaseFragment : Fragment() {

    private lateinit var fragmentDiseaseBinding: FragmentDiseaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDiseaseBinding = FragmentDiseaseBinding.inflate(layoutInflater, container, false)

        return fragmentDiseaseBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[DiseaseViewModel::class.java]
            val diseases = viewModel.getDiseases()

            val listDiseaseAdapter = ListDiseaseAdapter()
            listDiseaseAdapter.setDisease(diseases)

            with(fragmentDiseaseBinding.rvListDisease) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = listDiseaseAdapter
            }
        }
    }
}