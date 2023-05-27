package com.sample.spaceridegalley.imagedetails.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    useCase: ImageDetailUseCase
) : ViewModel() {

    // Expose screen UI state
    private val _uiState: MutableStateFlow<DetailImageUiState> = MutableStateFlow(DetailImageUiState.UNINITIALIZED)
    val uiState: StateFlow<DetailImageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                DetailImageUiState.LOADED(allImageList = useCase.getImageItemList() )
            }
        }
    }
}

sealed class DetailImageUiState {
    object UNINITIALIZED : DetailImageUiState()
    data class LOADED(val allImageList : List<DetailItemModel>) : DetailImageUiState()
}