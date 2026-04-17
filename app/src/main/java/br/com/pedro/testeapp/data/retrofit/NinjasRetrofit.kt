package br.com.pedro.testeapp.data.retrofit

import br.com.pedro.testeapp.data.network.NinjasApiService

object NinjasRetrofit {

    private const val BASE_URL = "https://api.api-ninjas.com/v1/"

    val api: NinjasApiService by lazy {
        RetrofitBase.buildRetrofit(BASE_URL)
            .create(NinjasApiService::class.java)
    }
}
