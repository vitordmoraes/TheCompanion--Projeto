package com.vitordmoraes.thecompanion.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Character(
        val name: String,
        val race:String,
        val clas:String,
        var lvl: String,
        var maxHP: Int? = null,
        var tempHP: Int? = maxHP,
        var inspiration: Boolean = false,
        val notes: List<String>? = null
        ) : Parcelable
{

        val id: String = UUID.randomUUID().toString()



}