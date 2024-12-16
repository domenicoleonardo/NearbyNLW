package com.rocketseat.nlw.nearby.ui.screen.home

// Possíveis ações que o usuário poderá fazer na tela de UI Screen
sealed class HomeUiEvent {
    data object OnFetchCategories: HomeUiEvent()
    data class  OnFetchMarkets(val categoryId: String) : HomeUiEvent()




}