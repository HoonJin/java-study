package com.hoonjin.study.java.interview.list;

import java.util.HashSet;

//주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.
//
//예) 1 -> 2 -> 3 -> 1   => true
//예) 1 -> 2 -> 3 -> 2   => true
//예) 1 -> 2 -> 3          => false
public class CheckCircleLinkedList {

    Node head;
    Node tail;

    public static void main(String[] args) {
        CheckCircleLinkedList list = new CheckCircleLinkedList();
        Node one = new Node(1);
        list.add(one);
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(one);
        list.add(new Node(5));
        list.add(one);

        boolean result = list.hasCircle2();
        System.out.println("result = " + result);
    }

    private boolean hasCircle2() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && slow != null) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
        }
        return false;
    }

    private boolean hasCircle1() {
        HashSet<Node> set = new HashSet<>();
        Node current = this.head;

        while (current != null) {
            if (set.contains(current)) {
                return true;
            } else {
                set.add(current);
            }
            current = current.next;
        }

        return false;
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
