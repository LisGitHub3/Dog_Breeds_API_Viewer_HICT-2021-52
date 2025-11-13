package com.example.dogapp_hict_2021_52.network

import com.example.dogapp_hict_2021_52.models.DogResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/breeds/image/random/10")
    suspend fun getRandomDogImages(): DogResponse
}