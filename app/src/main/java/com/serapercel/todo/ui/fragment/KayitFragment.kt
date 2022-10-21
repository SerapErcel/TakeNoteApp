package com.serapercel.todo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.todo.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.toolbarKayit.title = "Yapılacak İş Kayıt"

        binding.buttonKaydet.setOnClickListener {
            val yapilacakIs = binding.editTextYapilacakIs.text.toString()

            kaydet(yapilacakIs)
        }

        return binding.root
    }

    fun kaydet(yapilacakIs:String){
        Log.e("İş Kaydet", yapilacakIs)
    }

}