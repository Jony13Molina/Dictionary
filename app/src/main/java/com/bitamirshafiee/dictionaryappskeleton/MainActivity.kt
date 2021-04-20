package com.bitamirshafiee.dictionaryappskeleton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.json.JSONArray
import java.lang.Exception

class MainActivity : AppCompatActivity(){


    private val KEY = "WORD_DEFINITION"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val queueQuery = Volley.newRequestQueue(this)
        button_find.setOnClickListener{
            val word = wordSearch.text


            val apiKey = "a46a2135-5f67-4786-8ae5-76eed1faee37"
            val url =
                "https://www.dictionaryapi.com/api/v3/references/learners/json/$word?key=$apiKey"


            val stringRequest = StringRequest(Request.Method.GET, url,
                { response ->

                    try{
                        extractWDefJSON(response)
                    }catch (exception : Exception){
                        exception.printStackTrace()
                    }


                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }
            )
            queueQuery.add(stringRequest)

        }
    }




      private fun extractWDefJSON(response : String){

          val jsonArray = JSONArray(response)

          val firstIndex = jsonArray.getJSONObject(0)
          val getShortDef = firstIndex.getJSONArray("shortdef")

          val firstDef = getShortDef.get(0)


          val intent = Intent(this, DefinitionActivity::class.java)
          intent.putExtra(KEY, firstDef.toString())
          startActivity(intent)

      }
}




