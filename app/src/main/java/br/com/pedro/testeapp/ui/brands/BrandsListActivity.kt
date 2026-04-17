package br.com.pedro.testeapp.ui.brands

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.pedro.testeapp.data.repository.MotorcycleRepository
import br.com.pedro.testeapp.databinding.BrandsListBinding
import br.com.pedro.testeapp.ui.list.MotorcycleListActivity
import br.com.pedro.testeapp.ui.list.MotorcycleViewModel
import br.com.pedro.testeapp.ui.list.MotorcycleViewModelFactory

class BrandsListActivity : AppCompatActivity() {

        private val binding by lazy {
            BrandsListBinding.inflate(layoutInflater)
        }
        private val viewModel by lazy {
            ViewModelProvider(
                this,
                MotorcycleViewModelFactory(MotorcycleRepository())
            )[MotorcycleViewModel::class.java]
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
            observeViewModel()

            viewModel.loadBrands()
            setupSearchButton()
            setupDropdownInteraction()
        }

        private fun observeViewModel() {
            viewModel.brands.observe(this) { brands ->
                setupDropdown(brands)
            }
        }

        private fun setupDropdown(brands: List<String>) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                brands
            )

            binding.dropDownBrands.setAdapter(adapter)
            binding.dropDownBrands.threshold = 0
        }

    private fun setupDropdownInteraction(){
        binding.dropDownBrands.setOnClickListener {
            binding.dropDownBrands.showDropDown()
        }
    }

        private fun setupSearchButton() {
            binding.searchBrands.setOnClickListener {
                val selectBrand = binding.dropDownBrands.text.toString().trim()

                if (selectBrand.isNotEmpty()) {
                    val intent = Intent(this, MotorcycleListActivity::class.java).apply {
                        putExtra("MARCA_SELECIONADA", selectBrand)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Selecione uma Marca Primeiro!", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
}
