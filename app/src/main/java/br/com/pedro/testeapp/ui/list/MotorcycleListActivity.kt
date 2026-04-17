package br.com.pedro.testeapp.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.pedro.testeapp.adapter.MotorcycleAdapter
import br.com.pedro.testeapp.data.repository.MotorcycleRepository
import br.com.pedro.testeapp.databinding.ActivityMainBinding
import br.com.pedro.testeapp.ui.constants.KEY_MOTORCYCLER
import br.com.pedro.testeapp.ui.details.DetalhesActivity

class MotorcycleListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        observeViewModel()

        val mark = intent.getStringExtra("MARCA_SELECIONADA")
        if (mark != null) {
            viewModel.getMotocycles(mark)
        }
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupRecyclerView() {
        with(binding.rvMotorcycle) {
            layoutManager = LinearLayoutManager(this@MotorcycleListActivity)
            adapter = this@MotorcycleListActivity.adapter
        }

        adapter.clickItem = {
            val intent = Intent(this, DetalhesActivity::class.java).apply {
                putExtra(KEY_MOTORCYCLER, it)
            }
            startActivity(intent)
        }
    }

    private fun observeViewModel() {
        viewModel.motorcycles.observe(this) { motorcycles ->
            adapter.updateList(motorcycles)
        }
    }
}
