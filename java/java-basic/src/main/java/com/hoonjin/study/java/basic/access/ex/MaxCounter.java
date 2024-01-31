package com.hoonjin.study.java.basic.access.ex;

public class MaxCounter {

    private int count = 0;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increment() {
        if (isValid()) {
            count++;
        } else {
            System.out.println("can't increment");
        }
    }

    public int getCount() {
        return count;
    }

    private boolean isValid() {
        return count < max;
    }


}
