package app;

import javafx.scene.media.*;

import java.io.File;

public class Sound {

	
	private static MediaPlayer mediaPlayer;
    

	
	/**
	 * Plays the main theme of the game. 
	 */
    public static void mainTheme() {
        String main_theme = "./resources/sound_files/hotel_california.mp3";
        Media main = new Media(new File(main_theme).toURI().toString());
        mediaPlayer = new MediaPlayer(main);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    // needs fixing?

}
