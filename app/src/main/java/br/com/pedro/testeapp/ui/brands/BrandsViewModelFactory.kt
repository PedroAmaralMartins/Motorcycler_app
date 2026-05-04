package br.com.pedro.testeapp.ui.brands

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.pedro.testeapp.data.repository.MotorcycleRepository

class BrandsViewModelFactory(
    private val repository: MotorcycleRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BrandsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BrandsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}