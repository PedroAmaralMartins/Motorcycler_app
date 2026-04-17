package br.com.pedro.testeapp.ui.details

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import br.com.pedro.testeapp.adapter.SpecAdapter
import br.com.pedro.testeapp.adapter.SpecItem
import br.com.pedro.testeapp.databinding.FragmentMotorcyclerDetailsBinding
import br.com.pedro.testeapp.ui.Motorcycler
import br.com.pedro.testeapp.ui.constants.KEY_MOTORCYCLER
import coil.load

class DetalhesActivity : AppCompatActivity() {

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
                SpecItem("Tipo", motorcycler.typeMot),
                SpecItem("Cilindrada", motorcycler.displacementMot),
                SpecItem("Motor", motorcycler.engineMot),
                SpecItem("Potência", motorcycler.powerMot),
                SpecItem("Torque", motorcycler.torqueMot),
                SpecItem("Compressão", motorcycler.compressionMot),
                SpecItem("Diâmetro x Curso", motorcycler.bore_strokeMot),
                SpecItem("Válvulas por Cilindro", motorcycler.valves_per_cylinderMot),
                SpecItem("Sistema de Combustível", motorcycler.fuel_systemMot),
                SpecItem("Controle de Combustível", motorcycler.fuel_controlMot),
                SpecItem("Ignição", motorcycler.ignitionMot),
                SpecItem("Lubrificação", motorcycler.lubricationMot),
                SpecItem("Arrefecimento", motorcycler.coolingMot),
                SpecItem("Câmbio", motorcycler.gearboxMot),
                SpecItem("Transmissão", motorcycler.transmissionMot),
                SpecItem("Embreagem", motorcycler.clutchMot),
                SpecItem("Chassi", motorcycler.frameMot),
                SpecItem("Suspensão Dianteira", motorcycler.front_suspensionMot),
                SpecItem("Curso da Roda Dianteira", motorcycler.front_wheel_travelMot),
                SpecItem("Suspensão Traseira", motorcycler.rear_suspensionMot),
                SpecItem("Curso da Roda Traseira", motorcycler.rear_wheel_travelMot),
                SpecItem("Pneu Dianteiro", motorcycler.front_tireMot),
                SpecItem("Pneu Traseiro", motorcycler.rear_tireMot),
                SpecItem("Freios Dianteiros", motorcycler.front_brakesMot),
                SpecItem("Freios Traseiros", motorcycler.rear_brakesMot),
                SpecItem("Peso Total", motorcycler.total_weightMot),
                SpecItem("Altura do Assento", motorcycler.seat_heightMot),
                SpecItem("Altura Total", motorcycler.total_heightMot),
                SpecItem("Comprimento Total", motorcycler.total_lengthMot),
                SpecItem("Largura Total", motorcycler.total_widthMot),
                SpecItem("Distância do Solo", motorcycler.ground_clearanceMot),
                SpecItem("Distância entre Eixos", motorcycler.wheelbaseMot),
                SpecItem("Capacidade de Combustível", motorcycler.fuel_capacityMot),
                SpecItem("Partida", motorcycler.starterMot)
            )

            recyclerViewSpecs.adapter = SpecAdapter(specList)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
