package com.youkydesign.sakeca.core.data.network

import com.youkydesign.sakeca.core.data.network.response.RecipeResponse
import com.youkydesign.sakeca.core.data.network.response.RecipesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(FlowPreview::class)
@Singleton
class NetworkRecipeDataSource @Inject constructor(private val apiService: ApiService) {
    fun searchRecipes(query: String): Flow<ApiResponse<List<RecipesItem>>> = flow {
        try {
            val response = apiService.searchRecipes(query)
            val dataArray = response.recipes
            if (dataArray.isNotEmpty()) {
                emit(ApiResponse.Success(response.recipes))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
        }
    }.debounce(1000).flowOn(Dispatchers.IO)

    fun getRecipe(rId: String): Flow<ApiResponse<RecipeResponse>> = flow {
        try {
            val response = apiService.getRecipe(rId)
            if (response != null) {
                val recipeData: RecipeResponse = response.recipeResponse
                emit(ApiResponse.Success(recipeData))

            } else {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error("Failed to fetch recipe: ${e.message}"))
        }
    }.debounce(1000).flowOn(Dispatchers.IO)
}