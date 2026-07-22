package com.example.palette.usesCases.colors

import com.example.palette.repositories.ColorRepository

class DeletePaletteUseCase(private val colorRepository: ColorRepository) {
    suspend operator fun invoke(idPalette: Int){
        colorRepository.deletePalette(idPalette)
    }
}