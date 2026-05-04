package br.com.pedro.testeapp.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.testeapp.databinding.ItemSpecRowLastBinding

data class  SpecItem (val label: String, val value: String)

class SpecAdapter(private val specs : List<SpecItem>):
 RecyclerView.Adapter<SpecAdapter.SpecViewHolder>(){

    class SpecViewHolder(val binding : ItemSpecRowLastBinding) :
            RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecViewHolder {
        val binding = ItemSpecRowLastBinding.inflate(LayoutInflater.from(parent.context),parent,false
        )
        return SpecViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecViewHolder, position: Int) {
        val item = specs[position]
        holder.binding.tvSpecLabel.text = item.label
        holder.binding.tvSpecValue.text = item.value

        holder.binding.divider.visibility =
            if (position == specs.size - 1) View.GONE else View.VISIBLE
    }

    override fun getItemCount() = specs.size

}