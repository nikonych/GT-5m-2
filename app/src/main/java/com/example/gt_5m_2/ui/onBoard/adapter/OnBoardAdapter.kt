package com.example.gt_5m_2.ui.onBoard.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gt_5m_2.R
import com.example.gt_5m_2.databinding.ItemOnBoardBinding
import com.example.gt_5m_2.remote.model.OnBoard


class OnBoardAdapter(private val onStartClick: () -> Unit) :
    Adapter<OnBoardAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            "Have a good time\n",
            "You should take the time to help those\n" +
                    "who need you\n",
            R.drawable.img_1
        ),
        OnBoard(
            "Cherishing love\n",
            "It is now no longer possible for\n" +
                    "you to cherish love\n",
            R.drawable.img_2
        ),
        OnBoard(
            "Have a breakup?\n",
            "We have made the correction for you\n" +
                    "don't worry\n" +
                    "Maybe someone is waiting for you!\n",
            R.drawable.img_3
        ),
        OnBoard(
            desc="It's Funs and Many more\n",
            image=R.drawable.img
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


    inner class OnBoardingViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.apply {
                btnStart.isVisible = adapterPosition == 3
                tvTitle.isVisible = adapterPosition != 3
                btnStart.setOnClickListener {
                    onStartClick()

                }
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
                onBoard.image?.let { imgBoard.setImageResource(it) }
            }
        }
    }

}
