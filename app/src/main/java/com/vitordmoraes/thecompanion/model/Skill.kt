package com.vitordmoraes.thecompanion.model

import kotlinx.android.parcel.Parcelize


data class Skill (val skillName: String, var skillUses: Int, val isShort: Boolean, val skillDescrip: String) {
}