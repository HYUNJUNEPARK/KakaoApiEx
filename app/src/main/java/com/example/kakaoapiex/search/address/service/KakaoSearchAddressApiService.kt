package com.example.kakaoapiex.search.address.service

import com.example.kakaoapiex.Key.KAKAO_API_KEY
import com.example.kakaoapiex.search.address.model.AddressResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * 카카오 Developers 주소 검색하기
 * https://developers.kakao.com/docs/latest/ko/local/dev-guide
 *
 * 기본 정보
 * GET /v2/local/search/address.${FORMAT}
 * Host: dapi.kakao.com
 * Authorization: KakaoAK ${REST_API_KEY}
 *
 * Request_Parameter
 * query : 검색을 원하는 질의어
 * analyze_type : 검색 결과 제공 방식(옵션 사항, similar, exact)
 * page : 결과 페이지 번호(옵션 사항, min:1, max:45, default:1)
 * size : 한페이지에 보여질 문서의 개수(옵션 사항, min:1, max:30, default:10)
 *
 * GET "https://dapi.kakao.com/v2/local/search/address.json?query=전북 삼성동 100"
 */
interface KakaoSearchAddressApiService {
    @Headers("Authorization: KakaoAK $KAKAO_API_KEY")
    @GET("v2/local/search/address.json")
    suspend fun searchAddress(
        @Query("query") query: String
    ) : Response<AddressResponse>
}