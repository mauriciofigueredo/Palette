package com.example.palette.di

import androidx.room.RoomDatabase
import com.example.palette.room.RoomDB
import com.example.palette.room.androidDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val androidDatabaseModule = module {
    single<RoomDatabase.Builder<RoomDB>>{ androidDatabaseBuilder(androidContext()) }
}


