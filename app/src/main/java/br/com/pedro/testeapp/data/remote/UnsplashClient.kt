package br.com.pedro.testeapp.data.remote

object UnsplashClient {

    private const val BASE_URL = "https://api.unsplash.com/"

    val api: UnsplashApiService by lazy {
        RetrofitBase.buildRetrofit(BASE_URL).
        create(UnsplashApiService::class.java)
    }
}