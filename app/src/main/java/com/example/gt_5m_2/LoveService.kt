package com.example.gt_5m_2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class LoveService {

    val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(LoveApi::class.java)

}