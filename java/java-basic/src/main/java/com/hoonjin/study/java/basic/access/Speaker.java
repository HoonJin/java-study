package com.hoonjin.study.java.basic.access;

public class Speaker {

    private int volume;

    public Speaker(int volume) {
        this.volume = volume;
    }

    public void volumeUp() {
        if (volume >= 100) {
            System.out.println("max volume!!");
        } else {
            volume += 10;
            System.out.println("UP! current volume = " + volume);
        }
    }

    public void volumeDown() {
        if (volume < 0) {
            System.out.println("min volume!!");
        } else {
            volume -= 10;
            System.out.println("DOWN! current volume = " + volume);
        }
    }

    public void showStatus() {
        System.out.println("current volume = " + volume);
    }
}
