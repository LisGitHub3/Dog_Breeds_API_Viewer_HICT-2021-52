package com.example.dogapp_hict_2021_52.repository



import com.example.dogapp_hict_2021_52.models.DogResponse
import com.example.dogapp_hict_2021_52.network.RetrofitClient

class DogRepository {
    private val api = RetrofitClient.apiService

    suspend fun fetchDogs(): DogResponse {
        return api.getRandomDogImages()
    }
}
