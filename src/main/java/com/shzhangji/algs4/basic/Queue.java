package com.shzhangji.algs4.basic;

public interface Queue<T> extends Iterable<T> {
    void enqueue(T value);
    T dequeue();
}
