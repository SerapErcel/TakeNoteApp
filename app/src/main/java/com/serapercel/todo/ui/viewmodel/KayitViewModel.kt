package com.serapercel.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.serapercel.todo.data.repo.YapilacakIsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KayitViewModel : ViewModel() {

    var yirepo = YapilacakIsRepository()

    fun kaydet(yapilacakIs: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yirepo.kaydet(yapilacakIs)
        }
    }
}