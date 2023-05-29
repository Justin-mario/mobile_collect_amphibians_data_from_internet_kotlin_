package com.example.android.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.amphibians.ui.AmphibiansPhotoApp
import com.example.android.amphibians.ui.theme.AmphibiansTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansTheme {
               AmphibiansPhotoApp()
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun AmphibiansPhotoAppPreview() {
    AmphibiansTheme {
        AmphibiansPhotoApp()
    }
}