package com.hoonjin.study.java.basic.oop1;

public class MusicPlayerMain2 {

    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        // turn on player
        data.on = true;
        System.out.println("play music");

        // vol up
        data.volume++;
        System.out.println("current volume = " + data.volume);
        // vol up
        data.volume++;
        System.out.println("current volume = " + data.volume);
        // vol down
        data.volume--;
        System.out.println("current volume = " + data.volume);

        // check player status
        if (data.on) {
            System.out.println("playing current volume = " + data.volume);
        } else {
            System.out.println("player is off");
        }

        // turn off player
        data.on = false;
        System.out.println("stop player");
    }
}
