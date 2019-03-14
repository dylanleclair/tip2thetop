package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.Animation.Status;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Builds the scenes / related objects necessary for each day of the game. 
 */
public class DayBuilder {
	
	private static StackPane today = new StackPane();
	// one layer for background (index 0)
	// one layer for character (index 1)
	// one layer for desk/foreground (index 2)
	// one layer for borderpane w buttons n shit to make it interactive?
	
	private static boolean dialogueActive;
	//private static int satisfaction;
	//private static int gulagPoints;
	private static ObservableList<String> guests = FXCollections.observableArrayList();
	private static ObservableList<String> email = FXCollections.observableArrayList();
	private static BorderPane amigo = new BorderPane();
	//private static ImageView currentCharacter = null;
	
	
	//Pat created for building main screen
		public static StackPane buildMainScreen (Stage window) {
			//StackPane mainPane = new StackPane();
			
			loadDay(today); // loads the images for the opening sequence and display them on top of each other
			
			return today;
		}
	
	
	//Pat created for startday scene 
		
		// save this for the transition between days! (not currently implemented, since I just added onto openingScene)
		public static StackPane startDay(Stage window) {
			StackPane startDay = new StackPane();
			Image image;
			try {
				image = new Image(new FileInputStream("./resources/dayimg/sunup.jpg"));
			    ImageView imageView = new ImageView(image); 
			    startDay.getChildren().add(imageView);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			startDay.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					Scene main = new Scene(DayBuilder.buildMainScreen(window), 1280, 720);
					window.setScene(main);
				}
			});
			return startDay;
		}
		
		//Pat created for end day scene 
		public static StackPane endDay(Stage window) {
			StackPane endDay = new StackPane();
			Image image;
			try {
				image = new Image(new FileInputStream("./resources/dayimg/thesunset.jpg"));
			    ImageView imageView = new ImageView(image); 
			    endDay.getChildren().add(imageView);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			endDay.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					Scene dayIntro = new Scene(DayBuilder.startDay(window), 1280, 720);
	    			window.setScene(dayIntro);
				}
			});
			return endDay;
		}
		//Pat created this to load images for day
		
		
		public static void loadDay (StackPane pane) {
			Image image, image2, image3, image4, image5;
			try {
				image = new Image(new FileInputStream("./resources/dayimg/background.jpg"));
			    ImageView imageView = new ImageView(image); 
			    pane.getChildren().add(imageView);
			    
			    
			    image2 = new Image(new FileInputStream("./resources/dayimg/MrAnything.png"));
			    ImageView imageView2 = new ImageView(image2);
			    imageView2.setManaged(false);
			    imageView2.setLayoutX(1280);
			    imageView2.setLayoutY(150);
			    pane.getChildren().add(imageView2);
			    
			    
			    
			    image3 = new Image(new FileInputStream("./resources/dayimg/desk_b.png"));
			    ImageView imageView3 = new ImageView(image3); 
			    pane.getChildren().add(imageView3);
			    
			    image4 = new Image(new FileInputStream("./resources/dayimg/keys.png"));
			    ImageView imageView4 = new ImageView(image4); 
			    pane.getChildren().add(imageView4);
			    
			    image5 = new Image(new FileInputStream("./resources/dayimg/dialogbox.png"));
			    ImageView imageView5 = new ImageView(image5); 
			    pane.getChildren().add(imageView5);
			    
			    
			    BorderPane handler = new BorderPane();
			    Button accessAmigo = new Button();
			    
			    try {
				    Image amigobtn = new Image(new FileInputStream("./resources/gameimg/amigobtn.png"));
				    Image amigohovered = new Image(new FileInputStream("./resources/gameimg/amigobtnhov.png"));
				    ImageView amigobtng = new ImageView(amigobtn);
				    ImageView amigohoveredg = new ImageView(amigohovered);
				    accessAmigo.setGraphic(amigobtng);
				    accessAmigo.setId("amigo");
				    accessAmigo.graphicProperty().bind(
				    		Bindings.when(accessAmigo.hoverProperty())
		                    .then(amigohoveredg)
		                    .otherwise(amigobtng));

			    } catch (Exception e) { e.printStackTrace();}

			    handler.setBottom(accessAmigo);
			    
			    pane.getChildren().add(handler);
			    runDay(1, handler);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			
		}
	
	/**
	 * Main logical programming system for each day - move to whatever class handles each day
	 * This is literally the SUBSTANCE of our program, so don't mess with it.
	 */
	public static void runDay (int day, BorderPane handler) { // called every day --- move to Game
		
		// instantiate characters
		
		switch (day) {
		
		case 1 : // day 1
			
			NPC.intializeCharacters(day);
			ArrayList<NPC> dailyCharacters = NPC.getDailyCharacters();
			
			/* save this for day 2
			 * for (NPC i : dailyCharacters) { // this is WRONG
			 * 	guests.add(i.toString());
			}
			 */

			// actual logic for each character 
			
			Collections.shuffle(dailyCharacters); // shuffle (to randomize order)
			
			dailyCharacters.add(new NPC("Tiff"));
			
			for (int i = dailyCharacters.size() -1; i > 0; i--) {
				NPC character = dailyCharacters.get(i);
				try {
					Image image = new Image(new FileInputStream("./resources/characters/" + character.getName() + ".png"));
				    ImageView characterView = new ImageView(image); 
				    // today.getChildren.set(1, character.getAppearance());
				    today.getChildren().set(1, characterView); 
				    characterView.setManaged(false);
				    characterView.setLayoutX(1280);
				    characterView.setLayoutY(-20);
				    // if statement to see whether character needs to be animated out before being animated in (use character)
					
				    animateCharacterIn(characterView);
				    //SequentialTransition seqT = new SequentialTransition(animateCharacterIn(characterView).setOnFinished(e -> System.out.println("Holy fuck")));
				    //seqT.play();
				   
				    // some kind of event listener to control the flow of options
				    
					dialogueActive = true; // we might need this variable to keep listeners muted
					
					playDialog(handler, NPC.getDialogue(character.getName(), day));
					
					//System.out.println("tracker lol");
				
					//NPC.getDialogue(character.getName(),day);	
					// do character dialogue -- listeners / etc will be muted so the player can't screw around while dealing w customers
					dialogueActive = false;
				    
					break;
					
				    //animateCharacterOut(characterView);
				} catch (Exception e) {e.printStackTrace();}
				

				
				// leave some time for the character to use computer / etc (maybe depends on if they'll actually need to use it)
				
				// animate character out
				
				}
			
		// all the way to day 7 baby
		}
		
	}
	
	
	public static void playDialog(BorderPane pane, ArrayList<String> dialog) {

		// get the array list for the given npc and prompt
		ArrayList<String> active = Reader.getDialogue("Tiff", "iceCream_yes");
		
		active.add("one");
		active.add("two");
		active.add("three");
		String a, b, c;
		a = active.get(0);
		b = active.get(1);
		c = active.get(2);
		
		VBox container = new VBox(5);
		
		Text slot1 = new Text(a);
		Text slot2 = new Text(b);
		Text slot3 = new Text(c);
		
		slot1.setId("dialog-text");
		slot2.setId("dialog-text");
		slot3.setId("dialog-text");
		
		slot1.setFill(Color.GHOSTWHITE);
		slot2.setFill(Color.GHOSTWHITE);
		slot3.setFill(Color.GHOSTWHITE);
		
	    container.setManaged(false);
	    container.setLayoutX(45);
	    container.setLayoutY(70);
		container.getChildren().addAll(slot1, slot2, slot3);
		
		pane.getChildren().add(container);
		
		int length = dialog.size();
		int count = 0;
		pane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				// advance
				if (count < length) {
					// fade all 3 out
					// add next 3 to list
					// fade in 1 by 1
					
					active.add(dialog.get(count));
					active.remove(0);
					
					slot1.setText(active.get(0));
					slot2.setText(active.get(1));
					slot3.setText(active.get(2));
					
					System.out.print(length);
				System.out.println("Success!");
				System.out.println(dialog.toString());
				}
			}
		});
		
	}
	
	
	public static void animateTextIn() {
		
	}
	
	public static void animateTextOut() {
		
	}
	
	public static void buildAmigoScreen () {
		
		// set the background image
		try {
			Image background = new Image(new FileInputStream("./resources/menuimg/amigo.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    null);
			Background emailbkg = new Background(bgImg);
			amigo.setBackground(emailbkg);
		} catch (Exception e) {}
		
		Button viewGuests = new Button();
		Button viewEmails = new Button();
		Button exit = new Button();
		
		VBox amigoButtons = new VBox(20);
		amigoButtons.getChildren().addAll(viewGuests, viewEmails, exit);
		
		
		amigo.getChildren().add(amigoButtons);
		
		//viewGuests.setOnAction(e -> amigo.setCenter(checkins));
		//viewEmails.setOnAction(e -> amigo.setCenter(emails));
	
	}
	
	public static void buildEmailScreen() { // focus on this AFTER the email screen is built
		try {
			amigo.getChildren().clear();
			Image background = new Image(new FileInputStream("./resources/menuimg/email.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    null);
			Background emailbkg = new Background(bgImg);
			amigo.setBackground(emailbkg);
		} catch (Exception e) {}
		
		ListView<String> emails = new ListView<>(email);
		if (email.isEmpty()) email.add("You have no new emails!");
		
		amigo.getChildren().add(emails);
		
	}
	
	public static void buildCheckInScreen(ArrayList<NPC> dailyCharacters) {
		try {
			// clearing the borderpane and setting an appropriate background
			amigo.getChildren().clear();
			Image background = new Image(new FileInputStream("./resources/menuimg/checkin.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    null);
			Background checkinbkg = new Background(bgImg);
			amigo.setBackground(checkinbkg);
		} catch (Exception e) {}
		
		// building actual elements
		// initialize background 
		ListView<String> guestlist = new ListView<>(guests);
		TextField guestName = new TextField("Name");
		TextField roomNumber = new TextField("Room#");
		Button addGuest = new Button();
		Button checkOut = new Button();
		Button back = new Button();
		
		HBox addName = new HBox(20);
		addName.getChildren().addAll(guestName, roomNumber, addGuest);
		
		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(checkOut, back);
		
		
		
		amigo.setTop(addName);
		amigo.setCenter(guestlist);
		amigo.setRight(buttons);
		
		
		// event handling for buttons 
		
		addGuest.setOnAction(e -> {
			NPC temp = new NPC(guestName.getText(), Integer.parseInt(roomNumber.getText().replaceAll("[\\D]", "")));
			guests.add(temp.toString());
		});
		checkOut.setOnAction(e -> guests.remove(guestlist.getSelectionModel().getSelectedIndex()));
		back.setOnAction(e -> {
			amigo.getChildren().clear();
			buildAmigoScreen();
		});
	}
	
	/**
	 * This function will review activity in the Amigo 1000 for the day, and add points to satisfaction/gulag points as needed. 
	 */
	public static void verifyAmigo() {
		
	}
	
	// Animations
	
	public static TranslateTransition animateCharacterIn (Node character) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300)); 
		translate.setNode(character);
		translate.setByX(-630);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false); 
		translate.setOnFinished(e -> System.out.println("lol"));
		translate.play();
		return translate;
	}
	
	
	// reverses animate character in?
	public static TranslateTransition animateCharacterOut (Node character) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300)); 
		translate.setNode(character);
		translate.setByX(630);
		translate.setCycleCount(1); 
		translate.setAutoReverse(false); 
		translate.play(); 
		return translate;
		
		
	}
	
	
	// I heard you like light theme
	//fok outta here m8 
	
}
