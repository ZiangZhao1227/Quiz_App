//1910047 Ziang Zhao
package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_vocabularies.*
import kotlinx.android.synthetic.main.word_item.*
import kotlin.random.Random

class Vocabularies : AppCompatActivity(),Adapter.OnItemClickListener {

    private val exampleList = generateDummyList(10)                                            //set the size of list is 10
    private val adapter = Adapter(exampleList,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabularies)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }




    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }

    private fun generateDummyList(size: Int): ArrayList<WordItem> {                                  //set words value to each line
        val list = ArrayList<WordItem>()
        for (i in 1 until size + 1) {

            var item = WordItem(R.drawable.ic_word, "Word $i", "word")
            when (i) {
                1 -> item.text2 = "koira"
                2 -> item.text2 = "yksi"
                3 -> item.text2 = "kirja"
                4 -> item.text2 = "kissa"
                5 -> item.text2 = "maa"
                6 -> item.text2 = "kukat"
                7 -> item.text2 = "peli"
                8 -> item.text2 = "talo"
                9 -> item.text2 = "saari"
                10 -> item.text2 = "kuu"
                else -> item.text2 = "ADD MORE WORD"


            }
            list += item

        }
        return list
    }

    override fun onItemClick(position: Int) {                                                        //set on click events , replace the word to checked and also show a toast .
        Toast.makeText(this, "word ${position+1} checked", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleList[position]
        clickedItem.text1 = "Checked"
        adapter.notifyItemChanged(position)
    }
}