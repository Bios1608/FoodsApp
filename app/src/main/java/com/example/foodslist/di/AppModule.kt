package com.example.foodslist.di

import com.example.foodslist.data.repository.FoodRepository
import com.example.foodslist.data.repository.FoodRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideFoodRepository(foodRepositoryImpl: FoodRepositoryImpl):FoodRepository
}