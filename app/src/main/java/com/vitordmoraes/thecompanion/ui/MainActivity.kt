package com.vitordmoraes.thecompanion.ui

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vitordmoraes.thecompanion.App
import com.vitordmoraes.thecompanion.R
import com.vitordmoraes.thecompanion.model.Character
import com.vitordmoraes.thecompanion.ui.addChar.AddCharacterActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val repository by lazy { App.repository }
    private val adapter by lazy { CharAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        initUi()
    }

    private fun initUi() {
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            startActivity(AddCharacterActivity.getIntent(this))
        }


        characterRecyclerview.layoutManager = LinearLayoutManager(this)
        characterRecyclerview.adapter = adapter

        onRefresh()

    }

    override fun onResume() {
        super.onResume()

        onRefresh()
    }

    private fun onRefresh() {
        val newChars = repository.getChars()
        adapter.addNewChars(newChars)
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