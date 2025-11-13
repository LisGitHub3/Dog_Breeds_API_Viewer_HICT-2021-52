package com.example.dogapp_hict_2021_52.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp_hict_2021_52.repository.DogRepository
import com.example.dogapp_hict_2021_52.ui1.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel(
    private val repo: DogRepository = DogRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchDogs()
    }

    fun fetchDogs() {
        _uiState.value = UiState.Loading

        viewModelScope.launch {
            try {
                val response = repo.fetchDogs()
                if (response.status == "success") {
                    _uiState.value = UiState.Success(response.message, response.status)
                } else {
                    _uiState.value = UiState.Error("Status: ${response.status}")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}
