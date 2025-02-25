package com.hoonjin.study.java.interview.tree;

import java.util.Stack;

public class TreeIntro {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TreeIntro treeIntro = new TreeIntro();
        treeIntro.ldr2(root);
    }

    private void ldr1(Node node) {
        if (node != null) {
            ldr1(node.left);
            System.out.println(node.value);
            ldr1(node.right);
        }
    }

    private void ldr2(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            node = stack.pop();
            System.out.println(node.value);
            node = node.right;
        }
    }
}
