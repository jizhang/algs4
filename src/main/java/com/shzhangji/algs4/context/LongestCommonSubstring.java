package com.shzhangji.algs4.context;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LongestCommonSubstring {

    public static String bruteForce(String a, String b) {

        String result = "";

        for (int i = 0; i < a.length(); ++i) {
            for (int j = 0; j < b.length(); ++j) {
                int k;
                for (k = 0; i + k < a.length() && j + k < b.length(); ++k) {
                    if (a.charAt(i + k) != b.charAt(j + k)) {
                        break;
                    }
                }
                if (k > result.length()) {
                    result = a.substring(i, i + k);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String a = StdIn.readLine();
        String b = StdIn.readLine();
        StdOut.println(bruteForce(a, b));
    }

}
