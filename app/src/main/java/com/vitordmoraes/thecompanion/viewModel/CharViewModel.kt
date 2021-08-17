package com.vitordmoraes.thecompanion.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitordmoraes.thecompanion.model.Character

class CharViewModel : ViewModel() {

    private var characterValue : Character = Character(" ","", "1"," ")
    private val _characterInfo = MutableLiveData<Character>()
    val characterInfo : LiveData<Character> = _characterInfo

    fun setCharacterInfo() {
        _characterInfo.value = characterValue
    }

    fun getCharacterInfo(characterValue: Character) {
        this.characterValue = characterValue
    }


}