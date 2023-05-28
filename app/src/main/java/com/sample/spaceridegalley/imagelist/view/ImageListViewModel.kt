package com.sample.spaceridegalley.imagelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.spaceridegalley.imagelist.domain.ImageListUseCase
import com.sample.spaceridegalley.imagelist.domain.model.ListItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * This is a ViewModel class which holds the UI data to be shown in ImageListFragment
 * */
@HiltViewModel
class ImageListViewModel @Inject constructor(
    useCase: ImageListUseCase
) : ViewModel() {

    // Expose screen UI state
    private val _uiState: MutableStateFlow<ListImageUiState> = MutableStateFlow(ListImageUiState.UNINITIALIZED) // we could also use LiveData
    val uiState: StateFlow<ListImageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                ListImageUiState.LOADED(imageList = useCase.getImageItemList())
            }
        }
    }
}

sealed class ListImageUiState {
    object UNINITIALIZED : ListImageUiState()
    data class LOADED(val imageList: List<ListItemModel>) : ListImageUiState()
}
