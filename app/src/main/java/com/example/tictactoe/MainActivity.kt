package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var board: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  button1: Button = findViewById(R.id.b1)
        val  button2: Button = findViewById(R.id.b2)
        val  button3: Button = findViewById(R.id.b3)
        val  button4: Button = findViewById(R.id.b4)
        val  button5: Button = findViewById(R.id.b5)
        val  button6: Button = findViewById(R.id.b6)
        val  button7: Button = findViewById(R.id.b7)
        val  button8: Button = findViewById(R.id.b8)
        val  button9: Button = findViewById(R.id.b9)
        val  resetBtn: Button = findViewById(R.id.bRest)

            board = arrayOf(
            arrayOf(button1,button2,button3),
                arrayOf(button4,button5,button6),
                arrayOf(button7,button8,button9)
        )
        for (i:Array<Button> in board){
            for (button:Button in i){
                button.setOnClickListener(this)
            }
        }

        resetBtn.setOnClickListener{

        }


    }

    override fun onClick(view:View) {
        when(view.id){
            R.id.b1 ->{

            }
            R.id.b1 ->{

            }
            R.id.b3 ->{

            }
            R.id.b4 ->{

            }
            R.id.b5 ->{

            }
            R.id.b6 ->{

            }
            R.id.b7 ->{

            }
            R.id.b8 ->{

            }
            R.id.b9 ->{

            }
        }
    }
}