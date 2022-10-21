package com.serapercel.todo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.serapercel.todo.data.entity.YapilacakIs

@Database(entities = [YapilacakIs::class], version = 1)
abstract class Veritabani: RoomDatabase() {
    abstract fun getYapilacakIslerDao() : YapilacakIslerDao
}