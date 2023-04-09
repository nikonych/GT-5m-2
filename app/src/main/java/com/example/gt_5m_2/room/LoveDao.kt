package com.example.gt_5m_2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gt_5m_2.remote.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insertLove(vararg loveModel: LoveModel)

    @Query("SELECT * FROM love ORDER BY fname")
    fun getAll() : List<LoveModel>
}