package kr.linkerbell.campusmarket.android.domain.repository.nonfeature

import androidx.annotation.Size
import kr.linkerbell.campusmarket.android.domain.model.nonfeature.user.Profile

interface TrackingRepository {

    suspend fun setFcmToken(token: String)

    suspend fun getFcmToken(): String

    suspend fun setProfile(
        profile: Profile
    ): Result<Unit>

    suspend fun logEvent(
        @Size(min = 1, max = 40) eventName: String,
        params: Map<String, Any>
    ): Result<Unit>
}
