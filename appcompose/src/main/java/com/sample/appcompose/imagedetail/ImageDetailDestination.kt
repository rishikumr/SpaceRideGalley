package com.sample.appcompose.imagedetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sample.appcompose.common.WaitWhileLoadingScreen
import com.sample.imagefeaturelibrary.imagedetails.domain.model.DetailItemModel
import com.sample.imagefeaturelibrary.imagedetails.view.DetailImageUiState
import com.sample.imagefeaturelibrary.imagedetails.view.ImageDetailViewModel

@Composable
fun ImageDetailDestination(viewModel: ImageDetailViewModel, selectedPosition: Int) {
    when (val uiState = viewModel.uiState.collectAsState().value) {
        is DetailImageUiState.LOADED -> {
            ImageDetailScreen(uiState.allImageList, selectedPosition)
        }

        DetailImageUiState.UNINITIALIZED -> {
            WaitWhileLoadingScreen()
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageDetailScreen(imageList: List<DetailItemModel>, selectedPosition: Int) {
    val state: PagerState = rememberPagerState(initialPage = selectedPosition)

    HorizontalPager(
        state = state,
        pageCount = imageList.size,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        val item = imageList[page]
        ImageDetailCard(item)
    }
}

@Composable
private fun ImageDetailCard(
    item: DetailItemModel
) {
    Column(modifier = Modifier
        .background(Color(0xFFEBE2E2))
        .padding(8.dp)) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            model = item.hdurl,
            contentDescription = item.title,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )
        item.title?.let { title ->
            Text(
                text = title,
                style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }
        item.owner?.let { owner ->
            Text(
                text = owner,
                textAlign = TextAlign.Center,
                style = androidx.compose.material3.MaterialTheme.typography.headlineSmall,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }
        item.explanation?.let { explanation ->
            Text(
                text = explanation,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(vertical = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun ImageDetailCardPreview() {
    ImageDetailCard(
        DetailItemModel(
            owner = "Steve Mazlin",
            date = "2019-12-03",
            explanation = "Is this what will become of our Sun? Quite possibly.  The first hint of our Sun's future was discovered inadvertently in 1764. At that time, Charles Messier was compiling a list of diffuse objects not to be confused with comets. The 27th object on Messier's list, now known as M27 or the Dumbbell Nebula, is a planetary nebula, the type of nebula our Sun will produce when nuclear fusion stops in its core. M27 is one of the brightest planetary nebulae on the sky, and can be seen toward the constellation of the Fox (Vulpecula) with binoculars. It takes light about 1000 years to reach us from M27, featured here in colors emitted by hydrogen and oxygen. Understanding the physics and significance of M27 was well beyond 18th century science. Even today, many things remain mysterious about bipolar planetary nebula like M27, including the physical mechanism that expels a low-mass star's gaseous outer-envelope, leaving an X-ray hot white dwarf.   APOD across world languages: Arabic, Catalan, Chinese (Beijing), Chinese (Taiwan), Croatian, Czech, Dutch, Farsi, French, French, German, Hebrew, Indonesian, Japanese, Korean, Montenegrin, Polish, Russian, Serbian, Slovenian,  Spanish and Ukrainian",
            hdurl = "https://apod.nasa.gov/apod/image/1912/M27_Mazlin_2000.jpg",
            title = "M27: The Dumbbell Nebula",
        )
    )
}
