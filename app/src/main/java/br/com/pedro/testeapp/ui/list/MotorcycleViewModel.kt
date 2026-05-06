package br.com.pedro.testeapp.ui.list

import android.R
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.pedro.testeapp.data.repository.MotorcycleRepository
import br.com.pedro.testeapp.domain.Motorcycler
import kotlinx.coroutines.launch

class MotorcycleViewModel(
    private val repository: MotorcycleRepository
) : ViewModel() {

    private val _motorcycles = MutableLiveData<List<Motorcycler>>()
    val motorcycles: LiveData<List<Motorcycler>> = _motorcycles

    private var currentMark: String? = null


    fun getMotorcycles(mark: String?) {
        currentMark = mark
        Log.d("VIEWMODEL", "getMotocycles called with mark=$mark")
        if (_motorcycles.value != null) return

        viewModelScope.launch {
            try {
                val result = repository.getMotorcycle(mark)
                Log.d("VIEWMODEL", "Retrieved ${result.size} motorcycles")
                _motorcycles.postValue(result)
            } catch (e: Exception) {
                Log.e("VIEWMODEL", "Error: ${e.message}", e)
            }
        }
    }

    class MotorcyclerViewModelFactory(
            private val repository: MotorcycleRepository
        ): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MotorcycleViewModel(repository) as T
        }
    }

}