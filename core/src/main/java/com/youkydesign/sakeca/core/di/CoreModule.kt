package com.youkydesign.sakeca.core.di

import com.youkydesign.sakeca.core.RecipeRepositoryImpl
import com.youkydesign.sakeca.core.data.local.LocalRecipeDataSource
import com.youkydesign.sakeca.core.data.network.NetworkRecipeDataSource
import com.youkydesign.sakeca.core.domain.IRecipeRepository
import com.youkydesign.sakeca.core.domain.RecipeInteractor
import com.youkydesign.sakeca.core.domain.RecipeUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, NetworkModule::class])
class CoreModule {
    @Provides
    fun provideRecipeUseCase(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeUseCase =
        RecipeInteractor(
            recipeRepository = recipeRepositoryImpl
        )

    @Provides
    @Singleton
    fun provideRecipeRepository(
        localDataSource: LocalRecipeDataSource,
        networkDataSource: NetworkRecipeDataSource
    ): IRecipeRepository = RecipeRepositoryImpl(localDataSource, networkDataSource)

}