package com.serapercel.todo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.serapercel.todo.R
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.databinding.FragmentAnasayfaBinding
import com.serapercel.todo.ui.adapter.YapilacakIsAdapter

class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)

        val isListesi = ArrayList<YapilacakIs>()
        val is1 = YapilacakIs(1, "İlk İşim")
        val is2 = YapilacakIs(2, "İkinci İşim")
        val is3 = YapilacakIs(3, "Üçüncü İşim")
        isListesi.add(is1)
        isListesi.add(is2)
        isListesi.add(is3)

        val adapter = YapilacakIsAdapter(requireContext(), isListesi)
        binding.adapter = adapter

        requireActivity().addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }
    fun fabTikla(view: View){
        Navigation.findNavController(view).navigate(R.id.isKayitGecis)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }
    fun ara(aramaKelimesi: String){
        Log.e("İş Ara", aramaKelimesi)
    }
}