package com.example.offloadinglibrary;

class Main {
    static int n = 5;
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
    boolean solveNQUtil(int board[][], int col)
    {
        if (col >= n)
            return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1) == true)
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }
    boolean solveNQ()
    {
        int[][] board = new int[n][n];
        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
        return true;
    }
}