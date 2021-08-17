package com.vitordmoraes.thecompanion.ui.CharacterActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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

    private lateinit var viewModel : CharViewModel

    private val characterFragment by lazy { CharacterFragment() }
    private val  statsFragment by lazy { StatsFragment() }
    private val  spellsFragment by lazy { SpellsFragment() }
    private val  notesFragment by lazy {  NotesFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_activity)


    }

    override fun onStart() {
        super.onStart()
        getCharacter()
        initUi()


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



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.edit_character_menu, menu)
        return true
    }


    private fun navControler() {
        val navController = findNavController(R.id.charNavMenu)
        val appControler = AppBarConfiguration(setOf(
            R.id.characterFragment,
            R.id.statsFragment,
            R.id.spellsFragment,
            R.id.notesFragment))
    setupActionBarWithNavController(navController,appControler)
    charNavMenu.setupWithNavController(navController)
    }



    fun initUi(){
    val fragmentCharacter = CharacterFragment()
        setFragment(fragmentCharacter)
        charNavMenu.setOnNavigationItemSelectedListener(this)

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