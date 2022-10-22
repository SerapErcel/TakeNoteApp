package com.serapercel.todo.data.datasource

import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.room.YapilacakIslerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacakIsDataSource(var yidao: YapilacakIslerDao) {

    suspend fun kaydet(yapilacakIs:String){
        val yeniIs = YapilacakIs(0, yapilacakIs)
        yidao.kaydet(yeniIs)
    }
    suspend fun guncelle(yapilacak_is_id:Int, yapilacak_is: String){
        val guncellenenIs = YapilacakIs(yapilacak_is_id, yapilacak_is)
        yidao.guncelle(guncellenenIs)
    }

    suspend fun isleriYukle() : List<YapilacakIs> =
        withContext(Dispatchers.IO){
            yidao.isleriYukle()
        }

    suspend fun ara(aramaKelimesi: String) : List<YapilacakIs> =
        withContext(Dispatchers.IO){
            yidao.ara(aramaKelimesi)
        }

    suspend fun sil(yapilacak_is_id: Int) {
        val silinenIs = YapilacakIs(yapilacak_is_id,"")
        yidao.sil(silinenIs)
    }
}