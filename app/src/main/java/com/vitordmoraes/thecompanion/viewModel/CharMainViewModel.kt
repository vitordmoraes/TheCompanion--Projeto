package com.vitordmoraes.thecompanion.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.repository.CharRepositoryImpl

class CharMainViewModel(private val repository: CharRepositoryImpl) :ViewModel()  {

    val charInfo = MutableLiveData<List<Character>>()

    fun getInfoCharacter() {
        val response = repository.getChars()
    }


}