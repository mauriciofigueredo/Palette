package com.example.palette.viewModels

import androidx.lifecycle.ViewModel
import com.example.palette.model.ColorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class colorViewModel: ViewModel() {

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

}