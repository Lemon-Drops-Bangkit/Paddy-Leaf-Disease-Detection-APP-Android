package com.b21_cap0183.paddycare.presentation.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(), HistoryFragmentCallback {

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

            val listHistoryAdapter = ListHistoryAdapter(this)

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

    override fun onDeleteClick(result: Result) {
        if (activity != null) {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes"){ _, _->
                historyViewModel.setSelectedData(result)
                Toast.makeText(context,  "Successfully deleted", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){_, _-> }
            builder.setTitle("Delete Result Detection?")
            builder.setMessage("Do you want to delete ${result.resultName} detection results")
            builder.create().show()
        }
    }
}