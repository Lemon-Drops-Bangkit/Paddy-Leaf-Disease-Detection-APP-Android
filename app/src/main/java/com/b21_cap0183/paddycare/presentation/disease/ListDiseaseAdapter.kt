package com.b21_cap0183.paddycare.presentation.disease

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21_cap0183.paddycare.R
import com.b21_cap0183.paddycare.core.data.source.local.entity.DiseaseEntity
import com.b21_cap0183.paddycare.databinding.ListViewDiseasesBinding
import com.b21_cap0183.paddycare.presentation.detail.DetailDiseaseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListDiseaseAdapter : RecyclerView.Adapter<ListDiseaseAdapter.DiseaseViewHolder>() {

    private var listDisease = ArrayList<DiseaseEntity>()

    fun setDisease(disease: List<DiseaseEntity>?) {
        if (disease == null) return
        this.listDisease.clear()
        this.listDisease.addAll(disease)
    }

    class DiseaseViewHolder(private val binding: ListViewDiseasesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(diseaseEntity: DiseaseEntity) {
            with(binding) {
                dTitle.text = diseaseEntity.diseaseName
                dDesc.text = diseaseEntity.diseaseDescription

                Glide.with(itemView.context)
                    .load(diseaseEntity.diseasePicture)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(dPicture)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailDiseaseActivity::class.java)
                    intent.putExtra(
                        DetailDiseaseActivity.EXTRA_DISEASE, diseaseEntity.diseaseId
                    )
                    itemView.context.startActivity(intent)
                    Log.d("Berhasil", "berhasil diakses")
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiseaseViewHolder {
        val listViewDiseasesBinding =
            ListViewDiseasesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiseaseViewHolder(listViewDiseasesBinding)
    }

    override fun onBindViewHolder(holder: DiseaseViewHolder, position: Int) {
        val disease = listDisease[position]
        holder.bind(disease)
    }

    override fun getItemCount(): Int = listDisease.size
}