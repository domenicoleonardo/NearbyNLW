package com.rocketseat.nlw.nearby.data.model.mock

import com.rocketseat.nlw.nearby.data.model.Market
import com.rocketseat.nlw.nearby.data.model.Rule

val mockMarkets = listOf(
    Market(
        id = "012576ea-4441-4b8a-89e5-d5f32104c7c4",
        categoryId = "14b1d1b8-b1d3-4232-8b8f-c1f086f1868d",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
        coupons = 10,
//        rules = listOf(
//            Rule(id = "1", descriptio = "Válido até o dia 25/12", marketId = "012576ea-4441-4b8a-89e5-d5f32104c7c4"),
//            Rule(id = "2", descriptio = "Disponível apenas para consumo local", marketId = "012576ea-4441-4b8a-89e5-d5f32104c7c4")
//        ),
        latitude = -23.5594572108564346,
        longitude = -46.662585215751344,
        address = "Av. Paulista - Bela Vista",
        phone = "(11) 94567-1122",
        cover = "https://images.unsplash.com/photo-1498456234439-37aacff113df?w=408&h=300"
    ),

    Market(
        id = "2bc11e34-5f30-4a0d-9f0a-c19b6f4f9281",
        categoryId = "14b1d1b8-b1d3-4232-8b8f-c1f086f1868d",
        name = "Café Central",
        description = "Café aconchegante com opções de lanches e bebidas artesanais. Perfeito para uma pausa.",
        coupons = 10,
//        rules = emptyList(),
        latitude = -23.5594572108564346,
        longitude = -46.662585215751344,
        address = "Alameda Jaú - Jardim Paulista",
        phone = "(12) 3456-7890",
        cover = "https://images.unsplash.com/photo-1551218808-94e220e084d2?w=408&h=300"
    )
)
