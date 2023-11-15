package com.example.tugasretrofit.retrofit

import com.example.tugasretrofit.ResponseCharacter
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters() : Call<ResponseCharacter>
}