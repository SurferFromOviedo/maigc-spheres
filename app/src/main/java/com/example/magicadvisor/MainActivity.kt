package com.example.magicadvisor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.magicadvisor.ui.MagicAdvisorApp
import com.example.magicadvisor.ui.MainViewModel
import com.example.magicadvisor.ui.MyApplication
import com.example.magicadvisor.ui.theme.MagicAdvisorTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModel.Factory
    }
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MagicAdvisorTheme {
                val windowSize = calculateWindowSizeClass(this)
                MagicAdvisorApp(windowSize = windowSize.widthSizeClass, viewModel = viewModel)
            }
        }
    }
}
