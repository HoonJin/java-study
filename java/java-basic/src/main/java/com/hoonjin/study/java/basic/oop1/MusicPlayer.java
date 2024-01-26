package com.hoonjin.study.java.basic.oop1;

public class MusicPlayer {

    int volume = 0;
    boolean on = false;

    void on() {
        on = true;
        System.out.println("play music");
    }

    void off() {
        on = false;
        System.out.println("stop player");
    }

    void upVolume() {
        volume++;
        System.out.println("volume = " + volume);
    }

    void downVolume() {
        volume--;
        System.out.println("volume = " + volume);
    }

    void showStatus() {
        if (on) {
            System.out.println("playing music. current volume = " + volume);
        } else {
            System.out.println("player is off");
        }
    }
}
