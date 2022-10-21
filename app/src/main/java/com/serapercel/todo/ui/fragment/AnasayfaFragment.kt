package com.serapercel.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.serapercel.todo.R
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.toolbarAnasayfa.title = "Yapılacaklar"

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.isKayitGecis)
        }

        binding.button.setOnClickListener {
            val yapilacakIs = YapilacakIs(1, "Yapilacak Isim Yok")
            val gecis = AnasayfaFragmentDirections.isDetayGecis(yapilacakIs = yapilacakIs)
            Navigation.findNavController(it).navigate(gecis)
        }

        return binding.root
    }
}