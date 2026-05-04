package br.com.pedro.testeapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UnsplashApiService {
    @GET("search/photos")
    suspend fun searchPhoto(
        @Header("Authorization") authorization: String,
        @Query("query")query:String,
        @Query("per_page")perPage: Int = 5,
        @Query("orientation") orientation: String = "landscape"
    ): Response<UnsplashResponse>
}