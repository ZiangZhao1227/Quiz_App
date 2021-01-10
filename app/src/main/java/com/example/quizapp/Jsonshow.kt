//1910047 Ziang Zhao
package com.example.quizapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_jsonshow.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class Jsonshow : AppCompatActivity() {                                                               //implement data which loaded from metropolia website by using json file
    lateinit var pDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jsonshow)
        val url = "https://users.metropolia.fi/~ziangz/Users.json"
        AsyncTaskHandler().execute(url)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    inner class AsyncTaskHandler : AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            pDialog = ProgressDialog(this@Jsonshow)
            pDialog.setMessage("Please Wait!")
            pDialog.setCancelable(false)
            pDialog.show()
        }

        override fun doInBackground(vararg url: String?): String {
            val res: String
            val connection = URL(url[0]).openConnection() as HttpURLConnection
            try {
                connection.connect()
                res = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }

            } finally {
                connection.disconnect()
            }
            return res
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            jsonResult(result)
            if (pDialog.isShowing)
                pDialog.dismiss()
            jsonResult(result)
        }

        private fun jsonResult(jsonString: String?) {
            val jsonArray = JSONArray(jsonString)
            val list = ArrayList<MyData>()
            var i = 0
            while (i < jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                list.add(
                    MyData(
                        jsonObject.getInt("id"),
                        jsonObject.getString("word"),
                        jsonObject.getString("finnish"),
                        jsonObject.getString("exampleOne"),
                        jsonObject.getString("exampleTwo"),
                        jsonObject.getString("exampleThree")
                    )
                )
                i++
            }
            val adapter = ListAdapter(this@Jsonshow, list)
            mylist.adapter = adapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }
}