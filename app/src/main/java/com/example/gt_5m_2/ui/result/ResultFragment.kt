package com.example.gt_5m_2.ui.result

import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable.ClassLoaderCreator
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.setFragmentResultListener
import com.example.gt_5m_2.LoveApi
import com.example.gt_5m_2.R
import com.example.gt_5m_2.databinding.FragmentResultBinding
import com.example.gt_5m_2.model.LoveModel
import java.util.Objects

class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding
    var result: LoveModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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