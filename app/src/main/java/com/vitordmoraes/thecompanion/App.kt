package com.vitordmoraes.thecompanion

import android.app.Application
import com.google.gson.Gson
import com.vitordmoraes.thecompanion.files.FilesHelper
import com.vitordmoraes.thecompanion.files.FilesHelperImpl
import com.vitordmoraes.thecompanion.repository.CharRepository
import com.vitordmoraes.thecompanion.repository.CharRepositoryImpl
import java.io.File

class App : Application() {

    companion object {
        private lateinit var instance: App

        private val filesHelper: FilesHelper by lazy {
            FilesHelperImpl(instance.filesDir)
        }

        private fun getFilesDirectory(): File {
            val directory = File(instance.getExternalFilesDir(null), "")

            if (!directory.exists()) {
                directory.mkdirs()
            }

            return directory
        }

        private val gson by lazy { Gson() }

        val repository: CharRepository by lazy {
            CharRepositoryImpl(filesHelper, gson)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}