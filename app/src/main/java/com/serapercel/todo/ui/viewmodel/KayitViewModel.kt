package com.serapercel.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.serapercel.todo.data.repo.YapilacakIsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var yirepo: YapilacakIsRepository): ViewModel() {

    fun kaydet(yapilacakIs: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yirepo.kaydet(yapilacakIs)
        }
    }
}