package br.com.pedro.testeapp.data.model

data class UnsplashResponse(
    val results: List<UnsplashImagem>
)

data class UnsplashImagem(
    val urls: UnsplashUrls
)
data class UnsplashUrls (
    val regular: String,
    val small: String
)