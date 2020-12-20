package ua.stu;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Sound {

    private InputStream input;
    private AudioStream audio;

    public Sound() {
    }

    public void play() {
        new Thread( () -> {
            try {
                AudioPlayer.player.start(new FileInputStream("src/main/resources/3164.wav"));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }).run();
    }
}
