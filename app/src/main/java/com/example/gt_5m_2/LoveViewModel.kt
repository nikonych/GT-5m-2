package com.example.gt_5m_2

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gt_5m_2.remote.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(
    private val repository: Repository,
    private val preferences: SharedPreferences
) : ViewModel() {


    fun getLiveLoveModel(firstname: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstname, secondName)
    }

    fun isUserSeen(): Boolean {
        return preferences.getBoolean(USER_SEEN_KEY, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun userSeen() {
        preferences.edit().putBoolean(USER_SEEN_KEY, true).apply()
    }

    fun insertLove(loveModel: LoveModel) {
        repository.insertLove(loveModel)
    }

    fun getAllLove(): List<LoveModel> {
        return repository.getAllLove()
    }

    companion object {
        const val USER_SEEN_KEY = "USER_SEEN_KEY"
    }

}