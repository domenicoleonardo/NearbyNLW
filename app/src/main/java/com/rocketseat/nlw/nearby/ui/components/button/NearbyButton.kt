package com.rocketseat.nlw.nearby.ui.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leonardodidomenico.nearby.R
import com.rocketseat.nlw.nearby.ui.theme.GreenBase
import com.rocketseat.nlw.nearby.ui.theme.Typography

//Composable que cria um botão customizável
@Composable
fun NearbyButton(
    modifier: Modifier = Modifier,
    text: String? = null, // Caso o botão tenha texto
    @DrawableRes iconRes: Int? = null, // Caso o botão tenha um ícone
    onClick: () -> Unit // O que acontece ao clicar, Unit significa s/ entrada e s/retorno
) {


    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),//aspecto menos arredondado
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding ,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase
        ),
        onClick = onClick

    )

    {

        Row( // linha para controlar visibilidade horizontal
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "Ícone do botão"
                )
            }
            text?.let {
                Text(
                    text = text.uppercase(),
                    style = Typography.labelLarge
                )
            } // Ternário - se tiver texto, mostre, senão não faça nada
        }
    }
}

// Preview para não precisar emular - botão com texto
@Preview
@Composable
private fun NearbyButtonPreview() {  // Ação simulada para o botão no preview com texto
    NearbyButton(
        modifier = Modifier.fillMaxWidth(), // botão ocupa toda a largura disponível
        text = "Confirmar",
        iconRes = R.drawable.ic_scan
    ) {}
}

// Preview para não precisar emular - botão sem texto
@Preview
@Composable
private fun NearbyButtonNoTextPreview() {  // Ação simulada para o botão no preview com texto
    NearbyButton(
        modifier = Modifier,
        iconRes = R.drawable.ic_arrow_left
    ) {}
}

// Preview para não precisar emular - botão sem ícone
@Preview
@Composable
private fun NearbyButtonNoIconPreview() {  // Ação simulada para o botão no preview com texto
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar"
    ) {}
}