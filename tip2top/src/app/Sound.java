package app;

import javafx.scene.media.*;

import java.io.File;

/**
 * Handles all of the sound files and playing them for the game.
 * @author Yvonne
 */

public abstract class Sound {

	
	private static MediaPlayer mediaPlayer;
    // class for the main theme
    public static void mainTheme() {
        String main_theme = "./resources/sound_files/hotel_california.mp3";
        Media main = new Media(new File(main_theme).toURI().toString());
        mediaPlayer = new MediaPlayer(main);

    }
	/**
	 * Loads in and plays the media of the file inputed.
	 * @param fileName
	 */
    public static void play(String fileName) {
    	// loads in the file
        String soundFile = "./resources/sound_files/" + fileName;
        Media sound = new Media(new File(soundFile).toURI().toString());
        
        // creates media for the sound file
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
}
