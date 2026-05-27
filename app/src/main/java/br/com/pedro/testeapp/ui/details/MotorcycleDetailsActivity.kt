package br.com.pedro.testeapp.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import br.com.pedro.testeapp.databinding.FragmentMotorcyclerDetailsBinding
import br.com.pedro.testeapp.domain.Motorcycler
import coil.load

class MotorcycleDetailsActivity : AppCompatActivity() {

    companion object {
        const val KEY_MOTORCYCLER = "motorcycler"
    }
    private val binding by lazy {
        FragmentMotorcyclerDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()
        loadMotorcycler()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarDetails)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }



    private fun loadMotorcycler() {
        val motorcycler = IntentCompat.getParcelableExtra(
            intent,
            KEY_MOTORCYCLER,
            Motorcycler::class.java
        )

        motorcycler?.let { fillInFields(it) } ?: finish()
    }

    private fun fillInFields(motorcycler: Motorcycler) {
        with(binding) {
            fragmentImagemMotorcycler.load(motorcycler.imagem)
            fragmentNameMotorcycler.text = motorcycler.nameMotorCycler
            val specList = listOf(
                SpecItem("Tipo", motorcycler.type),
                SpecItem("Cilindrada", motorcycler.displacement),
                SpecItem("Motor", motorcycler.engine),
                SpecItem("Potência", motorcycler.power),
                SpecItem("Torque", motorcycler.torque),
                SpecItem("Compressão", motorcycler.compression),
                SpecItem("Diâmetro x Curso", motorcycler.boreStroke),
                SpecItem("Válvulas por Cilindro", motorcycler.valvesPerCylinder),
                SpecItem("Sistema de Combustível", motorcycler.fuelSystem),
                SpecItem("Controle de Combustível", motorcycler.fuelControl),
                SpecItem("Ignição", motorcycler.ignition),
                SpecItem("Lubrificação", motorcycler.lubrication),
                SpecItem("Arrefecimento", motorcycler.cooling),
                SpecItem("Câmbio", motorcycler.gearbox),
                SpecItem("Transmissão", motorcycler.transmission),
                SpecItem("Embreagem", motorcycler.clutch),
                SpecItem("Chassi", motorcycler.frame),
                SpecItem("Suspensão Dianteira", motorcycler.frontSuspension),
                SpecItem("Curso da Roda Dianteira", motorcycler.frontWheelTravel),
                SpecItem("Suspensão Traseira", motorcycler.rearSuspension),
                SpecItem("Curso da Roda Traseira", motorcycler.rearWheelTravel),
                SpecItem("Pneu Dianteiro", motorcycler.frontTire),
                SpecItem("Pneu Traseiro", motorcycler.rearTire),
                SpecItem("Freios Dianteiros", motorcycler.frontBrakes),
                SpecItem("Freios Traseiros", motorcycler.rearBrakes),
                SpecItem("Peso Total", motorcycler.totalWeight),
                SpecItem("Altura do Assento", motorcycler.seatHeight),
                SpecItem("Altura Total", motorcycler.totalHeight),
                SpecItem("Comprimento Total", motorcycler.totalLength),
                SpecItem("Largura Total", motorcycler.totalWidth),
                SpecItem("Distância do Solo", motorcycler.groundClearance),
                SpecItem("Distância entre Eixos", motorcycler.wheelbase),
                SpecItem("Capacidade de Combustível", motorcycler.fuelCapacity),
                SpecItem("Partida", motorcycler.starter)
            ).filter { it.value.isNotBlank() }

            recyclerViewSpecs.adapter = SpecAdapter(specList)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
