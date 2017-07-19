package main;

import javax.sound.sampled.*;
import java.io.*;

/**
 * Created by MaxPlays on 19.07.2017.
 */
public class AudioManager {

    public static void playHitSound(){
        new AudioManager().playSound("main/resources/hit.wav");
    }
    public static void playScoreSound(){
        new AudioManager().playSound("main/resources/score.wav");
    }

    private synchronized void playSound(String path){
        try {
            Clip c = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(path));
            c.open(ais);
            c.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
