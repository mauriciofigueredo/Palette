package com.example.palette.viewModels

import androidx.compose.material3.MenuItemColors
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.palette.copyToClipboard
import com.example.palette.model.ColorModel
import com.example.palette.usesCases.colors.DeleteColorUseCase
import com.example.palette.usesCases.colors.DeletePaletteUseCase
import com.example.palette.usesCases.colors.GetColorsUseCase
import com.example.palette.usesCases.colors.InsertColorUseCase
import com.example.palette.usesCases.colors.UpdateColorUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File.separator
import kotlin.random.Random

class ColorViewModel(
    private val insertColorUseCase: InsertColorUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val updateColorUseCase: UpdateColorUseCase,
    private val deleteColorUseCase: DeleteColorUseCase,
    private val deletePaletteUseCase: DeletePaletteUseCase
): ViewModel() {

    private val _colors = MutableStateFlow<List<ColorModel>>(emptyList())
    val colors: StateFlow<List<ColorModel>> = _colors


    fun inertColor(idPalette: Int) {
        viewModelScope.launch { insertColorUseCase(idPalette) }
    }

    fun getColor(idPalette: Int): Flow<List<ColorModel>?> {
        return getColorsUseCase(idPalette)
    }

    fun editColor(colorItem: ColorModel, r: Int, g: Int, b: Int) {
        viewModelScope.launch { updateColorUseCase(colorItem, r, g, b) }
    }


    fun deleteColor(colorItem: ColorModel) {
        viewModelScope.launch { deleteColorUseCase(colorItem) }
    }

    fun deletePaletteById(idPalette: Int) {
        viewModelScope.launch {
            deletePaletteUseCase(idPalette)
        }

    }

}





//
//    private var id = 1
//
//    fun generateColor(){
//        val r = Random.nextInt(256)
//        val g = Random.nextInt(256)
//        val b = Random.nextInt(256)
//
//        val hex = ColorModel.rgbToHex(r,g,b)
//        val rgb = "RGB, ($r, $g, $b)"
//
//        val newColor = ColorModel(id++, r, g, b, hex, rgb)
//
//        _colors.value += newColor
//    }
//
//    fun deleteColor(id:Int){
//        _colors.value = _colors.value.filter{ it.id != id}
//    }
//
//    fun editColor(id:Int, r:Int,g:Int,b:Int){
//        val hex = ColorModel.rgbToHex(r,g,b)
//        val rgb = "RGB, ($r, $g, $b)"
//
//        _colors.value = _colors.value.map { color ->
//            if(color.id == id){
//                color.copy(id = id, red = r, green = g, blue = b, hex = hex, rgb = rgb)
//            }else {
//                color
//            }
//        }
//    }
//
//
//    fun reset(){
//        _colors.value = emptyList()
//    }
//
//    fun copyAll(){
//        val hexString = _colors.value.joinToString(separator = "\n") { it.hex }
//        copyToClipboard(hexString)
//    }

