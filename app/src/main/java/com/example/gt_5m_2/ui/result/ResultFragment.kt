package com.example.gt_5m_2.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gt_5m_2.databinding.FragmentResultBinding
import com.example.gt_5m_2.remote.model.LoveModel

class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding
    var result: LoveModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentResultBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        result = arguments?.getParcelable("RESULT")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            tvFirstName.text = result?.fname
            tvSecondName.text = result?.sname
            tvPercent.text = result?.percentage

            btnAgain.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }

    }
}