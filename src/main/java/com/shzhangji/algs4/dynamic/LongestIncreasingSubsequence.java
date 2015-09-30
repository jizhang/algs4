package com.shzhangji.algs4.dynamic;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class LongestIncreasingSubsequence {

    public static int[] calcN2(int[] a) {

        int[] L = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            L[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (a[j] < a[i] && L[j] + 1 > L[i]) {
                    L[i] += 1;
                }
            }
        }

        int max = 0, maxIndex = -1;
        for (int i = 0; i < L.length; ++i) {
            if (L[i] > max) {
                max = L[i];
                maxIndex = i;
            }
        }

        int[] result = new int[max];
        for (int i = maxIndex; i >= 0; --i) {
            if (L[i] == max) {
                result[--max] = a[i];
            }
        }

        return result;
    }

    public static int[] calcNLogN(int[] a) {
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, -1, 2, -3, 4, -5, 6, -7};
        StdOut.println(Arrays.toString(calcN2(a)));
    }

}
