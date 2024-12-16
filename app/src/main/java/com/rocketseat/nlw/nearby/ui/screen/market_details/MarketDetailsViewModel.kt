package com.rocketseat.nlw.nearby.ui.screen.market_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rocketseat.nlw.nearby.core.network.NearbyRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel : ViewModel() {
    private val _uiSTATE = MutableStateFlow(MarketDetailsUiState())
    val uiState: StateFlow<MarketDetailsUiState> = _uiSTATE.asStateFlow()

    fun onEvent(event: MarketDetailUiEvent) {
        when (event) {
            is MarketDetailUiEvent.OnFetchCoupon -> fetchCoupon(qrCodeContent = event.qrCodeContent)
            is MarketDetailUiEvent.OnFetchRules -> fecthRules(marketId = event.marketId)
            MarketDetailUiEvent.OnResetCoupon -> resetCoupon()
        }

    }

    private fun fetchCoupon(qrCodeContent: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.patchCoupon(marketId = qrCodeContent)
                .onSuccess { coupon ->
                    _uiSTATE.update { currenteUiState ->
                        currenteUiState.copy(
                            coupon = coupon.coupon
                        )
                    }
                }
                .onFailure {
                    _uiSTATE.update { currentUiState ->
                        currentUiState.copy(
                            coupon = ""
                        )

                    }

                }
        }
    }

    private fun fecthRules(marketId: String) {
        viewModelScope.launch {
            NearbyRemoteDataSource.getMarketDetails(marketId = marketId)
                .onSuccess { marketDetails ->
                    _uiSTATE.update { currenteUiState ->
                        currenteUiState.copy(
                            rules = marketDetails.rules
                        )
                    }
                }
                .onFailure {
                    _uiSTATE.update { currentUiState ->
                        currentUiState.copy(
                            rules = emptyList()
                        )

                    }

                }
        }

    }

    private fun resetCoupon(){
        _uiSTATE.update { currentUiState ->
            currentUiState.copy(
                coupon = null
            )



        }

    }

}