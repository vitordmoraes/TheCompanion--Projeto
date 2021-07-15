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
            val context = itemView.context
            val charAvatar = itemView.charAvatar
            charAvatar.setImageResource(context.resources.getIdentifier(character.uri, null, context.packageName))
            itemView.charClass.text = character.clas
            itemView.charName.text = character.name
            itemView.charRace.text = character.race
            itemView.charLvl.text = character.lvl


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
        char.addAll(newChars)
        notifyDataSetChanged()
    }


}


