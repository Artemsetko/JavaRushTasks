package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {

                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 0}
        };
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int[][] calcMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        int maxNumber = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    calcMatrix[i + 1][j + 1] = 0;
                } else {
                    int top = calcMatrix[i][j + 1];
                    int diag = calcMatrix[i][j];
                    int left = calcMatrix[i + 1][j];
                    int min = (top < diag) ? ((top < left) ? top : left) : ((diag < left) ? diag : left);
                    calcMatrix[i + 1][j + 1] = min + 1;
                }
            }
        }

        for (int i = 0; i < calcMatrix.length; i++) {
            for (int j = 0; j < calcMatrix[0].length; j++) {
                if (calcMatrix[i][j] > maxNumber) {
                    maxNumber = calcMatrix[i][j];
                }
            }
        }
        return maxNumber * maxNumber;
    }
}
