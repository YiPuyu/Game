package com.sxt;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

    public class MusicUtil {
        public static void playSound(String filePath) {
            try {
                File soundFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

