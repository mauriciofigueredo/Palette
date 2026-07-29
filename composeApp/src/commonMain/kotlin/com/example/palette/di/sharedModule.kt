package com.example.palette.di

import com.example.palette.repositories.ColorRepository
import com.example.palette.repositories.PaletteRepository
import com.example.palette.room.CreateDatabase
import com.example.palette.room.RoomDB
import com.example.palette.usesCases.colors.DeleteColorUseCase
import com.example.palette.usesCases.colors.DeletePaletteUseCase
import com.example.palette.usesCases.colors.GetColorsUseCase
import com.example.palette.usesCases.colors.InsertColorUseCase
import com.example.palette.usesCases.colors.UpdateColorUseCase
import com.example.palette.usesCases.palette.GetPaletteUseCase
import com.example.palette.usesCases.palette.InsertPaletteUseCase
import com.example.palette.usesCases.palette.UpdatePaletteuseCase
import com.example.palette.viewModels.ColorViewModel
import com.example.palette.viewModels.PaletteViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

//Este modulo sera para la creacion y configuracion de componentes para la inyeccion de dependencias

val sharedModule = module {
    single <RoomDB> { CreateDatabase(get()).getDatabase() }

    //Repositories
    singleOf(::PaletteRepository)
    singleOf(::ColorRepository)

    //Uses cases
    singleOf(::InsertPaletteUseCase)
    singleOf(::UpdatePaletteuseCase)
    singleOf(::GetPaletteUseCase)

    singleOf(::InsertColorUseCase)
    singleOf(::GetColorsUseCase)
    singleOf(::UpdateColorUseCase)
    singleOf(::DeleteColorUseCase)
    singleOf(::DeletePaletteUseCase)



    //singleOf(::DeletePaletteUseCase)

    //viewModel
    viewModelOf(::PaletteViewModel)
    viewModelOf(::ColorViewModel)
}