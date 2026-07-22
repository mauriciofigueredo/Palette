package com.example.palette.room

import androidx.room.RoomDatabaseConstructor


actual object AppDataBaseConstructor :
    RoomDatabaseConstructor<RoomDB> {
    actual override fun initialize(): RoomDB {
        TODO("Not yet implemented")
    }
}