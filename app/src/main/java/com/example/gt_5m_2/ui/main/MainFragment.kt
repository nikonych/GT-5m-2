package com.example.gt_5m_2.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gt_5m_2.LoveService
import com.example.gt_5m_2.R
import com.example.gt_5m_2.databinding.FragmentMainBinding
import com.example.gt_5m_2.model.LoveModel
import com.example.gt_5m_2.ui.result.ResultFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnCalculate.setOnClickListener {
                LoveService().api.getPercentAge(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    @SuppressLint("CommitTransaction")
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            val bundle = Bundle()
                            bundle.putParcelable("RESULT", response.body())
                            val resultFragment = ResultFragment()
                            resultFragment.arguments = bundle
                            parentFragmentManager.beginTransaction().replace(R.id.fragment, resultFragment).addToBackStack("MAIN").commit()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.d("gg", t.message.toString())

                    }

                })
            }
        }

    }

}