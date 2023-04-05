package com.example.gt_5m_2.ui.onBoard

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gt_5m_2.LoveViewModel
import com.example.gt_5m_2.R
import com.example.gt_5m_2.databinding.FragmentOnBoardBinding
import com.example.gt_5m_2.ui.main.MainFragment.Companion.PREF_SEEN_KEY
import com.example.gt_5m_2.ui.onBoard.adapter.OnBoardAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment  : Fragment() {

    lateinit var binding: FragmentOnBoardBinding
    private val viewModel: LoveViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onBoardAdapter = OnBoardAdapter {
            viewModel.userSeen()
            findNavController().navigate(R.id.mainFragment)
        }
        binding.viewPager.adapter = onBoardAdapter
        binding.indicator.attachTo(binding.viewPager)

    }

}