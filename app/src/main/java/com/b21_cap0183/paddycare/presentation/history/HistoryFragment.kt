package com.b21_cap0183.paddycare.presentation.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21_cap0183.paddycare.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var fragmentHistoryBinding: FragmentHistoryBinding
    private val historyViewModel: HistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHistoryBinding = FragmentHistoryBinding.inflate(layoutInflater, container, false)

        return fragmentHistoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val listHistoryAdapter = ListHistoryAdapter()

            historyViewModel.history.observe(viewLifecycleOwner, { history ->
                listHistoryAdapter.setHistory(history.data)
                   //fragmentHistoryBinding.viewEmpty.root.visibility = View.GONE
                    fragmentHistoryBinding.textEmpty.visibility = if (history.data != null) View.GONE else View.VISIBLE
            })

            with(fragmentHistoryBinding.rvHistory) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = listHistoryAdapter
            }
        }
    }
}