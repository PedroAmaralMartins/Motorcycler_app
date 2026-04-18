package br.com.pedro.testeapp.data.retrofit

import br.com.pedro.testeapp.data.network.UnsplashApiService
import retrofit2.create

object UnsplashRetrofit {

    private const val BASE_URL = "https://api.unsplash.com/"

    val api: UnsplashApiService by lazy {
        RetrofitBase.buildRetrofit(BASE_URL).
        create(UnsplashApiService::class.java)
    }
}