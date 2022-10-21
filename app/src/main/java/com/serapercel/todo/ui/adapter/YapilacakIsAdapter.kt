package com.serapercel.todo.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.serapercel.todo.R
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.databinding.CardItemBinding
import com.serapercel.todo.ui.fragment.AnasayfaFragmentDirections
import com.serapercel.todo.ui.viewmodel.AnasayfaViewModel
import com.serapercel.todo.utils.gecisYap

class YapilacakIsAdapter(var mContext: Context,
                         var isListesi: List<YapilacakIs>,
                         var viewModel: AnasayfaViewModel
                         ) :
    RecyclerView.Adapter<YapilacakIsAdapter.CardItemHolder>() {

    inner class CardItemHolder(binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: CardItemBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemHolder {
        val binding: CardItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.card_item, parent, false
        )
        return CardItemHolder(binding)
    }

    override fun onBindViewHolder(holder: CardItemHolder, position: Int) {
        val yapilacakIs = isListesi[position]
        val binding = holder.binding
        binding.isNesnesi = yapilacakIs

        binding.isCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.isDetayGecis(yapilacakIs = yapilacakIs)
            Navigation.gecisYap(it, gecis)
        }

        binding.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacakIs.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    sil(yapilacakIs.yapilacak_is_id)
                }.show()
        }
    }

    fun sil(yapilacak_is_id: Int) {
        viewModel.sil(yapilacak_is_id)
    }

    override fun getItemCount(): Int = isListesi.size
}