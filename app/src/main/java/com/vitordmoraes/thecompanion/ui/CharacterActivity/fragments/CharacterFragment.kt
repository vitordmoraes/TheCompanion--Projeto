package com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.databinding.FragmentCharacterBinding
import com.vitordmoraes.thecompanion.viewModel.CharViewModel


class CharacterFragment : Fragment() {
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private val viewModel :CharViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterBinding.inflate(
            inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCharacter()
    }





    private fun getCharacter () {
        var char = viewModel.characterInfo.value


        if (char != null) {
        binding.characterName.text = char.name
        binding.characterLvl.text = char.lvl
        binding.characterRace.text = char.race
        binding.characterClass.text = char.clas
        binding.characterPB.text = viewModel.setCharPbBonus()

        when (char.clas) {
            "Artificer" -> binding.characterAvatar.setImageResource(R.drawable.artificer)
            "Barbarian" -> binding.characterAvatar.setImageResource(R.drawable.barbarian)
            "Bard" -> binding.characterAvatar.setImageResource(R.drawable.bard)
            "Blood hunter" -> binding.characterAvatar.setImageResource(R.drawable.bloodhunter)
            "Cleric" -> binding.characterAvatar.setImageResource(R.drawable.cleric)
            "Druid" -> binding.characterAvatar.setImageResource(R.drawable.druid)
            "Fighter" -> binding.characterAvatar.setImageResource(R.drawable.fighter)
            "Monk" -> binding.characterAvatar.setImageResource(R.drawable.monk)
            "Paladin" -> binding.characterAvatar.setImageResource(R.drawable.paladin)
            "Ranger" -> binding.characterAvatar.setImageResource(R.drawable.ranger)
            "Rogue" -> binding.characterAvatar.setImageResource(R.drawable.rogue)
            "Sorcerer" -> binding.characterAvatar.setImageResource(R.drawable.sorc)
            "Wizard" -> binding.characterAvatar.setImageResource(R.drawable.wizard)
            "Custom Character" -> binding.characterAvatar.setImageResource(R.drawable.uachar)
        }
      }

    }
}