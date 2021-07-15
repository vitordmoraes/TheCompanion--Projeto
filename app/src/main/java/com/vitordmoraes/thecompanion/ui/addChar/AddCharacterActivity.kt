package com.vitordmoraes.thecompanion.ui.addChar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.App
import com.vitordmoraes.thecompanion.App.*
import com.vitordmoraes.thecompanion.R
import kotlinx.android.synthetic.main.add_character.*
import kotlinx.android.synthetic.main.content_main.*


class AddCharacterActivity :AppCompatActivity () {

    private val repository by lazy { App.repository }

    companion object {
        fun getIntent(context: Context):Intent = Intent(context,
        AddCharacterActivity::class.java)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_character)
        createChar()
    }

    private fun createChar() {
        addCharBtn.setOnClickListener{newChar()}
    }

    private fun newChar() {
        val newCharName = charNameCreator.text.toString()
        val newCharRace = charRaceCreator.text.toString()
        val newCharClass = charClassCreator.text.toString()
        val newCharLvl = charLevelCreator.text.toString()
        if (newCharName.isNotEmpty() &&
                newCharRace.isNotEmpty() &&
                newCharClass.isNotEmpty() &&
                newCharLvl.isNotEmpty()) {
            repository.saveChar(Character(
                    newCharName, newCharRace,
                    newCharClass, newCharLvl
            ))
            finish()
        }
    }



}