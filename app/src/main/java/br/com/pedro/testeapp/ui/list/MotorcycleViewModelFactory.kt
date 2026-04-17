package br.com.pedro.testeapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.pedro.testeapp.data.repository.MotorcycleRepository

class MotorcycleViewModelFactory(
    private val repository: MotorcycleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(MotorcycleViewModel::class.java)) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        @Suppress("UNCHECKED_CAST")
        return MotorcycleViewModel(repository) as T
    }
}
