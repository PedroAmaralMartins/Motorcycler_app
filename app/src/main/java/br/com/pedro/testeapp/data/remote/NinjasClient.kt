package br.com.pedro.testeapp.data.remote

object NinjasClient {

    private const val BASE_URL = "https://api.api-ninjas.com/v1/"

    val api: NinjasApiService by lazy {
        RetrofitBase.buildRetrofit(BASE_URL)
            .create(NinjasApiService::class.java)
    }
}


