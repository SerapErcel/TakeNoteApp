package com.serapercel.todo.di

import android.content.Context
import androidx.room.Room
import com.serapercel.todo.data.datasource.YapilacakIsDataSource
import com.serapercel.todo.data.repo.YapilacakIsRepository
import com.serapercel.todo.room.Veritabani
import com.serapercel.todo.room.YapilacakIslerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideYapilacakIsRepository(yids: YapilacakIsDataSource): YapilacakIsRepository {
        return YapilacakIsRepository(yids)
    }

    @Provides
    @Singleton
    fun provideYapilacakIsDataSource(yidao: YapilacakIslerDao): YapilacakIsDataSource {
        return YapilacakIsDataSource(yidao)
    }

    @Provides
    @Singleton
    fun provideYapilacakIslerDao(@ApplicationContext context: Context): YapilacakIslerDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java, "todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getYapilacakIslerDao()
    }


}