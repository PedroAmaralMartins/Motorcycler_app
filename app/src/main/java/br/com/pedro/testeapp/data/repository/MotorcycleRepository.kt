package br.com.pedro.testeapp.data.repository

import android.util.Log
import br.com.pedro.testeapp.BuildConfig
import br.com.pedro.testeapp.data.mapper.toDomain
import br.com.pedro.testeapp.data.remote.NinjasClient
import br.com.pedro.testeapp.data.remote.UnsplashClient
import br.com.pedro.testeapp.domain.Motorcycler

class MotorcycleRepository {

    companion object {
        private const val API_KEY = BuildConfig.NINJAS_API_KEY
        private const val UNSPLASH_KEY = BuildConfig.UNSPLASH_CLIENT_ID
    }

    suspend fun getMotorcycle(mark: String?): List<Motorcycler> {
        if (mark.isNullOrEmpty()) return emptyList()

        return try {
            val response = NinjasClient.api.getMotorcycles(
                apiKey = API_KEY,
                make = mark
            )


            val body = response.body()
            Log.d("MotorcycleRepository", "Response code: ${response.code()}")
            Log.d("MotorcycleRepository", "Size: ${body?.size}")

            body?.map { moto ->
                val imageUrl = getMotorcycleImage(
                    make  = moto.make.orEmpty(),
                    model = moto.model.orEmpty(),
                    year  = moto.year.orEmpty()
                )
                moto.toDomain().copy(imagem = imageUrl)
            } ?: emptyList()

        } catch (e: Exception) {
            Log.e("MotorcycleRepository", "Exception: ${e.message}", e)
            emptyList()
        }
    }
    private suspend fun  getMotorcycleImage(
        make: String,
        model: String,
        year: String
    ): String? {
        val queries = listOf(
            "$make $model $year motorcycle",
            "$make $model motorcycle",
            "$make motorcycle"
        )
        for (query in queries){
            try {
                val response = UnsplashClient.api.searchPhoto(
                    authorization = UNSPLASH_KEY,
                    query = query
                )
                val url = response.body()?.results?.firstOrNull()?.urls?.regular
                if(url != null) return url
            } catch (e: Exception){
                Log.e("MotorcyclerRepository","Unsplash erro '$query': ${e.message}")
            }
        }
        return null
    }

     fun getBrands (): List<String>{
        return listOf(
            "BMW",
            "Ducati",
            "Harley-Davidson",
            "Honda",
            "Kawasaki",
            "KTM",
            "Suzuki",
            "Triumph",
            "Yamaha",
            ).sorted()
    }

}
