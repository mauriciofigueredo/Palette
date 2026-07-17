package com.example.palette.usesCases.palette

import com.example.palette.model.PaletteModel
import com.example.palette.repositories.PaletteRepository


class UpdatePaletteuseCase(private val paletteRepository: PaletteRepository) {
    suspend operator fun invoke(paletteItem: PaletteModel){
        paletteRepository.updatePalette(paletteItem)
    }
}