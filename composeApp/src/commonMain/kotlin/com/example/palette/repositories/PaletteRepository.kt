package com.example.palette.repositories

import com.example.palette.model.PaletteModel
import com.example.palette.room.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class PaletteRepository(private val database: RoomDB) {
    private val dispatchers = Dispatchers.IO

    suspend fun insertPalette(paletteItem: PaletteModel){
        with(dispatchers){
            database.paletteDao().insertPalette(paletteItem)
        }
    }

    suspend fun updatePalette(paletteItem: PaletteModel){
        with(dispatchers){
            database.paletteDao().updatePalette(paletteItem)
        }
    }
    suspend fun deletePalette(paletteItem: PaletteModel){
        with(dispatchers){
            database.paletteDao().deletePalette(paletteItem)
        }
    }


    fun getAllPalettes(): Flow<List<PaletteModel>?>{

        return database.paletteDao().getAllPalettes()
    }
}