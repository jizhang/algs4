package com.shzhangji.algs4.basic;

public class LinkedList<T> implements Stack<T> {

    class Node {
        T value;
        Node next;
        Node(T value) {
            this.value = value;
        }
    }

    private Node head;

    @Override
    public void push(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    @Override
    public T pop() {

        if (head == null) {
            return null;
        }

        Node node = head;
        head = head.next;
        return node.value;
    }

}
