package com.serapercel.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.serapercel.todo.R
import com.serapercel.todo.databinding.FragmentKayitBinding
import com.serapercel.todo.ui.viewmodel.KayitViewModel
import com.serapercel.todo.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false)
        binding.kayitFragment = this

        binding.kayitToolbarBaslik = getString(R.string.yapilacak_is_kayit)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonkaydet(yapilacakIs:String){
        viewModel.kaydet(yapilacakIs)
        Navigation.gecisYap(binding.buttonKaydet,R.id.kayitAnasayfaGecis)
    }
}