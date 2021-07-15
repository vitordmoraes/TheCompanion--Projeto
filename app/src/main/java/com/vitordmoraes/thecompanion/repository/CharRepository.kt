package com.vitordmoraes.thecompanion.repository

import com.vitordmoraes.thecompanion.model.Character

interface CharRepository {

    fun saveChar(char: Character)

    fun updateChar(char: Character)

    fun deleteChar(charName: String)

    fun getChars() : List<Character>

}