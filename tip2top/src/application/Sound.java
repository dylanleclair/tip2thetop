package application;

import javafx.application.Application;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.File;


public abstract class Sound extends Application{

    // class for the main theme
    public static void mainTheme() {
        String main_theme = "./resources/sound_files/hotel_california.mp3";
        Media main = new Media(new File(main_theme).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(main);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
