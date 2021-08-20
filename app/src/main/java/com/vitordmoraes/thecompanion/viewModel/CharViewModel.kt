package com.vitordmoraes.thecompanion.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.repository.CharRepository

class CharViewModel() : ViewModel() {


    private val _characterInfo = MutableLiveData<Character>()
    val characterInfo : LiveData<Character> = _characterInfo



    fun setCharacterInfo(character: Character){
        _characterInfo.value = character
    }


}

