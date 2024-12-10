// presentation/ui/MainActivity.kt
package com.example.userprofileapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.userprofileapp.presentation.ui.theme.UserProfileApp2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfileApp2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    UserProfileApp()
                }
            }
        }
    }
}
