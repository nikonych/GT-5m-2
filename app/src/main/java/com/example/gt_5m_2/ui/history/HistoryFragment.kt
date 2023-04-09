package com.example.gt_5m_2.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.gt_5m_2.App
import com.example.gt_5m_2.LoveViewModel
import com.example.gt_5m_2.R
import com.example.gt_5m_2.databinding.FragmentHistoryBinding
import com.example.gt_5m_2.ui.history.adapter.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    private val viewModel: LoveViewModel by viewModels()
    lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list = viewModel.getAllLove()
        adapter = HistoryAdapter(list)
        binding.rv.adapter = adapter

    }

}