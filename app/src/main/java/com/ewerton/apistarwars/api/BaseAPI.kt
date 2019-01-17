package com.ewerton.apistarwars.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class BaseAPI {
    val URLAPI = "https://swapi.co/api/"

    val retrofit = Retrofit.Builder()
        .baseUrl(URLAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun apiStarWars(): APIStarWars {
        return retrofit.create(APIStarWars::class.java)
    }

    //Retorno obrigatório definido como APIStarWars
    //fun apiStarWars(): APIStarWars = retrofit.create(APIStarWars::class.java)

    //Retorno opcional
    //fun apiStarWars() = retrofit.create(APIStarWars::class.java)
}