package com.example.palette.viewModels

import androidx.lifecycle.ViewModel
import com.example.palette.copyToClipboard
import com.example.palette.model.ColorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File.separator
import kotlin.random.Random

class ColorViewModel: ViewModel() {

    private val _colors = MutableStateFlow<List<ColorModel>>(emptyList())
    val colors : StateFlow<List<ColorModel>> = _colors

    private var id = 1

    fun generateColor(){
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)

        val hex = ColorModel.rgbToHex(r,g,b)
        val rgb = "RGB, ($r, $g, $b)"

        val newColor = ColorModel(id++, r, g, b, hex, rgb)

        _colors.value += newColor
    }

    fun deleteColor(id:Int){
        _colors.value = _colors.value.filter{ it.id != id}
    }

    fun editColor(id:Int, r:Int,g:Int,b:Int){
        val hex = ColorModel.rgbToHex(r,g,b)
        val rgb = "RGB, ($r, $g, $b)"

        _colors.value = _colors.value.map { color ->
            if(color.id == id){
                color.copy(id = id, red = r, green = g, blue = b, hex = hex, rgb = rgb)
            }else {
                color
            }
        }
    }


    fun reset(){
        _colors.value = emptyList()
    }

    fun copyAll(){
        val hexString = _colors.value.joinToString(separator = "\n") { it.hex }
        copyToClipboard(hexString)
    }

}