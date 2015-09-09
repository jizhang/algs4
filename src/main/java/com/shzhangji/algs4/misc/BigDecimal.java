package com.shzhangji.algs4.misc;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BigDecimal {

    public static String add(String a, String b) {

        int length = Math.max(a.length(), b.length()) + 1;
        int[] arrA = new int[length];
        int[] arrB = new int[length];

        for (int i = 0; i < a.length(); ++i) {
            arrA[i] = a.charAt(a.length() - i - 1) - '0';
        }
        for (int i = 0; i < b.length(); ++i) {
            arrB[i] = b.charAt(b.length() - i - 1) - '0';
        }

        for (int i = 0; i < length; ++i) {
            arrA[i] += arrB[i];
            if (arrA[i] >= 10) {
                arrA[i] -= 10;
                ++arrA[i + 1];
            }
        }

        int i;
        for (i = length - 1; arrA[i] == 0; --i);

        StringBuilder result = new StringBuilder();
        for (; i >= 0; --i) {
            result.append(arrA[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String a = StdIn.readString();
        String op = StdIn.readString();
        String b = StdIn.readString();

        String result = "";
        switch (op) {
        case "+":
            result = add(a, b);
            break;

        default:
            result = "Invalid operator.";
            break;
        }

        StdOut.println(result);
    }

}
