package com.shzhangji.algs4.strings;

import java.lang.reflect.Method;

import edu.princeton.cs.algs4.StdOut;

public class Search {

    @SearchMethod
    public static int bruteForce(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; ++i) {
            int j;
            for (j = 0; j < M; ++j) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }

    @SearchMethod
    public static int kmp(String pat, String txt) {

        // Build DFA from pattern.
        int M = pat.length();
        int R = 256;
        int[][] dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; ++j) {
            for (int c = 0; c < R; ++c) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }

        // Simulate operation of DFA on txt.
        int i, j, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; ++i) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }

    public static void main(String[] args) {

        String pattern = "needle";
        String text = "inahaystackneedleina";

        for (Method method : Search.class.getMethods()) {
            if (method.isAnnotationPresent(SearchMethod.class)) {
                try {
                    int pos = (int) method.invoke(null, pattern, text);
                    StdOut.println(method.getName() + ": " + pos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}