package com.serapercel.todo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        binding.toolbarDetay.title = "Yapılacak İş Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val gelenIs = bundle.yapilacakIs

        binding.editTextYapilacakIs.setText(gelenIs.yapilacak_is)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacakIs = binding.editTextYapilacakIs.text.toString()
            guncelle(gelenIs.yapilacak_is_id, yapilacakIs)
        }

        return binding.root
    }

    fun guncelle(yapilacak_is_id:Int, yapilacak_is: String){
        Log.e("İş Güncelle", "$yapilacak_is_id - $yapilacak_is")
    }
}