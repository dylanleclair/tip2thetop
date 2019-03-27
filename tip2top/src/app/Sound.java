package app;

import javafx.scene.media.*;

import java.io.File;

public abstract class Sound {

	
	private static MediaPlayer mediaPlayer;
    // class for the main theme
    public static void mainTheme() {
        String main_theme = "./resources/sound_files/hotel_california.mp3";
        Media main = new Media(new File(main_theme).toURI().toString());
        mediaPlayer = new MediaPlayer(main);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    // needs fixing?

}
