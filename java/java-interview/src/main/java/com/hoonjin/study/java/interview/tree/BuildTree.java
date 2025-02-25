package com.hoonjin.study.java.interview.tree;

import java.util.HashMap;
import java.util.Map;

//문제. 중위탐색과 전위탐색 결과를 가지고 이진 트리를 만드는 코드를 작성하라.
//중위탐색(LDR): 4, 2, 5, 1, 3
//전위탐색(DLR): 1, 2, 4, 5, 3
public class BuildTree {

    int preIndex = 0;

    Map<Integer, Integer> indexMap = new HashMap<>();

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 3};
        int[] preOrder = {1, 2, 4, 5, 3};
        BuildTree buildTree = new BuildTree();
        Node root = buildTree.build(inOrder, preOrder);

        buildTree.printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.value);
            printInOrder(node.right);
        }
    }

    // 시간 복잡도 N 공간 복잡도 N
    private Node build(int[] inOrder, int[] preOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return buildRecurse(inOrder, preOrder, 0, inOrder.length -1);
    }

    private Node buildRecurse(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        Node node = new Node(preOrder[preIndex++]);

        if (startIndex == endIndex) { // leaf
            return node;
        }

        int inIndex = indexMap.get(node.value);
//        int inIndex = searchIndex(inOrder, node.value);
        node.left = buildRecurse(inOrder, preOrder, startIndex, inIndex - 1);
        node.right = buildRecurse(inOrder, preOrder, inIndex + 1, endIndex);

        return node;
    }

    private int searchIndex(int[] inOrder, int value) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == value) {
                return i;
            }
        }
        return 0;
    }

}
