package com.hoonjin.study.java.interview.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 단일 연결 리스트의 끝에서 n번째에 위치한 노드를 찾는 함수를 구현하라.
//
//예) findFromLast(1 -> 4 -> 2 -> 3, 2), 끝에서 2번째에 위치한 2를 리턴한다.
public class FindFromLastIndex {

    private Node head;
    private Node tail;

    public static void main(String[] args) {
        FindFromLastIndex list = new FindFromLastIndex();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));

        list.print();
        Node node = list.findFromLast3(2);
        System.out.println("node = " + node.element);
    }

    private Node findFromLast3(int i) {
        Node left = this.head, right = this.head;
        int count = 0;
        while (right.next != null) {
            if (count == i - 1) {
                left = left.next;
                right = right.next;
            } else if (count++ < i) {
                right = right.next;
            }
        }
        return left;
    }

    private Node findFromLast2(int i) {
        Node current = this.head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int findIndex = length - i;
        Node target = this.head;
        while (findIndex > 0) {
            findIndex--;
            target = target.next;
        }
        return target;
    }

    private Node findFromLast(int i) {
        Map<Integer, Node> map = new HashMap<>();
        int index = 0;
        Node current = this.head;

        while (current != null) {
            map.put(index++, current);
            current = current.next;
        }

        int findIndex = map.size() - i;
        return map.get(findIndex);
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
