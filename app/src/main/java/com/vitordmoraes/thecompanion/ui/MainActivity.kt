package com.vitordmoraes.thecompanion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitordmoraes.thecompanion.App
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.adapter.CharAdapter
import com.vitordmoraes.thecompanion.databinding.ActivityMainBinding
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.ui.CharacterActivity.CharacterActivity
import com.vitordmoraes.thecompanion.ui.addChar.AddCharacterActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val repository by lazy { App.repository }
    private val adapter by lazy { CharAdapter(::onShortItemClicked,::onLongItemClicked)}
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

    }

    override fun onStart() {
        super.onStart()

        initUi()
    }

    private fun initUi() {
        binding.fab.setOnClickListener { view ->
            startActivity(AddCharacterActivity.getIntent(this))
        }
        characterRecyclerview.layoutManager = LinearLayoutManager(this)
        characterRecyclerview.adapter = adapter
        refresh()
    }

    override fun onResume() {
        super.onResume()

        refresh()
    }

    private fun refresh() {
        val newChars = repository.getChars()
        adapter.addNewChars(newChars)
    }

     private fun onShortItemClicked(character: Character){
        startActivity(CharacterActivity.getIntent(this, character)
                .putExtra("CHAR_KEY",character))
    }

     private fun onLongItemClicked( view: View, character: Character) {
        val builder = AlertDialog.Builder(view.context)

        builder.setTitle("Delete Character")
        builder.setMessage("Are you sure, you want delete ${character.name}?")
        builder.setPositiveButton(
                "Delete now!") { dialog, id ->
                repository.deleteChar(character.id)
                refresh()
                Toast.makeText(this, "${character.name} was deleted.",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(
                "Cancel"){ dialog, id ->
        }
        builder.show()
        refresh()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
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