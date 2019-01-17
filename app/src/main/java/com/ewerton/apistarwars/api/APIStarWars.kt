package com.ewerton.apistarwars.api

import com.ewerton.apistarwars.model.Films
import retrofit2.http.GET
import retrofit2.Call



interface APIStarWars {

    @GET("films/")
    abstract fun getFilms(): Call<Films>

}