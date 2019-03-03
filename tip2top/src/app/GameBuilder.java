package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameBuilder {
	
	private static int openingCount = 9;
	private static Charset charset = Charset.forName("US-ASCII");
	

    public void readFile (String pathOfFile) throws Exception {
    	
        BufferedReader reader = new BufferedReader(new FileReader(pathOfFile));
        try {
        	
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            System.out.print(line);
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
               
                Scanner skipLine = new Scanner(System.in);
                skipLine.nextLine();
                
                if (line != null) {
                	
                	for (int i = 0; i < line.length(); i++){
                	    char c = line.charAt(i);        
                	    System.out.print(c);
                	    Thread.sleep(20);
                	}
                }
            }
            // String everything = sb.toString();
        } finally {
            reader.close();
            
        }
        
    }
    
    public static void generateSave () {
    }
    
    public static void saveWriter() {
    	File defaultSave = new File("./resources/saves/default.txt");
    	String s = "this is a test";
    	
    	try {
    		BufferedWriter writer = Files.newBufferedWriter(defaultSave.toPath(), charset);
        	writer.write(s, 0, s.length());
        	
        	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(defaultSave.getPath())));
        	out.println("hello");
        	out.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
	
	/**
	 * Loads opening scene onto a StackPane, reading files named "screen(digit)" from path.
	 * @param pane - the stackpane to load images onto, from back to front.
	 */
	public static void loadOpening (StackPane pane) {
		for (int i = 10; i >= 1; i--) {
			Image image;
			try {
				image = new Image(new FileInputStream("./resources/introimg/screen" + i + ".jpg"));
			    ImageView imageView = new ImageView(image); 
			    pane.getChildren().add(imageView);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  
		}
	}
	
	/**
	 * Translates a node downward and off of the screen. 
	 * @param node a node, to be translated off the screen.
	 */
	public static void fadeImageDown (Node node) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(2500)); 
		translate.setNode(node);
		translate.setByY(720);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false); 
		translate.play(); 
	}
	
	/**
	 * Builds the menu into a BorderPane. 
	 * @param menu the BorderPane to add resources of menu into. 
	 * @param window the Stage which controls what scene is displayed (needed to change scenes)
	 * @param opening a Scene - the opening animation screen to build into "New Game" of the menu.
	 * @param loadsc a Scene - the load screen to build into the "Load Screen" button of the menu.
	 * @param helpsc a Scene - the help screen to build into the "Help" button of the menu. 
	 */
	public static void buildMenu (BorderPane menu, Stage window, Scene opening, Scene loadsc, Scene helpsc) {
		try {
		Text title = new Text("");
		title.setFont(new Font(120));
		VBox menuButtons = new VBox(20);
		Button newGame = new Button();
		Button loadGame = new Button();
		Button help = new Button();

		Image newimg = new Image(new FileInputStream("./resources/menuimg/newgame.jpg"));
		newGame.setGraphic(new ImageView(newimg));
		Image loadimg = new Image(new FileInputStream("./resources/menuimg/loadgame.jpg"));
		loadGame.setGraphic(new ImageView(loadimg));
		Image helpimg = new Image(new FileInputStream("./resources/menuimg/help.jpg"));
		help.setGraphic(new ImageView(helpimg));
		
		// Event handling for menu buttons
		
		newGame.setOnAction(e -> window.setScene(opening));
		loadGame.setOnAction(e -> window.setScene(loadsc));
		help.setOnAction(e -> window.setScene(helpsc));
		
		// Styling menu buttons (replace with images later)
		
		newGame.setStyle("-fx-base: #000000;");
		loadGame.setStyle("-fx-base: #000000;");
		help.setStyle("-fx-base: #000000;");
		
		menuButtons.getChildren().addAll(newGame, loadGame, help);

		// for Insets (padding), the order is (top, right, bottom, left)
		
		menu.setCenter(menuButtons);
		menu.setTop(title);
		BorderPane.setMargin(menuButtons, new Insets(40,0,0,150));
		BorderPane.setMargin(title, new Insets(70, 0, 0, 120));
		
		String image = Game.class.getResource("menu.jpg").toExternalForm();
		menu.setStyle("-fx-background-image: url('" + image + "'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void buildOpeningScreen (StackPane openingPane, Scene opening) {
		
		loadOpening(openingPane); // loads the images for the opening sequence and display them on top of each other
		
		opening.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	/*  calls fadeImageDown on an object in openingPane when the mouse is pressed.
		    	 *  (remember that these are the images added by loadOpening() )
		    	 *  This is performed once per image, for a total of 10 times. */
		    	fadeImageDown(openingPane.getChildren().get(openingCount));
				GameBuilder.saveWriter();
		    	if (openingCount > 0) openingCount--;
		    }
		});
		
	}
	
	/**
	 * Builds the screen for "Load Game" from the menu. 
	 * @param window - the Stage of the application window.
	 * @param menusc - the menu scene (needed for user to return to menu)
	 * @return the built "Load Game" screen (BorderPane), to be built into a scene (as a root node).
	 */
	public static BorderPane buildLoadScreen(Stage window, Scene menusc) {
		BorderPane loadScreen = new BorderPane();
		Button backToMenuL = new Button("Back to the menu");
		backToMenuL.setOnAction(e -> window.setScene(menusc));
		loadScreen.setBottom(backToMenuL);
		
		return loadScreen;
	}
	
	/**
	 * Builds and returns the help screen of the game (BorderPane). 
	 * @param window - the Stage of the application window.
	 * @param menusc - the menu scene (needed for user to return to menu)
	 * @return the built "Help" screen (BorderPane), to be built into a scene (as a root node)
	 */
	public static BorderPane buildHelpScreen(Stage window, Scene menusc) {
		BorderPane helpScreen = new BorderPane();
		Button backToMenuH = new Button("Back to the menu");
		backToMenuH.setOnAction(e -> window.setScene(menusc));
		helpScreen.setBottom(backToMenuH);
		return helpScreen;
	}
	
	
}
