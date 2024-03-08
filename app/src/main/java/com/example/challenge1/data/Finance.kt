package com.example.challenge1.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Finance(
    val icon: ImageVector = Icons.Rounded.Star,
    val name: String,
    val background: Color = Color(0xffCC009F)
)
