//1910047 Ziang Zhao
package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class ListAdapter(val context: Context, val list:ArrayList<MyData>):BaseAdapter(){                  //implement recyclerView by using Adapter
    override fun getCount(): Int {

        return list.size
    }

    override fun getItem(p0: Int): Any {

        return p0
    }

    override fun getItemId(p0: Int): Long {

        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = LayoutInflater.from(context).inflate(R.layout.new_layout,parent,false)
        val id =view.findViewById<TextView>(R.id.textView_id)
        val word = view.findViewById<TextView>(R.id.textView_word)
        val finnish = view.findViewById<TextView>(R.id.textView_finnish)
        val exampleOne = view.findViewById<TextView>(R.id.textView_exampleOne)
        val exampleTwo = view.findViewById<TextView>(R.id.TextView_exampleTwo)
        val exampleThree = view.findViewById<TextView>(R.id.textView_exampleThree)

        id.text = list[position].id.toString()
        word.text = list[position].word
        finnish.text = list[position].finnish
        exampleOne.text = list[position].exampleOne
        exampleTwo.text = list[position].exampleTwo
        exampleThree.text = list[position].exampleThree
        return view



    }

}