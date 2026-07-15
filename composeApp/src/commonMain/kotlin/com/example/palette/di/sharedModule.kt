package com.example.palette.di

import com.example.palette.room.CreateDatabase
import com.example.palette.room.RoomDB
import org.koin.dsl.module

//Este modulo sera para la creacion y configuracion de componentes para la inyeccion de dependencias

val sharedModule = module {
    single <RoomDB> { CreateDatabase(get()).getDatabase() }

    //Repositories


    //Uses cases


    //viewModel

}