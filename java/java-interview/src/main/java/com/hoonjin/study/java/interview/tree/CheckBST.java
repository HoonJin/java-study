package com.hoonjin.study.java.interview.tree;

//문제. BST 인지 확인하라.
public class CheckBST {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                "value=" + value +
                '}';
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        CheckBST checkBST = new CheckBST();
        boolean result = checkBST.solution2(root);
        System.out.println("result = " + result);
    }

    private Node prev;

    //솔루션 3. 중위 탐색을 사용하는 방법
    private boolean solution2(Node node) {
        if (node != null) {
            if (!solution2(node.left)) {
                return false;
            }

            if (prev != null && node.value <= prev.value) {
                return false;
            }

            prev = node;
            return solution(node.right);
        }
        return true;
    }

    //솔루션 1. 왼쪽 노드의 값이 작고, 오른쪽 노드의 값이 큰지 확인한다.
    private boolean solution(Node node) {
        return isValid(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        if (node.value < minValue || node.value > maxValue) {
            return false;
        }

        return isValid(node.left, minValue, node.value - 1) &&
            isValid(node.right, node.value + 1, maxValue);
    }
}
