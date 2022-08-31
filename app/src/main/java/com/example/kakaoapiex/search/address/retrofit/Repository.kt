package com.example.kakaoapiex.search.address.retrofit

import androidx.viewbinding.BuildConfig
import com.example.kakaoapiex.Url
import com.example.kakaoapiex.search.address.model.AddressResponse
import com.example.kakaoapiex.search.address.service.KakaoSearchAddressApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repository {
    suspend fun getAddress(): AddressResponse? {
        return kakaoSearchAddressApiService
            .searchAddress("전북 삼성동 100")
            .body()
    }

    private val kakaoSearchAddressApiService: KakaoSearchAddressApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.KAKAO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()
            .create()
    }

    /**
     * okHttp
     * -REST API, HTTP 통신을 간편하게 구현할 수 있도록 다양한 기능(REST 호출 전송, HTTP 기반의 요청, 응답)을 제공해주는 자바 라이브러리
     * -Retrofit 라이브러리의 베이스가 됨
     */
    private fun buildHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                /* 레벨(level)에 따라 보이는 정보가 달라짐
                   개발 시(디버깅 시)는 로그가 다 보이는 게 좋으나 배포 시에는 로그가 다 보이면 보안 이슈가 발생할 수 있음
                   HttpLoggingInterceptor.Level.BODY
                   HttpLoggingInterceptor.Level.NONE  */
                HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    }
                    else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .build()
    }
}