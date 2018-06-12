package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        Testing test = new Testing();
        test.testingTruePairsOfStrings();
        test.testingFalsePairsOfStrings();
    }

    public static boolean isOneEditAway(String first, String second) {
        //checking for nulls, equals or too big diff in length
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;

        final long firstLength = first.length();
        final long secondLength = second.length();

        if (secondLength - firstLength > 1) return false;
        if (firstLength - secondLength > 1) return false;

        final char[] charsFromFirst = first.toCharArray();
        final char[] charsFromSecond = second.toCharArray();

        // if lengths are equal, there are all chars must be equal but 1
        if (firstLength == secondLength) {
            int count = 0;
            for (int i = 0; i < firstLength; i++) {
                if (charsFromFirst[i] != charsFromSecond[i]) {
                    count++;
                    if (count == 2) return false;
                }
            }
            return true;
        }

        // if firstLength > secondLength than we can skip only one char in first
        if (firstLength - secondLength == 1) {
            int offsetInFirst = 0;
            for (int i = 0; i < secondLength; i++) {
                if (charsFromFirst[i + offsetInFirst] != charsFromSecond[i]) {
                    offsetInFirst++;
                    i--;
                    if (offsetInFirst > 1) return false;
                }
            }
            return true;
        }

        // if firstLength < secondLength than we can skip only one char in second
        if (secondLength - firstLength == 1) {
            int offsetInSecond = 0;
            for (int i = 0; i < firstLength; i++) {
                if (charsFromFirst[i] != charsFromSecond[i + offsetInSecond]) {
                    offsetInSecond++;
                    i--;
                    if (offsetInSecond > 1) return false;
                }
            }
            return true;
        }

        return false;
    }
}

