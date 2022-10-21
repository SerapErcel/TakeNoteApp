package com.serapercel.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.serapercel.todo.R
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
            Navigation.findNavController(it).navigate(R.id.isDetayGecis)
        }

        return binding.root
    }
}