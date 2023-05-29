package com.example.android.amphibians.ui.screens


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.android.amphibians.AmphibiansDetailsApplication
import com.example.android.amphibians.model.AmphibiansDetails
import com.example.android.amphibians.data.AmphibiansRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface AmphibiansUiState {
    data class Success(val details: List<AmphibiansDetails>) : AmphibiansUiState
    object Loading: AmphibiansUiState
    object Error: AmphibiansUiState
}


class AmphibiansViewModel(private val amphibiansDetailsRepository: AmphibiansRepository) : ViewModel() {

    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansDetails()
    }
    fun getAmphibiansDetails() {
        viewModelScope.launch {
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansDetailsRepository.getAmphibiansDetails())
            }
            catch (e: IOException){
                AmphibiansUiState.Error
            }
            catch (e: HttpException){
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansDetailsApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansDetailsRepository = amphibiansRepository)
            }
        }
    }
}