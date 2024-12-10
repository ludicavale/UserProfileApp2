// presentation/ui/UserProfileScreen.kt
package com.example.userprofileapp.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.userprofileapp.presentation.viewmodel.UserViewModel

@Composable
fun UserProfileApp() {
    val userViewModel: UserViewModel = hiltViewModel()
    UserProfileScreen(userViewModel)
}

@Composable
fun UserProfileScreen(userViewModel: UserViewModel) {
    val context = LocalContext.current
    val user by userViewModel.user.observeAsState()
    val isLoading by userViewModel.isLoading.observeAsState(false)
    val error by userViewModel.error.observeAsState()
    var userIdInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Input Field for User ID
        OutlinedTextField(
            value = userIdInput,
            onValueChange = { userIdInput = it },
            label = { Text("Enter User ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Load User Button
        Button(
            onClick = {
                if (userIdInput.isValidUserId()) {
                    val userId = userIdInput.toInt()
                    userViewModel.loadUser(userId)
                } else {
                    Toast.makeText(context, "Please enter a valid User ID", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Load User")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Progress Indicator
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display User Information
        user?.let {
            Text(
                text = "Name: ${it.name}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Email: ${it.email}",
                style = MaterialTheme.typography.headlineSmall
            )
        }?: run {
            if (!isLoading && userViewModel.user.value == null) {
                Text(
                    text = "User not found",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        // Display Error Message
        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

// Extension function for input validation
fun String.isValidUserId(): Boolean {
    return this.toIntOrNull() != null && this.toInt() > 0
}
