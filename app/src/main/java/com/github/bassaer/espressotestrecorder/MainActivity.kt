package com.github.bassaer.espressotestrecorder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var fab: FloatingActionButton
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        textView = findViewById(R.id.left_text)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getData().observe(this, Observer { data ->
            textView.text = data.toString()
        })

        fab = findViewById<FloatingActionButton>(R.id.fab).apply {
            setOnClickListener {
                viewModel.countUp()
                textView.text = viewModel.getCount().toString()
            }
        }
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
            R.id.action_reset -> {
                viewModel.reset()
                return true
            }
            R.id.action_jump -> {
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
