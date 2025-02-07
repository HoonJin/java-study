package com.hoonjin.study.java.interview.list;

import lombok.ToString;

@ToString
public class Node {

    int element;
    Node next;

    public Node(int element) {
        this.element = element;
    }
}
