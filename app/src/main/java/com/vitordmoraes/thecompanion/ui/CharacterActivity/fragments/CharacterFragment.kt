package com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.viewModel.CharViewModel
import kotlinx.android.synthetic.main.fragment_character.*


class CharacterFragment : Fragment() {

    private val viewModel :CharViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCharacter()
    }





    private fun getCharacter () {
        var char = viewModel.characterInfo.value


        if (char != null) {
        characterName.text = char.name
        characterLvl.text = char.lvl
        characterRace.text = char.race
        characterClass.text = char.clas
        characterPB.text = viewModel.setCharPbBonus()

        when (char.clas) {
            "Artificer" -> characterAvatar.setImageResource(R.drawable.artificer)
            "Barbarian" -> characterAvatar.setImageResource(R.drawable.barbarian)
            "Bard" -> characterAvatar.setImageResource(R.drawable.bard)
            "Blood hunter" -> characterAvatar.setImageResource(R.drawable.bloodhunter)
            "Cleric" -> characterAvatar.setImageResource(R.drawable.cleric)
            "Druid" -> characterAvatar.setImageResource(R.drawable.druid)
            "Fighter" -> characterAvatar.setImageResource(R.drawable.fighter)
            "Monk" -> characterAvatar.setImageResource(R.drawable.monk)
            "Paladin" -> characterAvatar.setImageResource(R.drawable.paladin)
            "Ranger" -> characterAvatar.setImageResource(R.drawable.ranger)
            "Rogue" -> characterAvatar.setImageResource(R.drawable.rogue)
            "Sorcerer" -> characterAvatar.setImageResource(R.drawable.sorc)
            "Wizard" -> characterAvatar.setImageResource(R.drawable.wizard)
            "Custom Character" -> characterAvatar.setImageResource(R.drawable.uachar)
        }
      }

    }
}