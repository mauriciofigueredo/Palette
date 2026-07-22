package com.example.palette.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Palette(val id : Int, val name: String)

