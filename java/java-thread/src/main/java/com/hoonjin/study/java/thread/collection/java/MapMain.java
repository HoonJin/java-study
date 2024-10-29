package com.hoonjin.study.java.thread.collection.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapMain {

    public static void main(String[] args) {
        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(3, "data3");
        concurrentMap.put(2, "data2");
        concurrentMap.put(1, "data1");

        System.out.println("concurrentMap = " + concurrentMap);

        Map<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(3, "data3");
        skipListMap.put(2, "data2");
        skipListMap.put(1, "data1");

        System.out.println("skipListMap = " + skipListMap);
    }
}
