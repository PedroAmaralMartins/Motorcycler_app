package br.com.pedro.testeapp.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pedro.testeapp.data.repository.MotorcycleRepository
import br.com.pedro.testeapp.ui.Motorcycler
import kotlinx.coroutines.launch

class MotorcycleViewModel(
    private val repository: MotorcycleRepository
) : ViewModel() {

    //Motorcycler List
    private val _motorcycles = MutableLiveData<List<Motorcycler>>()
    val motorcycles: LiveData<List<Motorcycler>> = _motorcycles

    private val _brands = MutableLiveData<List<String>>()

    val brands: LiveData<List<String>> = _brands

    private val _loading = MutableLiveData<Boolean>()

    val loading: LiveData<Boolean> = _loading



    fun getMotocycles(mark: String?) {
        Log.d("VIEWMODEL", "getMotocycles called with mark=$mark")
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
    fun loadBrands() {
        viewModelScope.launch {
            try {
                val result = repository.getBrands()
                _brands.postValue(result)
            } catch (e: Exception) {
                Log.e("VIEWMODEL", "Error brands: ${e.message}", e)
            }
        }
    }
}
