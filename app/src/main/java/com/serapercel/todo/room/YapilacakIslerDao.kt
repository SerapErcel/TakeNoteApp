package com.serapercel.todo.room

import androidx.room.Dao
import androidx.room.Query
import com.serapercel.todo.data.entity.YapilacakIs

@Dao
interface YapilacakIslerDao {
    @Query("SELECT * FROM yapilacakIs")
    suspend fun isleriYukle(): List<YapilacakIs>
}