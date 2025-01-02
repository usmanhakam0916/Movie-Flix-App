package com.avicenna.enterprise.solutions.movieflix.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.avicenna.enterprise.solutions.movieflix.R

//object AppFont {
    val Montserrat = FontFamily(
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_light,FontWeight.Light),
        Font(R.font.montserrat_semibold, FontWeight.SemiBold),
        Font(R.font.montserrat_bold, FontWeight.Bold)
    )
//}


private val defaultTypography = Typography()
// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
//    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.Montserrat)
)