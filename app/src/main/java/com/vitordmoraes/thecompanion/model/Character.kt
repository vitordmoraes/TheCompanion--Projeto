package com.vitordmoraes.thecompanion.model

import kotlinx.android.parcel.Parcelize
import java.util.*


data class Character(
        val name: String,
        val race:String,
        val clas:String,
        var lvl: String,
        )
{
        val id: String = UUID.randomUUID().toString()

        val uri: String
                get() = "drawable/$clas"

        val ua: String
                get() = "drawable/uachar"
}