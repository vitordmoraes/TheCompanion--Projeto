package com.vitordmoraes.thecompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.model.Character
import kotlinx.android.synthetic.main.character_view.view.*
import kotlin.reflect.KFunction2

class CharAdapter(private val onItemClicked: (Character) -> Unit,
                  private val onLongItemClicked: KFunction2<View, Character, Unit>) : RecyclerView.Adapter<CharAdapter.ViewHolder>() {

    private val char = mutableListOf<Character>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(character: Character,
                 onItemClicked: (Character) -> Unit,
                 onLongItemClicked: KFunction2<View, Character, Unit>) {
            val charAvatar = itemView.charAvatar

            itemView.charName.text = character.name
            itemView.charRace.text = character.race
            itemView.charClass.text = character.clas
            itemView.charLvl.text = character.lvl

            when (character.clas) {
                "Artificer" ->  charAvatar.setImageResource(R.drawable.artificer)
                "Barbarian" ->  charAvatar.setImageResource(R.drawable.barbarian)
                "Bard" ->       charAvatar.setImageResource(R.drawable.bard)
                "Blood hunter"->charAvatar.setImageResource(R.drawable.bloodhunter)
                "Cleric"->      charAvatar.setImageResource(R.drawable.cleric)
                "Druid"->       charAvatar.setImageResource(R.drawable.druid)
                "Fighter"->     charAvatar.setImageResource(R.drawable.fighter)
                "Monk"->        charAvatar.setImageResource(R.drawable.monk)
                "Paladin"->     charAvatar.setImageResource(R.drawable.paladin)
                "Ranger"->      charAvatar.setImageResource(R.drawable.ranger)
                "Rogue"->       charAvatar.setImageResource(R.drawable.rogue)
                "Sorcerer"->    charAvatar.setImageResource(R.drawable.sorc)
                "Wizard"->      charAvatar.setImageResource(R.drawable.wizard)
                "Custom Character"->charAvatar.setImageResource(R.drawable.uachar)
            }

            itemView.setOnClickListener { onItemClicked(character) }

            itemView.setOnLongClickListener { onLongItemClicked(this.itemView, character)
            true }

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.character_view, parent, false)
        return ViewHolder(view)
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


