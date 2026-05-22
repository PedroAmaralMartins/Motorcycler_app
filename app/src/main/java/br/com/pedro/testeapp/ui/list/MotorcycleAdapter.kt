package br.com.pedro.testeapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.testeapp.R
import br.com.pedro.testeapp.domain.Motorcycler
import br.com.pedro.testeapp.databinding.ItemMotorcyclerBinding
import coil.load

class MotorcycleAdapter(

    var clickItem: (motorcycler: Motorcycler) -> Unit = {}
) : ListAdapter<Motorcycler, MotorcycleAdapter.ViewHolder>(MotorcycleDiffCallback()) {


    inner class ViewHolder(private val binding: ItemMotorcyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(motorcycler: Motorcycler) {
            with(binding) {
                nameMotorcycle.text = motorcycler.nameMotorCycler
                yearMotorcycle.text = motorcycler.yearMotorCycler
                motorcycler.imagem?.let { imageUrl ->
                    imgMotorcycle.load(motorcycler.imagem) {
                        crossfade(true)
                        placeholder(R.drawable.ic_launcher_background)
                        error(R.drawable.ic_launcher_background)
                    }
                }
                root.setOnClickListener {
                    clickItem(motorcycler)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMotorcyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MotorcycleDiffCallback : DiffUtil.ItemCallback<Motorcycler>() {
        override fun areItemsTheSame(oldItem: Motorcycler, newItem: Motorcycler): Boolean {
            return oldItem.nameMotorCycler == newItem.nameMotorCycler &&
                   oldItem.yearMotorCycler == newItem.yearMotorCycler
        }

        override fun areContentsTheSame(oldItem: Motorcycler, newItem: Motorcycler): Boolean {
            return oldItem == newItem
        }
    }
}