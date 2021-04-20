package com.bitamirshafiee.dictionaryappskeleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_definition.*

class DefinitionActivity : AppCompatActivity() {

    private val KEY = "WORD_DEFINITION"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definition)



        def_text_view.text = intent.getStringExtra(KEY)


        back_img_view.setOnClickListener{
            finish()
        }
    }
}