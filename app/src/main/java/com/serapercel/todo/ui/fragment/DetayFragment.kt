package com.serapercel.todo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.serapercel.todo.R
import com.serapercel.todo.databinding.FragmentDetayBinding
import com.serapercel.todo.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container, false)
        binding.detayFragment = this

        binding.detayToolbarBaslik = "Yapılacak İş Detay"

        val bundle: DetayFragmentArgs by navArgs()
        val gelenIs = bundle.yapilacakIs
        binding.isNesnesi = gelenIs

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacak_is_id: Int, yapilacak_is: String) {
        viewModel.guncelle(yapilacak_is_id, yapilacak_is)
    }
}