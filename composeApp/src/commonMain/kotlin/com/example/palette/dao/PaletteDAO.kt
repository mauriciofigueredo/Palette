package com.example.palette.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.palette.model.PaletteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PaletteDAO {
    @Insert
    suspend fun insertPalette(paletteItem: PaletteModel)

    @Update
    suspend fun updatePalette(paletteItem: PaletteModel)

    @Delete
    suspend fun deletePalette(paletteItem: PaletteModel)

    @Query("SELECT * FROM palettes")
    fun getAllPalettes(): Flow<List<PaletteModel>>


}