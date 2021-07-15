package com.vitordmoraes.thecompanion.repository

import com.google.gson.Gson
import com.vitordmoraes.thecompanion.files.FilesHelper
import com.vitordmoraes.thecompanion.model.Character

class CharRepositoryImpl (
        private val filesHelper: FilesHelper,
        private val gson: Gson
        ) : CharRepository {

    private val chars = mutableListOf<Character>()

    override fun saveChar(char: Character) {
        filesHelper.saveData(char.id, gson.toJson(char))
    }

    override fun updateChar(char: Character) {
        deleteChar(char.id)
        saveChar(char)
    }

    override fun deleteChar(charId: String) {
        filesHelper.deleteData(charId)
    }

    override fun getChars(): List<Character> {
        val charFiles = filesHelper.getData()

        return charFiles.map {
            gson.fromJson(it.readText(), Character::class.java)
        }
    }
}