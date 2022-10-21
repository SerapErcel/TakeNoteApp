package com.serapercel.todo.data.datasource

import android.util.Log
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.room.YapilacakIslerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacakIsDataSource(var yidao: YapilacakIslerDao) {

    suspend fun kaydet(yapilacakIs:String){
        Log.e("İş Kaydet", yapilacakIs)
    }
    suspend fun guncelle(yapilacak_is_id:Int, yapilacak_is: String){
        Log.e("İş Güncelle", "$yapilacak_is_id - $yapilacak_is")
    }

    suspend fun isleriYukle() : List<YapilacakIs> =
        withContext(Dispatchers.IO){
            yidao.isleriYukle()
        }

    suspend fun ara(aramaKelimesi: String) : List<YapilacakIs> =
        withContext(Dispatchers.IO){
            val isListesi = ArrayList<YapilacakIs>()
            val is1 = YapilacakIs(1, "İlk İşim")
            isListesi.add(is1)

            return@withContext isListesi
        }

    suspend fun sil(yapilacak_is_id: Int) {
        Log.e("İş Sil", yapilacak_is_id.toString())
    }
}