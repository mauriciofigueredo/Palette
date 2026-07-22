package com.example.palette.usesCases.colors

import androidx.compose.ui.graphics.Color
import com.example.palette.model.ColorModel
import com.example.palette.navigation.Palette
import com.example.palette.repositories.ColorRepository
import kotlinx.coroutines.flow.Flow

class GetColorsUseCase(private val colorRepository: ColorRepository) {
    operator fun invoke(idPalette: Int): Flow<List<ColorModel>?>{
        return colorRepository.getColors(idPalette)
    }
}