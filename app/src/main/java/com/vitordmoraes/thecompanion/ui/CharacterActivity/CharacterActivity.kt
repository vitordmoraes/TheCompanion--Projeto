package com.vitordmoraes.thecompanion.ui.CharacterActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.model.Character
import kotlinx.android.synthetic.main.character_activity.*
import kotlinx.android.synthetic.main.character_view.*


class CharacterActivity : AppCompatActivity() {

    private var character: Character? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.character_activity)
        getCharacter()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    companion object {
        private const val CHAR_KEY = "Character"


        fun getIntent(context: Context, character: Character): Intent =
                Intent(context, CharacterActivity::class.java).apply {
                    putExtra(CHAR_KEY, character)
                }
    }

    private fun showData() {
        val character = character
        if (character != null) {
            characterName.text = character.name
            characterLvl.text = character.lvl
            characterRace.text = character.race
            charClass.text = character.clas
        }

    }

    private fun getCharacter() {
        character = intent.getSerializableExtra(CHAR_KEY) as Character
    }






}