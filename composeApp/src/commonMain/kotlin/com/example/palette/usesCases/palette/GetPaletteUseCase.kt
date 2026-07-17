package com.example.palette.usesCases.palette

import com.example.palette.model.PaletteModel
import com.example.palette.repositories.PaletteRepository
import kotlinx.coroutines.flow.Flow

class GetPaletteUseCase(private val paletteRepository: PaletteRepository) {

    operator fun invoke(): Flow<List<PaletteModel>?>{
        return paletteRepository.getAllPalettes()
    }
}