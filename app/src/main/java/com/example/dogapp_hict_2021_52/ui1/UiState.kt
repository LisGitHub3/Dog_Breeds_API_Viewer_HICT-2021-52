package com.example.dogapp_hict_2021_52.ui1



sealed class UiState {
    object Loading : UiState()
    data class Success(val images: List<String>, val status: String) : UiState()
    data class Error(val message: String) : UiState()
}
