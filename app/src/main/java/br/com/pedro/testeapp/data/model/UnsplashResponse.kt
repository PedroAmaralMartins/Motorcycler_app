package br.com.pedro.testeapp.data.model

data class UnsplashResponse(
    val results: List<UnsplashImagem>
)

data class UnsplashImagem(
    val urls: UnsplashUrls
)
data class UnsplashUrls (
    val regular: String, //Good average image quality for details
    val small: String // Small image, good for a list
)