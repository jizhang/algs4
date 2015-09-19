package com.shzhangji.algs4.search;

public class BST<K extends Comparable<? super K>, V> {

    class Node {
        K key;
        V value;
        Node left, right;
        int N;
        Node(K key, V value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.N;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {

        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public K min() {
        return min(root);
    }

    private K min(Node x) {
        return x == null ? null : min(x.left);
    }

}