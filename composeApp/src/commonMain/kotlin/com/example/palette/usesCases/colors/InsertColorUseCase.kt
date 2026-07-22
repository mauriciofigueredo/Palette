package com.example.palette.usesCases.colors

import com.example.palette.model.ColorModel
import com.example.palette.navigation.Palette
import com.example.palette.repositories.ColorRepository
import kotlin.random.Random

class InsertColorUseCase(private val colorRepository: ColorRepository) {
    suspend operator fun invoke(idPalette: Int){

        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)

        val hex = ColorModel.rgbToHex(r,g,b)
        val rgb = "RGB, ($r, $g, $b)"

        val newColor = ColorModel(
            idPalette = idPalette,
            red = r,
            green = g,
            blue = b,
            hex=hex,
            rgb = rgb
        )

    colorRepository.insertColor(newColor)
    }
}