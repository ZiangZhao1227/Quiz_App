//1910047 Ziang Zhao
package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener {
            if (user_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()   //if editText view is empty then make a short toast
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)               //else then send then information from main page to question page and access the question page
                intent.putExtra(Constants.User_name, user_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
        floating_action_button.setOnClickListener {                                                       // make a Floating action bar on click listener and let it to access Vocabularies activity.
            val intent = Intent(this, Vocabularies::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {                                              //add a menu on the action bar and set events on each items.
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.developer -> {
                val intent = Intent(this, Developer::class.java)
                startActivity(intent)
                finish()
            }
            R.id.about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                finish()
            }
            R.id.mShare -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plan"
                val shareSubject = "Your subject here"

                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)

                startActivity(Intent.createChooser(intent, "Share Using"))

            }
            R.id.json ->{
                val intent = Intent(this, Jsonshow::class.java)
                startActivity(intent)
                finish()
            }


        }
        return super.onOptionsItemSelected(item)
    }

}
