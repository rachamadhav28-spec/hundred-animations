package com.bro.app

sealed class Screen {
    object List : Screen()
    data class Detail(val index: Int) : Screen()
}
