package com.hoonjin.study.java.thread.sync.bounded;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ProducerTask implements Runnable {

    private BoundedQueue boundedQueue;
    private String request;

    public ProducerTask(BoundedQueue boundedQueue, String request) {
        this.boundedQueue = boundedQueue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[produce] start" + request + " -> " + boundedQueue);
        boundedQueue.put(request);
        log("[produce] end" + request + " -> " + boundedQueue);
    }
}
