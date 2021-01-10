//1910047 Ziang Zhao
package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.hardware.camera2.TotalCaptureResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import java.io.IOException
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var UserName: String? = null
    private var QuesList: ArrayList<Question>? = null
    private var CurrPosition: Int = 1
    private var SelectedOptionPosition: Int = 0
    private var CorrectAnswers = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        UserName = intent.getStringExtra(Constants.User_name)
        QuesList = Constants.getQuestions()


        QuesList!!.shuffle()                                                                          //shuffle the order of questions
        setQuestion()


                                                                                                     //set on click listener to make button clickable
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {


        val question = QuesList!![CurrPosition - 1]                                        //arraylist starts counting as zero

        defaultOptionsView()

        if (CurrPosition == QuesList!!.size) {
            btn_submit.text = "SUBMIT"
        } else {
            btn_submit.text = "NEXT"
        }

        progressBar.progress = CurrPosition
        tv_progress.text = "$CurrPosition/10"                                                        //set progress bar from one to ten

        tv_qustion.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (show in options) {
            show.setTextColor(Color.parseColor("#363A43"))                                 //set the background color when the user click on it.
            show.typeface = Typeface.DEFAULT
            show.background = ContextCompat.getDrawable(this, R.drawable.default_option)       // call the drawable
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        SelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD_ITALIC)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (SelectedOptionPosition == 0) {
                    CurrPosition++

                    when {
                        CurrPosition <= QuesList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, resultPage::class.java)
                            intent.putExtra(Constants.User_name, UserName)
                            intent.putExtra(Constants.Correct_answers, CorrectAnswers)
                            intent.putExtra(Constants.Total_questions, QuesList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                        val question = QuesList?.get(CurrPosition - 1)
                    if (question!!.correctAnswer != SelectedOptionPosition) {
                        answerView(SelectedOptionPosition, R.drawable.wrong_option)
                    } else {
                        CorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option)

                    if (CurrPosition == QuesList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "NEXT QUESTION"
                    }
                    SelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        if(answer == 1){
            tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
        }
        else if(answer == 2){
            tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
        }
        else if(answer == 3){
            tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
        }
        else{
            tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
        }
    }

}
