package com.example.gt_5m_2.remote

import com.example.gt_5m_2.remote.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {


    @GET("/getPercentage")
    fun getPercentAge(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "3ddf6db1d5msh56d683fd6231096p142325jsnb608370e3e42",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"

    ) :Call<LoveModel>
}