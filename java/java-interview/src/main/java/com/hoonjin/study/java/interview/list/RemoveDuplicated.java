package com.hoonjin.study.java.interview.list;

import java.util.HashSet;

//정렬된 연결 리스트에서 중복 노드를 제거하는 함수를 구현하라.
//
//예) 1 -> 1 -> 1 -> 2 -> 3-> 3   =>   1 -> 2-> 3
public class RemoveDuplicated {

    Node head;
    Node tail;

    public static void main(String[] args) {
        RemoveDuplicated list = new RemoveDuplicated();
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(4));
        list.add(new Node(5));

        list.print();
        list.distinct4();

        System.out.println();
        list.print();
    }

    private void distinct4() {
        HashSet<Integer> set = new HashSet<>();

        Node current = this.head;
        Node prev = null;

        while (current != null) {
            int number = current.element;

            if (set.contains(number)) {
                prev.next = current.next;
            } else {
                set.add(number);
                prev = current;
            }
            current = current.next;
        }
    }

    private void distinct3() {
        recursive(this.head);
    }

    private Node recursive(Node node) {
        if (node == null) {
            return null;
        }

        if (node.next != null) {
            if (node.element == node.next.element) {
                node.next = node.next.next;
                recursive(node);
            } else {
                recursive(node.next);
            }
        }

        return node;
    }

    private void distinct2() {
        Node current = this.head;
        Node prev = this.head;

        while (current != null) {
            if (current.element != prev.element) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }

        if (prev != current) {
            prev.next = null;
        }
    }

    private void distinct1() {
        Node current = this.head;

        while (current != null) {
            Node temp = current.next;
            while (temp != null && current.element == temp.element) {
                temp = temp.next;
            }

            current.next = temp;
            current = temp;
        }
    }

    private void print() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.element);
            node = node.next;
        }
    }

    private void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }
}
