package com.example.palette.usesCases.colors

import com.example.palette.model.ColorModel
import com.example.palette.repositories.ColorRepository

class DeleteColorUseCase(private val colorRepository: ColorRepository) {

    suspend operator fun invoke(colorItem: ColorModel){
        colorRepository.deleteColor(colorItem)
    }
}