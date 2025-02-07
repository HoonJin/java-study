package com.hoonjin.study.java.interview.list;

//단일 연결 리스트를 뒤집는 함수를 구현하라.
//
//예) 1 -> 2 -> 3   =>  3 -> 2 -> 1
public class ReverseLinkedList {

    private Node head;
    private Node tail;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(new Node(4));

        list.print();
        list.reverse2();
        System.out.println();

        list.print();
    }

    private void reverse1() {
        Node current = this.head;
        Node prev = null;

        while (current != null) {
            Node toBeNext = current.next;
            current.next = prev;
            prev = current;
            current = toBeNext;
        }

        this.tail = this.head;
        this.head = prev;
    }

    private void reverse2() {
        Node head = this.head;
        Node newHead = reverseRecursive(head);
        this.head = newHead;
        this.tail = head;
    }

    private Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        System.out.println("node = " + node);
        System.out.println("newHead = " + newHead);
        return newHead;
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
