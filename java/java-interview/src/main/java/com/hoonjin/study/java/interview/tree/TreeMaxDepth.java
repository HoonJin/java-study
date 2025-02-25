package com.hoonjin.study.java.interview.tree;

//주어진 이진 트리의 높이를 구하라
public class TreeMaxDepth {

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

        TreeMaxDepth treeMaxDepth = new TreeMaxDepth();
        int result = treeMaxDepth.solution(root);
        System.out.println("result = " + result);
    }

    private int count = 0;

    // 시간복잡도 N 공간복잡도 logN
    private int solution(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = solution(node.left);
        int rightDepth = solution(node.right);

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}
