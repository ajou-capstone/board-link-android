package kr.linkerbell.campusmarket.android.domain.usecase.nonfeature.authentication

import kr.linkerbell.campusmarket.android.domain.repository.nonfeature.TokenRepository
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(
        username: String,
        password: String
    ): Result<Long> {
        return tokenRepository.register(
            username = username,
            password = password
        )
    }
}
