package br.com.pedro.testeapp.data.repository

import android.util.Log
import br.com.pedro.testeapp.data.mapper.toDomain
import br.com.pedro.testeapp.data.retrofit.NinjasRetrofit
import br.com.pedro.testeapp.ui.Motorcycler

class MotorcycleRepository {

    companion object {
        //CHAVE API
        private const val API_KEY = "BbtSIv8ffe0TMSwzXG6N04EwwoU32NwiKjtrhqRE"
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

            body?.map { it.toDomain() } ?: emptyList()
        } catch (e: Exception) {
            Log.e("MotorcycleRepository", "Exception: ${e.message}", e)
            emptyList()
        }
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
