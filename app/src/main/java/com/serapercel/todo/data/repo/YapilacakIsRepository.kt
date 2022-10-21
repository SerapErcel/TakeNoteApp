package com.serapercel.todo.data.repo

import com.serapercel.todo.data.datasource.YapilacakIsDataSource
import com.serapercel.todo.data.entity.YapilacakIs

class YapilacakIsRepository(var yids:YapilacakIsDataSource) {

    suspend fun kaydet(yapilacakIs:String) = yids.kaydet(yapilacakIs)

    suspend fun guncelle(yapilacak_is_id:Int, yapilacak_is: String) = yids.guncelle(yapilacak_is_id, yapilacak_is)

    suspend fun isleriYukle() : List<YapilacakIs> = yids.isleriYukle()

    suspend fun ara(aramaKelimesi: String) : List<YapilacakIs> = yids.ara(aramaKelimesi)

    suspend fun sil(yapilacak_is_id: Int) = yids.sil(yapilacak_is_id)



    }