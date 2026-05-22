package br.com.pedro.testeapp.data.remote

import br.com.pedro.testeapp.data.model.MotorcycleInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NinjasApiService {

    @GET("motorcycles")
    suspend fun getMotorcycles(
        @Header("X-Api-Key") apiKey: String,
        @Query("make") make: String
    ): Response<List<MotorcycleInfo>>

}