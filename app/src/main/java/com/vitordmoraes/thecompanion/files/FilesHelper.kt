package com.vitordmoraes.thecompanion.files

import java.io.File

interface FilesHelper {

    fun saveData(fileName: String, data: String)

    fun getData(): List<File>

    fun deleteData(fileName: String)
}