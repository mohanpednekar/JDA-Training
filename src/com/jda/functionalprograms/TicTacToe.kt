package com.jda.functionalprograms

import com.jda.functionalprograms.TicTacToe.Cell.O
import com.jda.functionalprograms.TicTacToe.Cell.X
import com.jda.utility.Utility
import java.util.*
import java.util.stream.IntStream

object TicTacToe {
    internal enum class Cell {
        EMPTY, X, O;

        val isNonEmpty: Boolean
            get() = this != EMPTY

        override fun toString(): String {
            when (this) {
                EMPTY -> return "-"
                X -> return "X"
                O -> return "O"
            }
        }
    }

    internal class TTTGame {
        var pxTurn = true
        var board: Array<Array<Cell?>>
        var turnCount: Int = 0
        var winner: Cell
        private var lastPlayer: Cell? = null
        private var lastPlayedX: Int = 0
        private var lastPlayedY: Int = 0

        init {
            turnCount = 0
            winner = Cell.EMPTY
            board = Array(BOARD_SIZE) { arrayOfNulls<Cell>(BOARD_SIZE) }
            for (i in 0 until BOARD_SIZE) {
                for (j in 0 until BOARD_SIZE) {
                    board[i][j] = Cell.EMPTY
                }
            }
        }

        private fun cellAt(cell: Int): Cell? {
            return board[cell / BOARD_SIZE][cell % BOARD_SIZE]
        }

        fun declareResult() {
            if (winnerFound()) {
                println("The winner is " + X.toString())
            } else {
                println("The game ended in a draw")
            }
        }

        private fun displayBoard() {
            Utility.printArray(board, BOARD_SIZE, BOARD_SIZE)
        }

        private fun downwardWin(): Boolean {
            return IntStream.range(0, BOARD_SIZE).allMatch { i -> board[i][i] == lastPlayer }
        }

        private fun horizontalWin(): Boolean {
            return IntStream.range(0, BOARD_SIZE).allMatch { i -> board[lastPlayedX][i] == lastPlayer }
        }

        private fun location(row: Int, column: Int): Int {
            return row * BOARD_SIZE + column
        }

        fun playNext(): Boolean {
            if (turnCount == 9) return false
            if (pxTurn) {
                playX()
            } else {
                playO()
            }
            displayBoard()
            switchTurn()
            return true
        }

        fun playO() {
            val step = takeInput()
            set(step, O)
            if (winningPosition(O, step)) {
                winner = O
            }
        }

        fun playX() {
            val step = randomCell()
            set(step, X)
            if (winningPosition(X, step)) {
                winner = X
            }
        }

        private fun randomCell(): Int {
            val random = Random()
            var cell: Int
            do {
                cell = random.nextInt(BOARD_SIZE * BOARD_SIZE)
            } while (cellAt(cell)?.isNonEmpty!!)
            return cell
        }

        private operator fun set(i: Int, cell: Cell) {
            board[i / BOARD_SIZE][i % BOARD_SIZE] = cell
        }

        private fun switchTurn() {
            pxTurn = !pxTurn
        }

        private fun takeInput(): Int {
            val scanner = Scanner(System.`in`)
            println("Enter row : ")
            val row = scanner.nextInt()
            println("Enter column : ")
            val column = scanner.nextInt()
            return location(row, column)
        }

        private fun upwardWin(): Boolean {
            return IntStream.range(0, BOARD_SIZE).allMatch { i -> board[i][BOARD_SIZE - i - 1] == lastPlayer }
        }

        private fun verticalWin(): Boolean {
            return IntStream.range(0, BOARD_SIZE).allMatch { i -> board[i][lastPlayedY] == lastPlayer }
        }

        // public isCompleted()
        internal fun winnerFound(): Boolean {
            return winner.isNonEmpty
        }

        private fun winningPosition(cell: Cell, step: Int): Boolean {
            lastPlayer = cell
            lastPlayedX = step / BOARD_SIZE
            lastPlayedY = step % BOARD_SIZE
            return verticalWin() || horizontalWin() || downwardWin() || upwardWin()
        }

        companion object {
            val BOARD_SIZE = 3
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val game = TTTGame()
        while (game.playNext()) if (game.winnerFound()) {
            break
        }
        game.declareResult()
    }
}
