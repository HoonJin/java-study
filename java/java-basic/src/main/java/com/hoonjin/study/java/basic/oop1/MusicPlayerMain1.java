package com.hoonjin.study.java.basic.oop1;

public class MusicPlayerMain1 {

    public static void main(String[] args) {
        int volume = 0;
        boolean on = false;

        // turn on player
        on = true;
        System.out.println("play music");

        // vol up
        volume++;
        System.out.println("current volume = " + volume);
        // vol up
        volume++;
        System.out.println("current volume = " + volume);
        // vol down
        volume--;
        System.out.println("current volume = " + volume);

        // check player status
        if (on) {
            System.out.println("playing current volume = " + volume);
        } else {
            System.out.println("player is off");
        }

        // turn off player
        on = false;
        System.out.println("stop player");
    }
}
