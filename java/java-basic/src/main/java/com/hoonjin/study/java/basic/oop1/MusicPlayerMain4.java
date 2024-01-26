package com.hoonjin.study.java.basic.oop1;

public class MusicPlayerMain4 {

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        musicPlayer.on();
        musicPlayer.upVolume();
        musicPlayer.upVolume();
        musicPlayer.downVolume();
        musicPlayer.showStatus();
        musicPlayer.off();
    }
}
