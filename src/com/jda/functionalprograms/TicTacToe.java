package com.jda.functionalprograms;

import com.jda.utility.Utility;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static com.jda.functionalprograms.TicTacToe.Cell.O;
import static com.jda.functionalprograms.TicTacToe.Cell.X;

public
class TicTacToe {
	public static
	void main(String[] args) {
		TTTGame game = new TTTGame();
		while (game.playNext()) if (game.winnerFound()) break;
		game.declareResult();
	}

	enum Cell {
		EMPTY, X, O;

		public
		boolean isNonEmpty() {
			return this != EMPTY;
		}
	}

	static
	class TTTGame {
		public static final int BOARD_SIZE = 3;
		boolean pxTurn = true;
		Cell[][] board;
		int turnCount;
		Cell winner;
		private Cell lastPlayer;
		private int lastPlayedX;
		private int lastPlayedY;

		TTTGame() {
			turnCount = 0;
			winner = Cell.EMPTY;
			board = new Cell[BOARD_SIZE][BOARD_SIZE];
			for (int i = 0; i < BOARD_SIZE; i++)
				for (int j = 0; j < BOARD_SIZE; j++)
					board[i][j] = Cell.EMPTY;
		}

		boolean playNext() {
			if (turnCount == 9) return false;
			if (pxTurn) playX();
			else playO();
			displayBoard();
			switchTurn();
			return true;
		}

		private
		void displayBoard() {
			Utility.printArray(board, BOARD_SIZE, BOARD_SIZE);
		}

		private
		void switchTurn() {
			pxTurn = !pxTurn;
		}

		private
		int randomCell() {
			Random random = new Random();
			int cell;
			do cell = random.nextInt(BOARD_SIZE * BOARD_SIZE); while (cellAt(cell).isNonEmpty());
			return cell;
		}

		private
		Cell cellAt(int cell) {
			return board[cell / BOARD_SIZE][cell % BOARD_SIZE];
		}

		void playX() {
			int step = randomCell();
			set(step, X);
			if (winningPosition(X, step)) winner = X;
		}

		private
		boolean winningPosition(Cell cell, int step) {
			lastPlayer = cell;
			lastPlayedX = step / BOARD_SIZE;
			lastPlayedY = step % BOARD_SIZE;
			return verticalWin() || horizontalWin() || downwardWin() || upwardWin();
		}

		private
		boolean upwardWin() {
			return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[i][BOARD_SIZE - i - 1].equals(lastPlayer));
		}

		private
		boolean downwardWin() {
			return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[i][i].equals(lastPlayer));
		}

		private
		boolean horizontalWin() {
			return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[lastPlayedX][i].equals(lastPlayer));
		}

		private
		boolean verticalWin() {
			return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[i][lastPlayedY].equals(lastPlayer));
		}

		void playO() {
			int step = takeInput();
			set(step, O);
			if (winningPosition(O, step)) winner = O;
		}

		private
		void set(int i, Cell cell) {
			board[i / BOARD_SIZE][i % BOARD_SIZE] = cell;
		}

		private
		int takeInput() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter row : ");
			int row = scanner.nextInt();
			System.out.println("Enter column : ");
			int column = scanner.nextInt();
			return location(row, column);
		}

		private
		int location(int row, int column) {
			return row * BOARD_SIZE + column;
		}

		//public isCompleted()
		private
		boolean winnerFound() {
			return winner.isNonEmpty();
		}

		void declareResult() {
			if (winnerFound()) System.out.println("The winner is " + X.toString());
			else System.out.println("The game ended in a draw");
		}
	}
}
