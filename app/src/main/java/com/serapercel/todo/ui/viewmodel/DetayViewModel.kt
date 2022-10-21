package com.serapercel.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.serapercel.todo.data.repo.YapilacakIsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetayViewModel : ViewModel() {
    var yirepo = YapilacakIsRepository()

    fun guncelle(yapilacak_is_id: Int, yapilacak_is: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yirepo.guncelle(yapilacak_is_id, yapilacak_is)
        }
    }
}