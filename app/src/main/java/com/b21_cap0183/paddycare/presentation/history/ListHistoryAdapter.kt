package com.b21_cap0183.paddycare.presentation.history

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.domain.model.Result
import com.b21_cap0183.paddycare.databinding.ListHistoryDetectionBinding
import com.b21_cap0183.paddycare.presentation.result.ResultDetectionActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHistoryAdapter(private val callback: HistoryFragmentCallback) : RecyclerView.Adapter<ListHistoryAdapter.HistoryViewHolder>() {

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
                dDesc.text = "Detected on ${resultEntity.resultDate}"

                dDelete.setOnClickListener { callback.onDeleteClick(resultEntity) }

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