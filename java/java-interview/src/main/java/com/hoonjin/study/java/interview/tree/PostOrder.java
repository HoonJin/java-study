package com.hoonjin.study.java.interview.tree;

//주어진 이진 트리에서 후위탐색(왼쪽, 오른쪽, 루트 순서)시 n번째에 해당하는 값을 출력하라.
public class PostOrder {

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

        PostOrder postOrder = new PostOrder();
        postOrder.print(root, 2);
    }

    private int count = 0;

    // 시간복잡도 N 공간복잡도 logN
    private void print(Node node, int index) {
        if (node != null) {
            print(node.left, index);
            print(node.right, index);

            count++;

            if (count == index) {
                System.out.println(node.value);
            }
        }
    }
}
