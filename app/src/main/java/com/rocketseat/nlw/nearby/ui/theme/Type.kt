package com.rocketseat.nlw.nearby.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.leonardodidomenico.nearby.R

val rubikFontFamily = FontFamily(
    Font(R.font.rubik, FontWeight.Normal),
    Font(R.font.rubik_medium, FontWeight.Medium),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_semibold, FontWeight.SemiBold)
)


// A variável `activatePreview` é uma constante usada para ativar ou desativar a visualização no modo de pré-visualização do Android Studio (Compose Preview).
// - Quando `true`: Utiliza a fonte padrão (`FontFamily.Default`), garantindo que a pré-visualização funcione sem depender de fontes personalizadas.
// - Quando `false`: Utiliza a fonte personalizada (`rubikFontFamily`), permitindo visualizar o design final do app com as fontes específicas.
// Isso é útil para evitar erros no modo de pré-visualização, especialmente quando as fontes personalizadas não estão carregadas ou configuradas corretamente.
private const val activatePreview = true

val Typography = Typography(
    // "Title XI"
    headlineLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    // "Title Lg"
    headlineMedium = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    // "Title Md"
    headlineSmall = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    // "Text Sm"
    titleLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    // "Text Md"
    bodyLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    // "Text Sm"
    bodyMedium = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    // "Text Xs"
    bodySmall = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    // "Action"
    labelLarge = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    // "Subtitle"
    labelMedium = TextStyle(
        fontFamily = if (activatePreview) FontFamily.Default else rubikFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)
