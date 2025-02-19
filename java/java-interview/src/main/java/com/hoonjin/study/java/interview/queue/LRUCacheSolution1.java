package com.hoonjin.study.java.interview.queue;

import java.util.HashMap;

//최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU (least recently used) 캐시를 구현하라.
//입력값 number는 1부터 100까지의 숫자가 랜덤하게 입력된다. 그 중에 최대 n (1보다 크고 9보다 작은)개 만큼의 데이터만 캐시할 수 있다.
//n개를 넘는 새로운 값이 들어오면 그 중에서 가장 오래전에 접근한 데이터를 삭제하고 number를 캐시에 추가한다.
//
//다음 오퍼레이션을 구현하라.
//query(int number): number에 해당하는 입력값을 캐시에 추가한다.
//print() 현재 캐시하고 있는 데이터를 출력한다.
public class LRUCacheSolution1 {

    private int cacheSize;

    private HashMap<Integer, Node<Integer>> map;
    private Node<Integer> head, tail;

    public static void main(String[] args) {
        LRUCacheSolution1 lruCache = new LRUCacheSolution1(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);

        lruCache.print();
    }

    public LRUCacheSolution1(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    // 시간 복잡도 N
    private void query(int number) {
        if (map.containsKey(number)) {
            Node<Integer> node = map.get(number);
            remove(node);
            addToHead(node);
        } else {
            Node<Integer> nodeToAdd = new Node<>();
            nodeToAdd.value = number;
            if (map.size() == cacheSize) {
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd);
            map.put(number, nodeToAdd);
        }
    }

    private void addToHead(Node<Integer> node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    private void remove(Node<Integer> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void print() {
        Node current = head;
        while (current != null) {
            System.out.println("current.value = " + current.value);
            current = current.next;
        }
    }

    static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
    }
}
