package com.rocketseat.nlw.nearby.ui.screen.market_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.leonardodidomenico.nearby.R
import com.rocketseat.nlw.nearby.data.model.Market
import com.rocketseat.nlw.nearby.data.model.mock.mockMarkets
import com.rocketseat.nlw.nearby.ui.components.button.NearbyButton
import com.rocketseat.nlw.nearby.ui.components.market_details.NearbyMarketDetailsCoupons
import com.rocketseat.nlw.nearby.ui.components.market_details.NearbyMarketDetailsInfo
import com.rocketseat.nlw.nearby.ui.components.market_details.NearbyMarketDetailsRules
import com.rocketseat.nlw.nearby.ui.theme.Typography

@Composable
fun MarketDetailsScreen(
    modifier: Modifier = Modifier,
    uiState: MarketDetailsUiState,
    onEvent: (MarketDetailUiEvent) -> Unit,
    market: Market,
    onNavigateToQRCodeScanner : () -> Unit,
    onNavigateBack: () -> Unit

) {
    LaunchedEffect(key1 = true) {
        onEvent(MarketDetailUiEvent.OnFetchRules(marketId = market.id))
    }


    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Imagem no topo
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f), // Ocupa 30% da altura da tela
            contentDescription = "Imagem do Local",
            contentScale = ContentScale.Crop,
            model = market.cover
        )

        // Box inferior com bordas arredondadas
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(36.dp)
            ) {
                // Nome e descrição do mercado
                Column {
                    Text(
                        text = market.name,
                        style = Typography.headlineLarge
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Text(
                        text = market.description,
                        style = Typography.bodyLarge
                    )
                    Spacer(
                        modifier = Modifier.height(48.dp)
                    )

                    // Conteúdo scrollável
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                    ) {
                        NearbyMarketDetailsInfo(market = market)
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp)
                        )

                        if (!uiState.rules.isNullOrEmpty()) {
                            NearbyMarketDetailsRules(rules = uiState.rules)
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 24.dp)
                            )
                        }
                        if (!uiState.coupon.isNullOrEmpty())

                        NearbyMarketDetailsCoupons(
                            coupons = listOf(uiState.coupon)
                        )
                    }

                    // Botão "Ler QR Code"
                    NearbyButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        text = "Ler QR Code",
                        onClick = onNavigateToQRCodeScanner
                    )
                }
            }

        }
        //Botão retornar
        NearbyButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigateBack
        )
    }
}


@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    MarketDetailsScreen(
        market = mockMarkets.first(),
        uiState = MarketDetailsUiState(),
        onEvent = {},
        onNavigateBack = {},
        onNavigateToQRCodeScanner = {}
    )
}