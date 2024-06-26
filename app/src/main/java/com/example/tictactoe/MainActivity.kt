package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Variables to keep track of current player and turn count
    var PLAYER = true
    var TRUN_COUNT = 0

    // 2D array to represent the status of each cell on the board
    var board_status = Array(3) { IntArray(3) }

    // 2D array to hold buttons representing the Tic Tac Toe board
    lateinit var board: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons and TextView from XML layout
        val button1: Button = findViewById(R.id.b1)
        val button2: Button = findViewById(R.id.b2)
        val button3: Button = findViewById(R.id.b3)
        val button4: Button = findViewById(R.id.b4)
        val button5: Button = findViewById(R.id.b5)
        val button6: Button = findViewById(R.id.b6)
        val button7: Button = findViewById(R.id.b7)
        val button8: Button = findViewById(R.id.b8)
        val button9: Button = findViewById(R.id.b9)
        // Initialize other buttons similarly...
        val resetBtn: Button = findViewById(R.id.bRest)
        val displayTV: TextView = findViewById(R.id.displayTv)

        // Initialize the board array with button objects
        board = arrayOf(
            arrayOf(button1, button2, button3),
            arrayOf(button4, button5, button6),
            arrayOf(button7, button8, button9)
        )
        // Set OnClickListener for each button in the board
        for (i: Array<Button> in board) {
            for (button: Button in i) {
                button.setOnClickListener(this)
            }
        }

        // Set OnClickListener for reset button
        resetBtn.setOnClickListener {
            PLAYER = true
            TRUN_COUNT = 0
            displayTV.text = ""
            initializeBoardStatus()
        }

        // Initialize the board status
        initializeBoardStatus()
    }

    // Function to initialize the board status
    private fun initializeBoardStatus() {
        for (i in 0..2) {
            for (j in 0..2) {
                // Set all cells to empty (-1) and enable buttons
                board_status[i][j] = -1
                board[i][j].isEnabled = true
                board[i][j].text = ""
            }
        }
    }

    // OnClickListener implementation for buttons
    override fun onClick(view: View) {
        when (view.id) {

            // Handle click events for each button on the board
            R.id.b1 -> {
                updateValue(row = 0, col = 0, player = PLAYER)

            }

            // Handle other button click events similarly...
            R.id.b2 -> {
                updateValue(row = 0, col = 1, player = PLAYER)

            }

            R.id.b3 -> {
                updateValue(row = 0, col = 2, player = PLAYER)

            }

            R.id.b4 -> {
                updateValue(row = 1, col = 0, player = PLAYER)

            }

            R.id.b5 -> {
                updateValue(row = 1, col = 1, player = PLAYER)

            }

            R.id.b6 -> {
                updateValue(row = 1, col = 2, player = PLAYER)

            }

            R.id.b7 -> {
                updateValue(row = 2, col = 0, player = PLAYER)

            }

            R.id.b8 -> {
                updateValue(row = 2, col = 1, player = PLAYER)

            }

            R.id.b9 -> {
                updateValue(row = 2, col = 2, player = PLAYER)

            }
        }
        // Increment turn count and switch player
        TRUN_COUNT++
        PLAYER = !PLAYER

        // Update display with current player's turn
        if (PLAYER) {
            updateDisplay("Player X Turn")
        } else {
            updateDisplay("Player 0 Turn")
        }

        // Check for game draw
        if (TRUN_COUNT == 9) {
            updateDisplay("Game Draw")
        }

        // Check for winner
        checkWinner()
    }

    // Function to check for a winner
    private fun checkWinner() {
//        Horizontal Rows
        for (i in 0..2) {
            if (board_status[i][0] == board_status[i][1] && board_status[i][0] == board_status[i][2]) {
                if (board_status[i][0] == 1) {
                    updateDisplay("Player X is Winner")
                    break
                } else if (board_status[i][0] == 0) {
                    updateDisplay("Player O is Winner")
                    break
                }
            }
        }
//        Vertical Colums
        for (i in 0..2) {
            for (j in 0..2) {
                if (board_status[0][i] == board_status[1][i] && board_status[0][i] == board_status[2][i]) {
                    if (board_status[0][i] == 1) {
                        updateDisplay("Player X is Winner")
                        break
                    } else if (board_status[0][i] == 0) {
                        updateDisplay("Player O is Winner")
                        break
                    }
                }

            }
        }

//      First Diagonal
        if (board_status[0][0] == board_status[1][1] && board_status[0][0] == board_status[2][2]) {
            if (board_status[0][0] == 1) {
                updateDisplay("Player X is Winner")
            } else if (board_status[0][0] == 0) {
                updateDisplay("Player O is Winner")
            }
        }


        //      Second Diagonal
        if (board_status[0][2] == board_status[1][1] && board_status[0][2] == board_status[2][0]) {
            if (board_status[0][2] == 1) {
                updateDisplay("Player X is Winner")
            } else if (board_status[0][0] == 0) {
                updateDisplay("Player O is Winner")
            }
        }
    }

    // Function to update the display text
    private fun updateDisplay(s: String) {
        findViewById<TextView>(R.id.displayTv).text = s
        if (s.contains("Winner")) {
            disableButton()
        }
    }

    // Function to disable all buttons on the board
    private fun disableButton() {
        for (i in board) {
            for (button in i) {
                button.isEnabled = false
            }
        }
    }

    // Function to update the value of a cell on the board
    private fun updateValue(row: Int, col: Int, player: Boolean) {
        // Set text and value based on current player
        val text = if (player) "X" else "0"
        val value = if (player) 1 else 0
        board[row][col].apply {
            isEnabled = false
            setText(text)
        }
        board_status[row][col] = value

    }
}