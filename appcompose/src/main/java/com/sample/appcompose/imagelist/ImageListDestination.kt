package com.sample.appcompose.imagelist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sample.appcompose.R
import com.sample.appcompose.common.WaitWhileLoadingScreen
import com.sample.imagefeaturelibrary.imagelist.domain.model.ListItemModel
import com.sample.imagefeaturelibrary.imagelist.view.ImageListViewModel
import com.sample.imagefeaturelibrary.imagelist.view.ListImageUiState

@Composable
fun ImageListDestination(
    onNavigateToDetails: (Int) -> Unit,
    viewModel: ImageListViewModel
) {

    when (val uiState = viewModel.uiState.collectAsState().value) {
        is ListImageUiState.LOADED -> {
            ImageListScreen(uiState.imageList, onNavigateToDetails)
        }

        ListImageUiState.UNINITIALIZED -> {
            WaitWhileLoadingScreen()
        }
    }
}

@Composable
fun ImageListScreen(imageList: List<ListItemModel>, onNavigateToDetails: (Int) -> Unit) {

    LazyVerticalGrid(
        modifier = Modifier
            .background(Color(0xFFE1C0C0))
            .padding(horizontal = 4.dp),
        columns = GridCells.Fixed(2),
    ) {
        itemsIndexed(items = imageList, key = { _, item -> item.lowQUrl }) { index, item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .shadow(4.dp, RoundedCornerShape(6.dp))
                    .background(Color(0xFFE1C0C0))
                    .height(200.dp)
                    .clickable {
                        onNavigateToDetails.invoke(index)
                    }
            ) {
                AsyncImage(
                    model = item.lowQUrl,
                    contentDescription = item.title,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = item.title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFEBE2E2))
                        .padding(vertical = 4.dp)
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }

}
