package com.serapercel.todo.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.databinding.CardItemBinding
import com.serapercel.todo.ui.fragment.AnasayfaFragmentDirections

class YapilacakIsAdapter(var mContext: Context, var isListesi: List<YapilacakIs>) :
    RecyclerView.Adapter<YapilacakIsAdapter.CardItemHolder>() {

    inner class CardItemHolder(binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: CardItemBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardItemHolder(binding)
    }

    override fun onBindViewHolder(holder: CardItemHolder, position: Int) {
        val yapilacakIs = isListesi[position]
        val binding = holder.binding
        binding.textViewYapilacakIs.text = yapilacakIs.yapilacak_is

        binding.isCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.isDetayGecis(yapilacakIs = yapilacakIs)
            Navigation.findNavController(it).navigate(gecis)
        }

        binding.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacakIs.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    sil(yapilacakIs.yapilacak_is_id)
                }.show()
        }
    }

    fun sil(yapilacak_is_id:Int){
        Log.e("İş Sil", yapilacak_is_id.toString())
    }

    override fun getItemCount(): Int = isListesi.size
}