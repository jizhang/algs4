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

    public static String suffixArray(String a, String b) {

        String text = a + "\001" + b;
        SuffixArray suffix = new SuffixArray(text);

        int N = text.length();
        int N1 = a.length();

        String result = "";
        for (int i = 1; i < N; ++i) {
            if (suffix.index(i) < N1 && suffix.index(i - 1) < N1) {
                continue;
            }
            if (suffix.index(i) > N1 && suffix.index(i - 1) > N1) {
                continue;
            }
            int length = suffix.lcp(i);
            if (length > result.length()) {
                result = text.substring(suffix.index(i), suffix.index(i) + length);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String a = StdIn.readLine();
        String b = StdIn.readLine();
        StdOut.println("bruteForce: " + bruteForce(a, b));
        StdOut.println("suffixArray: " + suffixArray(a, b));
    }

}
