package com.example.android.amphibians.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android.amphibians.ui.screens.AmphibiansViewModel
import com.example.android.amphibians.ui.screens.HomeScreen
import com.example.marsphotos.R


@Composable
fun AmphibiansPhotoApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(
            title = { Text(stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            val amphibiansViewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
            HomeScreen(
               amphibiansUiState = amphibiansViewModel.amphibiansUiState,
                retryAction = amphibiansViewModel::getAmphibiansDetails
            )
        }
    }
}
