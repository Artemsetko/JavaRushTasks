package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        PhotoPaint photoPaint = new PhotoPaint();
        Color[][] image = {{Color.BLUE, Color.GREEN, Color.RED}, {Color.INDIGO, Color.ORANGE, Color.VIOLET}};
        boolean isPossible = photoPaint.paintFill(image, 1, 1, Color.YELLOW);
        System.out.println(isPossible);
    }
}
