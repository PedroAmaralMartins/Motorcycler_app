package br.com.pedro.testeapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.pedro.testeapp.data.repository.MotorcycleRepository
import br.com.pedro.testeapp.databinding.ListMotorcyclesBinding
import br.com.pedro.testeapp.ui.details.MotorcycleDetailsActivity
import br.com.pedro.testeapp.ui.details.MotorcycleDetailsActivity.Companion.KEY_MOTORCYCLER

class MotorcycleListActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_BRAND = "MARCA_SELECIONADA"
    }
    private val binding by lazy {
        ListMotorcyclesBinding.inflate(layoutInflater)
    }
    private val adapter by lazy {
        MotorcycleAdapter()
    }
    private val factory by lazy {
        MotorcycleViewModelFactory(MotorcycleRepository())
    }
    private val viewModel by lazy {
        ViewModelProvider(this, factory)[MotorcycleViewModel::class.java]
    }

    private var currentMark: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(binding.root)
        setupToolbar()
        setupRecyclerView()
        observeViewModel()




        currentMark = intent.getStringExtra(EXTRA_BRAND )

        Log.d("DEBUG", "Marca no onCreate: $currentMark")

            currentMark?.let {
            viewModel.getMotorcycles(it)
        }
    }

    override fun onResume() {
        super.onResume()

        Log.d("DEBUG", "Marca salva: $currentMark")

        currentMark?.let {
            viewModel.getMotorcycles(it)
        }

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun setupRecyclerView() {
        with(binding.rvMotorcycle) {
            layoutManager = LinearLayoutManager(this@MotorcycleListActivity)
            adapter = this@MotorcycleListActivity.adapter
        }

        adapter.clickItem = {
            val intent = Intent(this, MotorcycleDetailsActivity::class.java).apply {
                putExtra(KEY_MOTORCYCLER, it)
            }
            startActivity(intent)
        }
    }

    private fun observeViewModel() {
        viewModel.motorcycles.observe(this) { motorcycles ->
            Log.d("DEBUG", "Observe recebeu: ${motorcycles.size}")
            adapter.submitList(motorcycles)
        }
    }


}
