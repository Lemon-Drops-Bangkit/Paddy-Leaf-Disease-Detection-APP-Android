package com.b21_cap0183.paddycare.presentation.history

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.databinding.ListHistoryDetectionBinding
import com.b21_cap0183.paddycare.presentation.result.ResultDetectionActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHistoryAdapter : RecyclerView.Adapter<ListHistoryAdapter.HistoryViewHolder>() {

    private var listHistory = ArrayList<Result>()

    fun setHistory(result: List<Result>?) {
        if (result == null) return
        this.listHistory.clear()
        this.listHistory.addAll(result)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ListHistoryDetectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(resultEntity: Result) {
            with(binding) {
                dTitle.text = resultEntity.resultName
                dDesc.text = "Detected on "+resultEntity.resultDate

                dDelete.setOnClickListener {
                    val builder = AlertDialog.Builder(itemView.context)
                    builder.setPositiveButton("Yes"){ _, _->
                        Toast.makeText(itemView.context,  "Successfully deleted", Toast.LENGTH_SHORT).show()
                    }
                    builder.setNegativeButton("No"){_, _-> }
                    builder.setTitle("Delete Result Detection?")
                    builder.setMessage("Do you want to delete ${resultEntity.resultName} detection results")
                    builder.create().show()
                }
                //dDesc.text = resultEntity.resultDesc

                    Glide.with(itemView.context)
                        .load(resultEntity.resultImage)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(dPicture)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ResultDetectionActivity::class.java)
                    intent.putExtra(
                        ResultDetectionActivity.EXTRA_RESULT, resultEntity
                    )
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHistoryAdapter.HistoryViewHolder {
        val listHistoryDetectionBinding = ListHistoryDetectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(listHistoryDetectionBinding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = listHistory[position]
        holder.bind(history)
    }

    override fun getItemCount(): Int = listHistory.size

}