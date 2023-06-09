package com.example.gt_5m_2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.gt_5m_2.remote.LoveApi
import com.example.gt_5m_2.remote.LoveService
import com.example.gt_5m_2.remote.model.LoveModel
import com.example.gt_5m_2.room.AppDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: LoveApi,
    private val appDatabase: AppDatabase
) {

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        api.getPercentAge(firstName, secondName)
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

    fun insertLove(loveModel: LoveModel) {
        appDatabase.loveDAO().insertLove(loveModel)
    }

    fun getAllLove(): List<LoveModel> {
        return appDatabase.loveDAO().getAll()
    }
}