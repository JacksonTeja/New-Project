package Basics;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        displayBoard(board);

        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            int[] move = getPlayerMove(board, currentPlayer);
            int row = move[0];
            int col = move[1];

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                displayBoard(board);

                if (isGameOver(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    System.out.println("It s a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Initialize the game board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the game board
    public static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Get a valid move from the player
    public static int[] getPlayerMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Player " + currentPlayer + ", enter row and column (e.g., 1 2): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                move[0] = row;
                move[1] = col;
                validInput = true;
            } else {
                System.out.println("Invalid Value Row and column must be between 1 and 3");
            }
        }

        return move;
    }

    // Check if a move is valid
    public static boolean isValidMove(char[][] board, int row, int col) {
        return board[row][col] == ' ';
    }

    // Check if the game is over
    public static boolean isGameOver(char[][] board, char currentPlayer) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Row
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Column
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Diagonal (top-left to bottom-right)
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Diagonal (top-right to bottom-left)
        }
        return false;
    }

    // Check if the board is full (a draw)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
