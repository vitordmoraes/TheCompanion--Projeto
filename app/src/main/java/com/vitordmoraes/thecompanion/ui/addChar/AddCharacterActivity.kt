package com.vitordmoraes.thecompanion.ui.addChar

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.App
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.databinding.AddCharacterBinding


class AddCharacterActivity :AppCompatActivity () {

    private lateinit var binding: AddCharacterBinding
    private val repository by lazy { App.repository }

    companion object {
        fun getIntent(context: Context):Intent =
                Intent(context, AddCharacterActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayFun()
        createChar()
    }

    private fun arrayFun() {
        val res : Resources = resources
        val avatar = res.getStringArray(R.array.character_avatar)
        val level = res.getStringArray(R.array.character_level)


        binding.charClassCreator.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, avatar)
        binding.charLevelCreator.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, level)


    }

    private fun createChar() {
        binding.addCharBtn.setOnClickListener{newChar()}
    }


    private fun newChar() {
        val newCharName = binding.charNameCreator.text.toString()
        val newCharRace = binding.charRaceCreator.text.toString()
        val newCharClass = binding.charClassCreator.selectedItem.toString()
        val newCharLvl = binding.charLevelCreator.selectedItem.toString()
        if (newCharName.isNotEmpty() &&
                newCharRace.isNotEmpty() ){
                    repository.saveChar(Character(
                        newCharName, newCharRace,
                        newCharClass, newCharLvl
            ))
            finish()
        } else {
            when {
                newCharName.isEmpty() -> Toast.makeText(applicationContext, "Character name is missing!", Toast.LENGTH_SHORT).show()
                newCharRace.isEmpty() -> Toast.makeText(applicationContext, "Character race is missing!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}