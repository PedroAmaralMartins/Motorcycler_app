package br.com.pedro.testeapp.data.network

import br.com.pedro.testeapp.data.model.UnsplashResponse
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
    ): retrofit2.Response<UnsplashResponse>
}