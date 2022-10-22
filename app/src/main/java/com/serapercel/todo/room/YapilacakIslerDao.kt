package com.serapercel.todo.room

import androidx.room.*
import com.serapercel.todo.data.entity.YapilacakIs

@Dao
interface YapilacakIslerDao {
    @Query("SELECT * FROM yapilacakIs")
    suspend fun isleriYukle(): List<YapilacakIs>

    @Insert
    suspend fun kaydet(yapilacakIs: YapilacakIs)

    @Update
    suspend fun guncelle(yapilacakIs: YapilacakIs)

    @Delete
    suspend fun sil(yapilacakIs: YapilacakIs)

    @Query("SELECT * FROM yapilacakIs WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi: String): List<YapilacakIs>
}