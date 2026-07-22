package com.example.palette.repositories

import com.example.palette.model.ColorModel
import com.example.palette.navigation.Palette
import com.example.palette.room.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class ColorRepository(private val database: RoomDB) {

    private val dispatchers = Dispatchers.IO

    suspend fun insertColor(colorItem: ColorModel){
        with(dispatchers){
            database.colorDao().insertColor(colorItem)
        }
    }

    suspend fun updateColor(colorItem: ColorModel){
        with(dispatchers){
            database.colorDao().updateColor(colorItem)
        }
    }
    suspend fun deleteColor(colorItem: ColorModel){
        with(dispatchers){
            database.colorDao().deleteColor(colorItem)
        }
    }

    suspend fun deletePalette(idPalette: Int){
        with(dispatchers){
            database.colorDao().deletePalette(idPalette)
        }
    }

    fun getColors(idPalette: Int): Flow<List<ColorModel>?>{
        return database.colorDao().getColors(idPalette)
    }

}