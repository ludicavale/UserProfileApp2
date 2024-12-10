package com.ironhack.userprofileapp.domain.repository

import com.ironhack.userprofileapp.domain.model.User

interface UserRepository {
    suspend fun getUserById(userId: Int): User
}