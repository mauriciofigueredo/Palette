package com.example.palette.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.palette.dao.ColorDAO
import com.example.palette.dao.PaletteDAO
import com.example.palette.model.ColorModel
import com.example.palette.model.PaletteModel
import java.awt.Color


@Database(entities = [PaletteModel::class, ColorModel::class], version = 2, exportSchema = true)
@ConstructedBy(AppDataBaseConstructor::class)
abstract class RoomDB: RoomDatabase() {

    abstract fun paletteDao(): PaletteDAO

    abstract fun colorDao(): ColorDAO
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDataBaseConstructor: RoomDatabaseConstructor<RoomDB>{
    override fun initialize(): RoomDB
}