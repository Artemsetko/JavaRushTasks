
package com.javarush.task.task20.task2025;

/*
import java.util.Arrays;
import java.util.LinkedList;*//*


import java.util.Arrays;

*/
/*
Алгоритмы-числа
*//*

public class Solution {
   */
/* public static long[] getNumbers(long N)
    {
        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        int k = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > N)
            {
                k = i;
                break;
            } else if (arr[i] == N)
            {
                k = i;
                break;
            } else
            {
                k = i + 1;
            }
       long[] result = new long[k];
        for (int j = 0; j < k; j++)
            result[j] = arr[j];
       // Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        //long[] numbers = getNumbers(Integer.MAX_VALUE);
       long[] numbers = getNumbers(146511208);
//        int[] numbers = getNumbers(100);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }
}*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args)
    {
        Long t0 = System.currentTimeMillis();
        //long[] numbers = getNumbers(Integer.MAX_VALUE);
        long[] numbers = getNumbers(Long.MAX_VALUE);
//        int[] numbers = getNumbers(100);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));

    }
    public static long[] getNumbers(long N) {
        long[] result = null;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int degree = getDegree(i);

            long input = i;
            long sum = 0;
            long k;

            do {
                k = input % 10;
                int a = 1;
                for(int j = 0; j < degree; j++) {
                    a *= k;
                }
                sum += a;
            } while ( (input /= 10) > 0);

            if (sum == i) {
                list.add(i);
            }
        }
        result = new long[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    public static int getDegree(long i)
    {
        int degree = 0;

        do {
            degree += 1;
        } while ( (i /= 10) > 0);
        return degree;
    }
}
