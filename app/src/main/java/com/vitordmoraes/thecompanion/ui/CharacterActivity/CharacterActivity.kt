package com.vitordmoraes.thecompanion.ui.CharacterActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.model.Character
import kotlinx.android.synthetic.main.character_activity.*
import kotlinx.android.synthetic.main.character_view.*
import kotlinx.android.synthetic.main.character_view.view.*


class CharacterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_activity)
    }

    override fun onStart() {
        super.onStart()
        getCharacter()
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        private const val CHAR_KEY = "Character"


        fun getIntent(context: Context, character: Character): Intent =
                Intent(context, CharacterActivity::class.java).apply {
                    putExtra(CHAR_KEY, character)
                }
    }


    private fun getCharacter() {
        val char = intent.extras?.getParcelable<Character>(CHAR_KEY)!!


        characterName.text = char.name
        characterLvl.text = char.lvl
        characterRace.text = char.race
        characterClass.text = char.clas

        when (char.clas) {
            "Artificer" ->  characterAvatar.setImageResource(R.drawable.artificer)
            "Barbarian" ->  characterAvatar.setImageResource(R.drawable.barbarian)
            "Bard" ->       characterAvatar.setImageResource(R.drawable.bard)
            "Blood hunter"->characterAvatar.setImageResource(R.drawable.bloodhunter)
            "Cleric"->      characterAvatar.setImageResource(R.drawable.cleric)
            "Druid"->       characterAvatar.setImageResource(R.drawable.druid)
            "Fighter"->     characterAvatar.setImageResource(R.drawable.fighter)
            "Monk"->        characterAvatar.setImageResource(R.drawable.monk)
            "Paladin"->     characterAvatar.setImageResource(R.drawable.paladin)
            "Ranger"->      characterAvatar.setImageResource(R.drawable.ranger)
            "Rogue"->       characterAvatar.setImageResource(R.drawable.rogue)
            "Sorcerer"->    characterAvatar.setImageResource(R.drawable.sorc)
            "Wizard"->      characterAvatar.setImageResource(R.drawable.wizard)
            "Custom Character"->characterAvatar.setImageResource(R.drawable.uachar)
        }
    }






}