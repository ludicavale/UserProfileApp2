package com.ironhack.userprofileapp.domain.usecase


import com.ironhack.userprofileapp.domain.model.User
import com.ironhack.userprofileapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserUseCase {
    override suspend fun execute(userId: Int): User {
        return userRepository.getUserById(userId)
    }
}
