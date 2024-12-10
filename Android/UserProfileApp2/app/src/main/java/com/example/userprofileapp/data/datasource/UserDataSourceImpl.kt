// data/datasource/UserDataSourceImpl.kt
package com.example.userprofileapp.data.datasource

import com.example.userprofileapp.domain.model.User
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor() : UserDataSource {
    private val users = listOf(
        User(id = 1, name = "Luis Camacho", email = "luis@example.com"),
        User(id = 2, name = "Michael Carrasquillo", email = "Michael@example.com"),
        User(id = 3, name = "Joel Lopez", email = "Joel@example.com")
    )

    override suspend fun fetchUser(userId: Int): User {
        delay(1000) // Simulate network delay
        return users.find { it.id == userId } ?: throw Exception("User not found")
    }
}
