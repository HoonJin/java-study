package com.hoonjin.study.java.interview.queue;

import java.util.ArrayDeque;
import java.util.Queue;

//바이너리 트리의 계층별 합계 중에 최대 값을 구하라.
//
//   9  -> 9
//  2 3  -> 5
//1 5 4  -> 10
//==========> 10
public class BinaryTreeLayerSum {

    static class Node {
        int value;
        Node left, right;

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

        BinaryTreeLayerSum binaryTreeLayerSum = new BinaryTreeLayerSum();
        int result = binaryTreeLayerSum.maxSum(root);
        System.out.println("result = " + result);
    }

    // BFS (너비 우선 탐색)
    // 시간복잡도 N, 공간복잡도 B (N/2)
    private int maxSum(Node root) {
        if (root == null) {
            return 0;
        }

        int result = root.value;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;
            while (count-- > 0) {
                Node node = queue.poll();
                sum += node.value;
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result = Math.max(result, sum);
        }

        return result;
    }
}
