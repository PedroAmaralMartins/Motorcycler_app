package br.com.pedro.testeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.testeapp.databinding.ItemSpecRowBinding
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
    }

    override fun getItemCount() = specs.size
}