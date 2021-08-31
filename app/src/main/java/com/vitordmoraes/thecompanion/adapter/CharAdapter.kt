package com.vitordmoraes.thecompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.databinding.CharacterViewBinding
import com.vitordmoraes.thecompanion.model.Character
import kotlin.reflect.KFunction2

class CharAdapter(private val onItemClicked: (Character) -> Unit,
                  private val onLongItemClicked: KFunction2<View, Character, Unit>) : RecyclerView.Adapter<CharAdapter.ViewHolder>() {

    private val char = mutableListOf<Character>()

    class ViewHolder(val binding: CharacterViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character,
                 onItemClicked: (Character) -> Unit,
                 onLongItemClicked: KFunction2<View, Character, Unit>) {
            val charAvatar = binding.charAvatar

            binding.charName.text = character.name
            binding.charRace.text = character.race
            binding.charClass.text = character.clas
            binding.charLvl.text = character.lvl

            when (character.clas) {
                "Artificer" ->  binding.charAvatar.setImageResource(R.drawable.artificer)
                "Barbarian" ->  binding.charAvatar.setImageResource(R.drawable.barbarian)
                "Bard" ->       binding.charAvatar.setImageResource(R.drawable.bard)
                "Blood hunter"->binding.charAvatar.setImageResource(R.drawable.bloodhunter)
                "Cleric"->      binding.charAvatar.setImageResource(R.drawable.cleric)
                "Druid"->       binding.charAvatar.setImageResource(R.drawable.druid)
                "Fighter"->     binding.charAvatar.setImageResource(R.drawable.fighter)
                "Monk"->        binding.charAvatar.setImageResource(R.drawable.monk)
                "Paladin"->     binding.charAvatar.setImageResource(R.drawable.paladin)
                "Ranger"->      binding.charAvatar.setImageResource(R.drawable.ranger)
                "Rogue"->       binding.charAvatar.setImageResource(R.drawable.rogue)
                "Sorcerer"->    binding.charAvatar.setImageResource(R.drawable.sorc)
                "Wizard"->      binding.charAvatar.setImageResource(R.drawable.wizard)
                "Custom Character"->binding.charAvatar.setImageResource(R.drawable.uachar)
            }

            itemView.setOnClickListener { onItemClicked(character) }

            itemView.setOnLongClickListener { onLongItemClicked(this.itemView, character)
            true }

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(char[position], onItemClicked, onLongItemClicked)
    }

    override fun getItemCount(): Int  = char.size

    fun addNewChars(newChars: List<Character>){
        char.clear()
        char.addAll(newChars)
        notifyDataSetChanged()
    }


}


