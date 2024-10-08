package kr.linkerbell.campusmarket.android.data.remote.network.api.nonfeature

import kr.linkerbell.campusmarket.android.data.remote.network.di.AuthHttpClient
import kr.linkerbell.campusmarket.android.data.remote.network.environment.BaseUrlProvider
import kr.linkerbell.campusmarket.android.data.remote.network.environment.ErrorMessageMapper
import kr.linkerbell.campusmarket.android.data.remote.network.model.nonfeature.user.ProfileRes
import kr.linkerbell.campusmarket.android.data.remote.network.util.convert
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

class UserApi @Inject constructor(
    @AuthHttpClient private val client: HttpClient,
    private val baseUrlProvider: BaseUrlProvider,
    private val errorMessageMapper: ErrorMessageMapper
) {
    private val baseUrl: String
        get() = baseUrlProvider.get()

    suspend fun getProfile(): Result<ProfileRes> {
        return client.get("$baseUrl/api/v1/user/profile")
            .convert(errorMessageMapper::map)
    }
}
