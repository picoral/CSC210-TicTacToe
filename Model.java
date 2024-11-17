package com.tictactoe;

public class Model {
    private Character[][] grid = new Character[3][3];

    public Model() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }    

}
