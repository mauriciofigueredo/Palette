package com.example.palette.usesCases.colors

import androidx.compose.ui.graphics.Color
import com.example.palette.model.ColorModel
import com.example.palette.repositories.ColorRepository

class UpdateColorUseCase(private val repository: ColorRepository) {
    suspend operator fun invoke(colorItem: ColorModel, r:Int, g:Int, b: Int){
        val hex = ColorModel.rgbToHex(r,g,b)
        val rgb = "RGB($r,$g,$b)"

        val newColor = colorItem.copy(
            red = r,
            green = g,
            blue = b,
            hex = hex,
            rgb = rgb
        )

        repository.updateColor(newColor)
    }
}