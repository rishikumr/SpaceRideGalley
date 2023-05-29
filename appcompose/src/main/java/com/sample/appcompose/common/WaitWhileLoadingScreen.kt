package com.sample.appcompose.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.sample.appcompose.R

@Composable
fun WaitWhileLoadingScreen() {
    Text(
        text = stringResource(R.string.waitMessage),
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center
    )
}