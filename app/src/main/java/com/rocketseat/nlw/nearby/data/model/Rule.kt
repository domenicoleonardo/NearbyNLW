package com.rocketseat.nlw.nearby.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Rule(
    val id: String,
    val descriptio: String,
    val marketId: String
)

//Você está construindo um app que mostra mercados próximos,
// e esses mercados (com todas as informações, como nome,
// localização, cupons, etc.) não estão dentro do app.
// Em vez disso, essas informações estão armazenadas em um servidor
// na internet. Para obter essas informações, o app faz uma requisição
// à API do servidor, que envia os dados para o app em formato organizado,
// geralmente como JSON.