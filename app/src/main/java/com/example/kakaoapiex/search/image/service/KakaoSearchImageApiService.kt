package com.example.kakaoapiex.search.image.service

import com.example.kakaoapiex.Key
import com.example.kakaoapiex.search.image.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * 카카오 Developers 이미지 검색
 * https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image
 *
 * 기본 정보
 * GET /v2/search/image
 * Host: dapi.kakao.com
 * Authorization: KakaoAK ${REST_API_KEY}
 *
 * Request_Parameter
 * query : 검색을 원하는 질의어
 * sort : 결과 문서의 정렬 방식(옵션 사항, accuracy, recency)
 * page : 결과 페이지 번호(옵션 사항, 1-50)
 * size : 한 페이지에 보여질 문서의 수(옵션 사항, 1-80)
 *
 * GET "https://dapi.kakao.com/v2/search/image?query=설현"
 */
interface KakaoSearchImageApiService {
    @Headers("Authorization: KakaoAK ${Key.KAKAO_API_KEY}")
    @GET("v2/search/image")
    suspend fun searchImage(
        @Query("query") query: String
    ) : Response<ImageResponse>
}