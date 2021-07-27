package com.vitordmoraes.thecompanion.ui.CharacterActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.model.Character


class CharacterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.character_activity)
    }


    companion object {
        private const val CHAR_KEY = "Character"

        fun getIntent(context: Context, character: Character): Intent =
                Intent(context, CharacterActivity::class.java).apply {
                    putExtra(CHAR_KEY, character)
                }
        }



}