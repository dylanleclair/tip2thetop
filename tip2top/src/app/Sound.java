package app;

import javafx.scene.media.*;

import java.io.File;

/**
 * Handles all of the sound files and playing them for the game.
 * @author Yvonne
 */

public abstract class Sound {

	/**
	 * Loads in and plays the media of the file inputed.
	 * @param fileName
	 */
    public static void play(String fileName) {
    	// loads in the file
        String soundFile = "./resources/sound_files/" + fileName;
        Media sound = new Media(new File(soundFile).toURI().toString());
        
        // creates media for the sound file
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
}
