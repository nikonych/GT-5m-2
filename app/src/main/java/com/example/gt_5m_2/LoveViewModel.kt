package com.example.gt_5m_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gt_5m_2.remote.model.LoveModel

class LoveViewModel : ViewModel(){
    val repository = Repository()


    fun getLiveLoveModel(fisrtname:String, secondName:String): LiveData<LoveModel> {
        return repository.getPercentage(fisrtname, secondName)
    }
}