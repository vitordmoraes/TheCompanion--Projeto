package com.vitordmoraes.thecompanion.ui.CharacterActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments.CharacterFragment
import com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments.NotesFragment
import com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments.SpellsFragment
import com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments.StatsFragment
import com.vitordmoraes.thecompanion.viewModel.CharViewModel
import kotlinx.android.synthetic.main.character_activity.*



class CharacterActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var viewModel: CharViewModel
    private val characterFragment by lazy { CharacterFragment() }
    private val  statsFragment by lazy { StatsFragment() }
    private val  spellsFragment by lazy { SpellsFragment() }
    private val  notesFragment by lazy {  NotesFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_activity)

        viewModel = ViewModelProvider(this).get(CharViewModel::class.java)

    }



    override fun onStart() {
        super.onStart()
        initUi()
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
        viewModel.setCharacterInfo(char)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.edit_character_menu, menu)
        return true
    }




    fun initUi(){
    val fragmentCharacter = CharacterFragment()
        setFragment(fragmentCharacter)
        charNavMenu.setOnNavigationItemSelectedListener(this)
        getCharacter()

    }

    private fun setFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_container, fragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.characterMenu -> setFragment(characterFragment)
            R.id.statsMenu -> setFragment(statsFragment)
            R.id.spellsMenu -> setFragment(spellsFragment)
            R.id.notesMenu -> setFragment(notesFragment)
        }
        return true
    }



}