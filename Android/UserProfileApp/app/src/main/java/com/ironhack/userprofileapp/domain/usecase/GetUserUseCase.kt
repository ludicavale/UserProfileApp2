package com.ironhack.userprofileapp.domain.usecase

import com.ironhack.userprofileapp.domain.model.User

interface GetUserUseCase {
    suspend fun execute(userId: Int): User
}