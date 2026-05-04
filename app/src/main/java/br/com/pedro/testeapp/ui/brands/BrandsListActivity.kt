package br.com.pedro.testeapp.ui.brands

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.pedro.testeapp.R
import br.com.pedro.testeapp.data.repository.MotorcycleRepository
import br.com.pedro.testeapp.databinding.BrandsListBinding
import br.com.pedro.testeapp.ui.list.MotorcycleListActivity

class BrandsListActivity : AppCompatActivity() {

        private val binding by lazy {
            BrandsListBinding.inflate(layoutInflater)
        }

        private val viewModel: BrandsViewModel by viewModels {
            BrandsViewModelFactory(MotorcycleRepository())
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
                        putExtra(MotorcycleListActivity.EXTRA_BRAND, selectBrand)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.select_brand_first),
                                Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
}
