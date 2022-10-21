package com.serapercel.todo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.serapercel.todo.R
import com.serapercel.todo.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false)
        binding.kayitFragment = this

        binding.kayitToolbarBaslik = "Yapılacak İş Kayıt"

        return binding.root
    }

    fun buttonkaydet(yapilacakIs:String){
        Log.e("İş Kaydet", yapilacakIs)
    }

}