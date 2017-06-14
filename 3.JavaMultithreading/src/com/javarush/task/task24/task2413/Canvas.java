package com.javarush.task.task24.task2413;

/**
 * Created by Work-TESTER on 14.06.2017.
 */
public class Canvas {
    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height+2][width+2];
    }

    public void setPoint(double x, double y, char c){
        if (x > 0 || y > 0 || y < matrix.length || x < matrix[0].length) {
            int roundX = (int) Math.round(x);
            int roundY = (int) Math.round(y);
            this.matrix[roundY][roundX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;j < matrix[0].length; j++){
                if(matrix[i][j]!= 0){
                    setPoint(x+j, y+i, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
