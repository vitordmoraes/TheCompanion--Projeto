package com.vitordmoraes.thecompanion.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.util.inflate
import com.vitordmoraes.thecompanion.model.Character
import kotlinx.android.synthetic.main.character_view.view.*

class CharAdapter() : RecyclerView.Adapter<CharAdapter.ViewHolder>() {

    private val char = mutableListOf<Character>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(character: Character) {
            val charAvatar = itemView.charAvatar

            itemView.charClass.text = character.clas
            itemView.charName.text = character.name
            itemView.charRace.text = character.race
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
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.character_view, parent, false)
        return ViewHolder(view)
        //return ViewHolder(parent.inflate(R.layout.character_view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(char[position])
    }

    override fun getItemCount(): Int  = char.size

    fun addNewChars(newChars: List<Character>){
        char.clear()
        char.addAll(newChars)
        notifyDataSetChanged()
    }


}


