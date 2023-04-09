package com.example.gt_5m_2.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gt_5m_2.databinding.ItemHistoryBinding
import com.example.gt_5m_2.remote.model.LoveModel

class HistoryAdapter(private var list: List<LoveModel>) :
    Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            with(binding) {
                tvFirstName.text = loveModel.fname
                tvSecondName.text = loveModel.sname
                tvPercent.text = loveModel.percentage
            }
        }

    }
}
