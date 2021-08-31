package com.vitordmoraes.thecompanion.ui.CharacterActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.databinding.CharacterActivityBinding
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.ui.CharacterActivity.fragments.*
import com.vitordmoraes.thecompanion.viewModel.CharViewModel


class CharacterActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: CharacterActivityBinding
    private lateinit var viewModel: CharViewModel
    private val characterFragment by lazy { CharacterFragment() }
    private val  statsFragment by lazy { StatsFragment() }
    private val  spellsFragment by lazy { SpellsFragment() }
    private val  notesFragment by lazy {  NotesFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CharacterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    val fragmentEditChar = EditCharacterFragment()
        if (viewModel.characterInfo.value?.maxHP == null) {
            setFragment(fragmentEditChar)
        } else {
            setFragment(fragmentCharacter)
        }
        binding.charNavMenu.setOnNavigationItemSelectedListener(this)
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


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }



}