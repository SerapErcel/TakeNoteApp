package com.serapercel.todo.di

import com.serapercel.todo.data.datasource.YapilacakIsDataSource
import com.serapercel.todo.data.repo.YapilacakIsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideYapilacakIsRepository(yids:YapilacakIsDataSource) : YapilacakIsRepository{
        return YapilacakIsRepository(yids)
    }

    @Provides
    @Singleton
    fun provideYapilacakIsDataSource() : YapilacakIsDataSource{
        return YapilacakIsDataSource()
    }

}