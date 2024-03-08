package com.example.challenge1.data


import androidx.compose.ui.graphics.Color

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val cardBg :Color,

)
