package com.example.gt_5m_2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.gt_5m_2.remote.LoveService
import com.example.gt_5m_2.remote.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        LoveService().api.getPercentAge(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.d("gg", "onFailure: ${t.message}")

                }
            })
            return mutableLiveData
    }
}