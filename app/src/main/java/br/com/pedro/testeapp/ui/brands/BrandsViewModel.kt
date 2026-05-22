package br.com.pedro.testeapp.ui.brands

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pedro.testeapp.data.repository.MotorcycleRepository

class BrandsViewModel(private val repository: MotorcycleRepository): ViewModel() {

    private val _brands = MutableLiveData<List<String>>()

    val brands: LiveData<List<String>> = _brands

    fun loadBrands(){

        _brands.value = repository.getBrands()

    }


}