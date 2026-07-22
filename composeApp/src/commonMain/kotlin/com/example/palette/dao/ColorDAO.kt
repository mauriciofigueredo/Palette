package com.example.palette.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.palette.model.ColorModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDAO {

    @Insert
    suspend fun insertColor(colorItem: ColorModel)

    @Update
    suspend fun updateColor(colorItem: ColorModel)

    @Delete
    suspend fun deleteColor(colorItem: ColorModel)

    @Query("DELETE FROM colors WHERE idPalette = :idPalette")
    suspend fun deletePalette(idPalette: Int)

    @Query("SELECT * FROM colors WHERE idPalette = :idPalette")
    fun getColors(idPalette:Int): Flow<List<ColorModel>>

}