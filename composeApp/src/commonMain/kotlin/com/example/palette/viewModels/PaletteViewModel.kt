package com.example.palette.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.palette.model.PaletteModel
import com.example.palette.usesCases.palette.GetPaletteUseCase
import com.example.palette.usesCases.palette.InsertPaletteUseCase
import com.example.palette.usesCases.palette.UpdatePaletteuseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PaletteViewModel(
    private val insertPaletteUseCase: InsertPaletteUseCase,
    private val updatePaletteuseCase: UpdatePaletteuseCase,
    private val getPaletteUseCase: GetPaletteUseCase
): ViewModel() {


    fun insertPalette(paletteItem: PaletteModel){
        viewModelScope.launch { insertPaletteUseCase(paletteItem) }
    }

    fun updatePalette(paletteItem: PaletteModel){
        viewModelScope.launch { updatePaletteuseCase(paletteItem) }
    }

    fun getPalette(): Flow<List<PaletteModel>?>{
        return getPaletteUseCase()
    }

}