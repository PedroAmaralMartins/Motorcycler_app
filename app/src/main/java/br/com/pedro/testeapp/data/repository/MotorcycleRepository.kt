package br.com.pedro.testeapp.data.repository

import android.util.Log
import br.com.pedro.testeapp.data.mapper.toDomain
import br.com.pedro.testeapp.data.model.UnsplashResponse
import br.com.pedro.testeapp.data.network.UnsplashApiService
import br.com.pedro.testeapp.data.retrofit.NinjasRetrofit
import br.com.pedro.testeapp.data.retrofit.UnsplashRetrofit
import br.com.pedro.testeapp.ui.Motorcycler
import br.com.pedro.testeapp.ui.list.MotorcycleViewModel

class MotorcycleRepository {

    companion object {
        private const val API_KEY = "BbtSIv8ffe0TMSwzXG6N04EwwoU32NwiKjtrhqRE"
        private const val UNSPLASH_KEY = "Client-ID Az5pGJLFPfVh7JbM5PlPaBb8fbLJFvHpufvJkgDVhCI"
    }

    suspend fun getMotorcycle(mark: String?): List<Motorcycler> {
        if (mark.isNullOrEmpty()) return emptyList()

        return try {
            val response = NinjasRetrofit.api.getMotorcycles(
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
                val response = UnsplashRetrofit.api.searchPhoto(
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
