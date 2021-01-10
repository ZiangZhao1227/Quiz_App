//1910047 Ziang Zhao
package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result_page.*
import org.w3c.dom.Text

class resultPage : AppCompatActivity() {                                                             //acquire information from constants class
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)

        val username = intent.getStringExtra(Constants.User_name)
        user_name_final.text = username
        val totalQuestions = intent.getIntExtra(Constants.Total_questions,0)
        val correctAnswers = intent.getIntExtra(Constants.Correct_answers,0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions."

        val textView:TextView = findViewById(R.id.tv_congratulations)
        val imageView:ImageView = findViewById(R.id.imageView)
        val textView2:TextView = findViewById(R.id.tv_assessment)


        if(correctAnswers<5){                                                                        //make a assessment of users word level .
            textView.text = "Come on, try again."
            imageView.setImageResource(R.drawable.fail)

            if (correctAnswers in 0..2){
                textView2.text = "D"
            }
            else {
                textView2.text = "C"
            }

        }
        else{
            when (correctAnswers) {
                5 ->{
                    textView2.text = "C"
                }
                in 6..7 -> {
                    textView2.text = "B"
                }
                in 8..9 -> {
                    textView2.text = "A"
                }
                else -> {
                    textView2.text = "S"
                }
            }
        }

        btn_finish.setOnClickListener{                                                               //set on click listener when click redo button return to the main page
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {                                         //show the menu and each sections again.
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