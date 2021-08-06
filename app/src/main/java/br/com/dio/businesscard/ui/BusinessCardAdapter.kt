package br.com.dio.businesscard.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.businesscard.data.BusinessCard
import br.com.dio.businesscard.databinding.ItemBusinessCardBinding
import kotlinx.android.synthetic.main.item_business_card.view.ic_delete
import kotlinx.android.synthetic.main.item_business_card.view.ic_share

class BusinessCardAdapter :
    ListAdapter<BusinessCard,  BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}
    var listenerBusinessCard: (BusinessCard) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.cdContent.setCardBackgroundColor(item.fundoPersonalizado)
            binding.cdContent.ic_share.setOnClickListener {

                binding.cdContent.ic_delete.visibility = View.INVISIBLE
                binding.cdContent.ic_share.visibility = View.INVISIBLE

                if(binding.cdContent.ic_delete.visibility == View.INVISIBLE && binding.cdContent.ic_share.visibility == View.INVISIBLE) {
                    listenerShare(binding.cdContent)
                }

                binding.cdContent.ic_delete.visibility = View.VISIBLE
                binding.cdContent.ic_share.visibility = View.VISIBLE
            }
            binding.cdContent.ic_delete.setOnClickListener {
                listenerBusinessCard(item)
            }
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}