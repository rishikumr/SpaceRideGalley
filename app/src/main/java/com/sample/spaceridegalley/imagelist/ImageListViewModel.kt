package com.sample.spaceridegalley.imagelist

import android.app.appsearch.SearchResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    useCase: ImageListUseCase
) : ViewModel() {

    // Expose screen UI state
    private val _uiState: MutableStateFlow<ListImageUiState> = MutableStateFlow(ListImageUiState.UNINITIALIZED)  // we could also use LiveData
    val uiState: StateFlow<ListImageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                ListImageUiState.LOADED(imageList = useCase.getImageItemList() )
            }
        }
    }
}

sealed class ListImageUiState {
    object UNINITIALIZED : ListImageUiState()
    data class LOADED(val imageList : List<ListItemModel>) : ListImageUiState()
}
