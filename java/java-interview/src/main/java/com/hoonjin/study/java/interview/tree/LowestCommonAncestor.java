package com.hoonjin.study.java.interview.tree;

import java.util.ArrayList;
import java.util.List;

//문제. 가장 가까운 공통 조상 찾기
//주어진 이진 트리에서 두 노드의 가장 가까운 공통 조상(Lowest Common Ancestor)을 찾는 코드를 작성하라.
//
//LCA(2, 3) = 1
//LCA(4, 5) = 2
//LCA(3, 4) = 1
//LCA(3, 6) = 3
//LCA(4, 6) = 1
public class LowestCommonAncestor {

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        Node result = lowestCommonAncestor.solution2(root, 3, 6);
        System.out.println("result = " + result);
        Node result1 = lowestCommonAncestor.solution2(root, 3, 8);
        System.out.println("result1 = " + result1);
    }

    private Node solution2(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.value == n1 || node.value == n2) {
            return node;
        }

        Node leftLCA = solution(node.left, n1, n2);
        Node rightLCA = solution(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    private Node solution(Node root, int n1, int n2) {
        List<Node> n1Path = new ArrayList<>();
        List<Node> n2Path = new ArrayList<>();
        if (!findPath(root, n1, n1Path) || !findPath(root, n2, n2Path)) {
            return null;
        }

        int index = 0;
        for (; index < n1Path.size() && index < n2Path.size(); index++) {
            if (!n1Path.get(index).equals(n2Path.get(index))) {
                break;
            }
        }

        return n1Path.get(index - 1);
    }

    private boolean findPath(Node node, int n, List<Node> path) {
        if (node == null) {
            return false;
        }

        path.add(node);

        if (node.value == n) {
            return true;
        }

        if (findPath(node.left, n, path)) {
            return true;
        }

        if (findPath(node.right, n, path)) {
            return true;
        }

        path.remove(node);
        return false;
    }
}
