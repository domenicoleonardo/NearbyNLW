package com.rocketseat.nlw.nearby.core.network

import android.adservices.adid.AdId
import com.rocketseat.nlw.nearby.core.network.KtorHttpClient.httpClientAndroid
import com.rocketseat.nlw.nearby.data.model.Category
import com.rocketseat.nlw.nearby.data.model.Coupon
import com.rocketseat.nlw.nearby.data.model.Market
import com.rocketseat.nlw.nearby.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

//começa o mapeamento de endpoints da API
object NearbyRemoteDataSource {
    //Criar duas constantes para definir a URL base da API

    private const val LOCAL_HOST_EMULATOR_BASE_URL =
        "http://10.0.2.2:3333" //Esse endereço vai ser sempre padrão para emuladores dentro do Android Studio

    private const val LOCAL_HOST_PHYSICAL_BASE_URL = "http://192.168.1.27:3333"

    private const val BASE_URL = LOCAL_HOST_PHYSICAL_BASE_URL

    //ROTAS (Endpoints)
    // 1 - busca de categorias
    // 2 - busca de locais (com base em uma categoria)
    // 3 - busca de detalhes de um local (com base em um local específico)
    // 4 - gear cupom a partir da leitura do QR Code


    //MAPEAR PRIMEIRO ENDPOINT
    //Como estamos tratando dados remotos que levarão um tempo para ser retornados, vão ser criadas funções suspensas
    suspend fun getCategories(): Result<List<Category>> = try {
        val categories =
            httpClientAndroid.get("$BASE_URL/categories").body<List<Category>>()

        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    //MAPEAR SEGUNDO ENDPOINT
    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try {
        val markets = httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}")
            .body<List<Market>>()

        Result.success(markets)

    } catch (e: Exception) {
        Result.failure(e)

    }

    //MAPEAR TERCEIRO ENDPOINT
    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> = try {
        val market = httpClientAndroid.get("$BASE_URL/markets/${marketId}")
            .body<MarketDetails>()

        Result.success(market)

    } catch (e: Exception) {
        Result.failure(e)

    }

    //MAPEAR QUARTO ENDPOINT
    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val coupon = httpClientAndroid.patch("$BASE_URL/coupons/${marketId}").body<Coupon>()

        Result.success(coupon)

    } catch (e: Exception) {
        Result.failure(e)
    }

}