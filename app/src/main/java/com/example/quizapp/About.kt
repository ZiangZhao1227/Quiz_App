//1910047 Ziang Zhao
package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class About : AppCompatActivity() {                                                                  //creat a button which can return back to main activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        val intent =  Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }
}