package com.shzhangji.algs4.dynamic;

public class LongestCommonSubsequence {

    /**
     * http://introcs.cs.princeton.edu/java/96optimization/LCS.java.html
     */
    public static String dynamic(String a, String b) {
        
        int M = a.length();
        int N = b.length();
        int[][] opt = new int[M + 1][N + 1];

        for (int i = M - 1; i >= 0; --i) {
            for (int j = N - 1; j >= 0; --j) {
                if (a.charAt(i) == b.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j],  opt[i][j + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < M && j < N; ) {
            if (a.charAt(i) == b.charAt(j)) {
                sb.append(a.charAt(i));
                ++i;
                ++j;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                ++i;
            } else {
                ++j;
            }
        }

        return sb.toString();
    }

}
