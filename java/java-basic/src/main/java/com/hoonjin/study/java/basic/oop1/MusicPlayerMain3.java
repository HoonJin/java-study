package com.hoonjin.study.java.basic.oop1;

public class MusicPlayerMain3 {

    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        on(data);
        upVolume(data);
        upVolume(data);
        downVolume(data);
        showStatus(data);
        off(data);
    }

    static void on(MusicPlayerData data) {
        data.on = true;
        System.out.println("play music");
    }

    static void off(MusicPlayerData data) {
        data.on = false;
        System.out.println("stop player");
    }

    static void upVolume(MusicPlayerData data) {
        data.volume++;
        System.out.println("current volume = " + data.volume);
    }

    static void downVolume(MusicPlayerData data) {
        data.volume--;
        System.out.println("current volume = " + data.volume);
    }

    static void showStatus(MusicPlayerData data) {
        if (data.on) {
            System.out.println("playing music. current volume = " + data.volume);
        } else {
            System.out.println("player is off");
        }
    }
}
