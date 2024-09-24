package com.company;

import static java.lang.Math.*;

public class TicTacToe {
    private int winner = 0;
    private final int n;
    private final int[][] board;
    private final int[] rowSum, colSum;
    private int diagSum, revDiagSum;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
    }


    /**
     * @param player is either 0 or 1
     * @param row is the move's row index
     * @param col is the move's col index
     * @return winner +1 if the first player winws, -1 if the 2nd player wins and 0 otherwise
     * @throws IllegalArgumentException in case of an illegal move
     *
     * A play can win the tic-tac-toe game only if
     *      row is filled with same number OR
     *      col is filled with same number OR
     *      diagonal is filled with same number   [0][0], [1][1] [2][2] OR
     *      reverse diagonal is filled with same number [0][2], [1][1], [2][0]
     */
    public int move(int player, int row, int col) throws IllegalArgumentException {
        if (row < 0 || col < 0 || row >=n || col>= n) {
            throw  new IllegalArgumentException("Move out of boundary!");
        }
        if( board[row][col] !=0) {
            throw  new IllegalArgumentException("Square is already occupied");
        }
        if (player !=0 && player !=1) {
            throw  new IllegalArgumentException("Invalid player");
        }
        if (getWinner() != 0) {
            throw  new IllegalArgumentException("Game is already finished");
        }

        player = (player == 0) ? -1 : 1;
        board[row][col] = player;
        rowSum[row] +=player;
        colSum[col] +=player;
        if (row == col) {
            diagSum += player;
        }
        if (row == n-1-col) {
            revDiagSum += player;
        }
        if (rowSum[row] ==  abs(n) || colSum[col] == abs(n) || diagSum == abs(n) || revDiagSum == abs(n)) {
            winner = player;
        }
        return getWinner();
    }

    public int getWinner() {
        return winner;
    }
}
