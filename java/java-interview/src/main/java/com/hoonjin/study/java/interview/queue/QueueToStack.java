package com.hoonjin.study.java.interview.queue;

import java.util.LinkedList;
import java.util.Queue;

//큐 인스턴스를 사용해서 Stack 인터페이스를 구현하라.
//pop() 오퍼레이션은 가장 마지막으로 추가한 값을 꺼내야 한다.
//push() 오퍼레이션은 값을 추가한다.
//
//큐가 제공하는 offer(), poll(), isEmpty(), size()만 사용할 수 있다. Deque는 사용하지 못한다.
//(힌트) 큐 인스턴스를 여러개 사용할 수 있다.
public class QueueToStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);

        System.out.println("queueToStack.pop() = " + queueToStack.pop());
        System.out.println("queueToStack.pop() = " + queueToStack.pop());
        System.out.println("queueToStack.pop() = " + queueToStack.pop());
        System.out.println("queueToStack.pop() = " + queueToStack.pop());
    }


    private Integer pop() {
        if (q1.isEmpty()) {
            return null;
        }

        return q1.poll();
    }

    private void push(int number) {
        q2.offer(number);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
