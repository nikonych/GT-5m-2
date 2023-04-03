package com.example.gt_5m_2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.gt_5m_2.LoveViewModel
import com.example.gt_5m_2.R
import com.example.gt_5m_2.databinding.FragmentMainBinding
import com.example.gt_5m_2.ui.result.ResultFragment

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner) {
                        val bundle = Bundle()
                        bundle.putParcelable("RESULT", it)
                        val resultFragment = ResultFragment()
                        resultFragment.arguments = bundle
                        parentFragmentManager.beginTransaction().replace(R.id.fragment, resultFragment).addToBackStack("MAIN").commit()
                    }
            }
        }

    }

}