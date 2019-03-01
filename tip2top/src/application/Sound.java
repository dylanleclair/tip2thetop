package application;

import javafx.scene.media.*;
import java.io.File;

import static javafx.application.Application.launch;

public class Sound {

    // class for the main theme
    public static void mainTheme(){
        String main_theme = "./src/application/resources/sound_files/hotel_california.mp3";
        Media main = new Media(new File(main_theme).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(main);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
