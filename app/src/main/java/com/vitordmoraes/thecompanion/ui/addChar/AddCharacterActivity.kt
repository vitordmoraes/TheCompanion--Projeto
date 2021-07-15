package com.vitordmoraes.thecompanion.ui.addChar

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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

        arrayFun()
        createChar()
    }

    private fun arrayFun() {

        val res : Resources = resources
        val items = res.getStringArray(R.array.character_avatar)

        charClassCreator.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, items)

    }

    private fun createChar() {
        addCharBtn.setOnClickListener{newChar()}
    }


    private fun newChar() {
        val newCharName = charNameCreator.text.toString()
        val newCharRace = charRaceCreator.text.toString()
        val newCharClass = charClassCreator.selectedItem.toString()
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
        } else {
            when {
                newCharName.isEmpty() -> Toast.makeText(applicationContext, "Character name is missing!", Toast.LENGTH_SHORT).show()
                newCharRace.isEmpty() -> Toast.makeText(applicationContext, "Character race is missing!", Toast.LENGTH_SHORT).show()
                newCharClass.isEmpty() -> Toast.makeText(applicationContext, "Character class is missing!", Toast.LENGTH_SHORT).show()
                newCharLvl.isEmpty() -> Toast.makeText(applicationContext, "Character level is missing!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}