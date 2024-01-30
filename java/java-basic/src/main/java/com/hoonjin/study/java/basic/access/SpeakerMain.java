package com.hoonjin.study.java.basic.access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);

        speaker.showStatus();

        speaker.volumeUp();
        speaker.showStatus();

        speaker.volumeUp();
        speaker.showStatus();

        //speaker.volume = 200;
        // private 에 직접 접근 불가


        speaker.volumeDown();
        speaker.showStatus();

        speaker.showStatus();
    }
}
