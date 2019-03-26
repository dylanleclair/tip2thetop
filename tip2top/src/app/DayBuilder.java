package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

	private StackPane today = new StackPane();
	NPC manager = new NPC(null);

	public StackPane getToday() {
		return today;
	}
	// one layer for background (index 0)
	// one layer for character (index 1)
	// one layer for desk/foreground (index 2)
	// one layer for borderpane w buttons n stuff to make it interactive?

	private int day = 1;
	private ObservableList<String> guests = FXCollections.observableArrayList();
	private ObservableList<String> email = FXCollections.observableArrayList();
	private Button nextC = new Button(); 
	private int index = 0;

	
	private ImageView activeCharacter;
	
	// dialogue slots + trackers
	private ArrayList<String> active = new ArrayList<>();
	private boolean dialogueActive = false;
	private Text slot1 = new Text("");
	private Text slot2 = new Text("");
	private Text slot3 = new Text("");
	
	// daily characters
	private ArrayList<NPC> dailyCharacters;
	
	/**
	 * Loads the basic interface for the day and it's necessary elements.
	 * @param window
	 * @param amigoscreen
	 * @author patricia
	 */
	public void loadDay(Stage window, Scene amigoscreen, Scene transition) {
		Image image, image2, image3, image4, image5;
		try {
			image = new Image(new FileInputStream("./resources/dayimg/background.jpg"));
			ImageView imageView = new ImageView(image);
			today.getChildren().add(imageView);

			image2 = new Image(new FileInputStream("./resources/dayimg/MrAnything.png"));
			ImageView imageView2 = new ImageView(image2);
			imageView2.setManaged(false);
			imageView2.setLayoutX(1280);
			imageView2.setLayoutY(150);
			today.getChildren().add(imageView2);

			image3 = new Image(new FileInputStream("./resources/dayimg/desk_b.png"));
			ImageView imageView3 = new ImageView(image3);
			today.getChildren().add(imageView3);

			image4 = new Image(new FileInputStream("./resources/dayimg/keys.png"));
			ImageView imageView4 = new ImageView(image4);
			today.getChildren().add(imageView4);

			image5 = new Image(new FileInputStream("./resources/dayimg/dialogbox.png"));
			ImageView imageView5 = new ImageView(image5);
			imageView5.setManaged(false);
			imageView5.setLayoutY(-720);
			today.getChildren().add(imageView5);

			BorderPane handler = new BorderPane();
			Button accessAmigo = new Button();

			try {
				Image amigobtn = new Image(new FileInputStream("./resources/gameimg/amigobtn.png"));
				Image amigohovered = new Image(new FileInputStream("./resources/gameimg/amigobtnhov.png"));
				ImageView amigobtng = new ImageView(amigobtn);
				ImageView amigohoveredg = new ImageView(amigohovered);
				accessAmigo.setGraphic(amigobtng);
				accessAmigo.setId("amigo");
				accessAmigo.graphicProperty()
						.bind(Bindings.when(accessAmigo.hoverProperty()).then(amigohoveredg).otherwise(amigobtng));

			} catch (Exception e) {
				e.printStackTrace();
			}

			Image nextCustomer = new Image(new FileInputStream("./resources/gameimg/next.png"));
			ImageView next = new ImageView(nextCustomer);
			next.setStyle(null);

			nextC.setText("Next customer...");
			nextC.setManaged(false);
			nextC.setLayoutX(1300);
			nextC.setLayoutY(650);
			nextC.setGraphic(next);
			
			dailyCharacters = manager.initializeCharacters(day);
			
			// change styling n such later

			accessAmigo.setOnAction(e -> {
				window.setScene(amigoscreen);
			});
			
			handler.setBottom(accessAmigo);
			handler.setRight(nextC);

			handler.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			
				
				// it appears that the error occurs in the inheritance here somehow?

				int top = 0;
				int middle = 1;
				int bottom = 2;
				int clickCount = 1;

				/**
				 * The class that handles the advance of the dialog as the user clicks the mouse.
				 */
				@Override
				public void handle(MouseEvent mouseEvent) {
					// advance
					if (dialogueActive) {
						if (clickCount <= active.size() - 2) {
							clickCount++;

							if (top < active.size())
								slot1.setText(active.get(top));
							if (middle <= active.size() - 1)
								slot2.setText(active.get(middle));
							if (bottom <= active.size() - 2)
								slot3.setText(active.get(bottom));
							top++;
							middle++;
							bottom++;
						}

						// the conditional that evaluates if a character's dialog is complete. (needs tuning)
						if (active.get(top).equals(" ") && clickCount > 3) {
							active.clear();
							animateButtonIn(nextC);
							slot1.setText(" ");
							slot2.setText(" ");
							slot3.setText(" ");
							dialogueActive = false;
							clickCount = 1;
							top = 0;
							middle = 1;
							bottom = 2;
							animateCharacterOut(activeCharacter); // change this to next character button.
						}

					}
				}
			});

			today.getChildren().add(handler); // 6th item in pane
			// pane.getChildren().add(amigo); // need to change how amigo is implemented to
			// another layer on stackpane? or even change scene.
			runDay(handler, window, transition);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Handles the "day" of events as a whole. Controls which characters are on the screen. 
	 * @param handler a BorderPane which stores buttons/other onscreen elements as needed.  (might be causing bugs?)
	 */
	public void runDay(BorderPane handler, Stage window, Scene transition) {
		
			if (day == 1) {
				Collections.shuffle(dailyCharacters);
				dailyCharacters.add(new NPC("Tiff")); // move this to initialize characters
				dailyCharacters.add(0, new NPC("Aleksandra"));
			}

			animateButtonIn(nextC);

			nextC.setOnAction(e -> {

				// animate nextC out if index > 0

				if (index == 0) {
					animateButtonOut(nextC);
					animateDialogueBoxIn(today.getChildren().get(4)); // 4 is the index of dialogue box in stackpane
																		// today
				}

				if (index > 0) {
					animateButtonOut(nextC);
				}

				if (index < dailyCharacters.size()) {
					
					NPC character = dailyCharacters.get(index);

					try {
						Image image = new Image(new FileInputStream("./resources/characters/" + character.getName() + ".png"));
						ImageView characterView = new ImageView(image);

						activeCharacter = characterView;

						today.getChildren().set(1, characterView);
						characterView.setManaged(false);
						characterView.setLayoutX(1280);
						characterView.setLayoutY(-20);

						active.clear();
						for (int i = 0; i < 3; i++) 
							active.add(" ");

						animateCharacterIn(characterView);


						// dialogueActive = true;
						ArrayList<String> dialogue = manager.getDialogue(character.getName(), day);
						playDialog(handler, dialogue);

						

						// animateCharacterOut(characterView);
					} catch (Exception c) {
						c.printStackTrace();
					}
					
				}
				
				// stuff for each character
				

				if (index == dailyCharacters.size()) {
					System.out.println("LOL");
					animateDialogueBoxOut(today.getChildren().get(4), window, transition);
					//animate dialogue box out
				}
				
				index++;
			});

		
	}

	/**
	 * Handles the dialog functionality of the game. Responds to mouse click
	 * @TODO - remove/fix the default / enter key functionality (it's broke)?
	 * @param pane a BorderPane, in which the dialog labels are displayed
	 * @param dialog an ArrayList<String> which stores dialog to be played.
	 */
	public void playDialog(BorderPane pane, ArrayList<String> dialog) {
		System.out.println(dialog.toString());

		active.addAll(dialog); // we need to separate this so we can ensure it is done correctly?
		for (int i = 0; i < 3; i++)
			active.add(" ");

		VBox container = new VBox(5);

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

	}

	public static void animateTextIn() {

	}

	public static void animateTextOut() {

	}

	/**
	 * Builds the main screen of the in-game PC. 
	 * @param amigo the StackPane of elements to be displayed
	 * @param window the Stage / main window of the game
	 * @param mainscene the Scene which is returned to when the Amigo is exited. 
	 */
	public void buildAmigoScreen(StackPane amigo, Stage window, Scene mainscene) {
		
		// set the background image
		
		

		Image image;
		try {
			image = new Image(new FileInputStream("./resources/gameimg/amigo/mainamigo.png"));
			ImageView imageView = new ImageView(image);
			amigo.getChildren().add(imageView); // 1
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Adding buttons
		
		Button viewGuests = new Button();
		Button viewEmails = new Button();
		Button exit = new Button();
		
		// Styling the buttons
		
		try {
		Image guestl = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/guestsbtn.png"));
		viewGuests.setGraphic(new ImageView(guestl));
		Image emailsimg = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/emailbtn.png"));
		viewEmails.setGraphic(new ImageView(emailsimg));
		Image exitimg = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/exit.jpg"));
		exit.setGraphic(new ImageView(exitimg));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		
		VBox amigoButtons = new VBox(15);
		StackPane.setMargin(amigoButtons, new Insets(300, 0, 100, 520));
		amigoButtons.getChildren().addAll(viewGuests, viewEmails, exit);
		
		for (Node item : amigoButtons.getChildren()) 
			item.setStyle("-fx-base: #000000;");
		

		amigo.getChildren().add(amigoButtons); // 2

		System.out.println(amigo.getChildren().size());
		
		viewGuests.setOnAction(e -> {
			buildCheckInScreen(dailyCharacters, amigo);
		});
		exit.setOnAction(e -> window.setScene(mainscene));

	}

	/**
	 * 
	 * @param amigo
	 */
	public void buildEmailScreen(StackPane amigo) { // focus on this AFTER the email screen is built

		Image image;
		try {
			image = new Image(new FileInputStream("./resources/gameimg/amigowindow.jpg"));
			ImageView imageView = new ImageView(image);
			amigo.getChildren().add(imageView);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		
		ListView<String> emails = new ListView<>(email);
		if (email.isEmpty())
			email.add("You have no new emails!");

		amigo.getChildren().add(emails);

	}

	public void buildCheckInScreen(ArrayList<NPC> dailyCharacters, StackPane amigo) {
		
		Image image;
		try {
			image = new Image(new FileInputStream("./resources/gameimg/amigo/guestamigo.png"));
			ImageView imageView = new ImageView(image);
			amigo.getChildren().add(imageView);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		BorderPane handler = new BorderPane();
		
		ListView<String> guestlist = new ListView<>(guests);
		TextField guestName = new TextField("Name");
		TextField roomNumber = new TextField("Room#");
		Button addGuest = new Button();
		Button checkOut = new Button();
		Button back = new Button();

		try {
		Image addg = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/checkin.png"));
		addGuest.setGraphic(new ImageView(addg));
		Image checko = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/checkout.png"));
		checkOut.setGraphic(new ImageView(checko));
		Image backimg = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/back.png"));
		back.setGraphic(new ImageView(backimg));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		HBox addName = new HBox(20);
		addName.getChildren().addAll(guestName, roomNumber); 

		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(addGuest, checkOut, back);
		
		for (Node item : buttons.getChildren()) 
			item.setStyle("-fx-base: #000000;");
		
		handler.setCenter(guestlist);
		handler.setTop(addName);
		handler.setRight(buttons);
		// event handling for buttons
		
		guests.add("Sample1");
		guests.add("Sample 2");

		BorderPane.setMargin(addName, new Insets(240, 0,0,230));
		BorderPane.setMargin(buttons, new Insets(40, 240, 0, 30));
		BorderPane.setMargin(guestlist, new Insets(40, 20, 140 ,220));
		
		amigo.getChildren().add(handler);
		
		System.out.println(amigo.getChildren().size());
		
		addGuest.setOnAction(e -> {
			NPC temp = new NPC(guestName.getText(), Integer.parseInt(roomNumber.getText().replaceAll("[\\D]", "")));
			guests.add(temp.toString());
		});
		checkOut.setOnAction(e -> guests.remove(guestlist.getSelectionModel().getSelectedIndex()));
		back.setOnAction(e -> {
			amigo.getChildren().remove(amigo.getChildren().size() - 1);
			amigo.getChildren().remove(amigo.getChildren().size() - 1);
		});
	}

	/**
	 * This function will review activity in the Amigo 1000 for the day, and add
	 * points to satisfaction/gulag points as needed.
	 */
	public static void verifyAmigo() {

	}

	// Animations

	public TranslateTransition animateCharacterIn(Node character) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(character);
		translate.setByX(-590);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.setOnFinished(e -> dialogueActive = true);

		translate.play();
		return translate;
	}

	// reverses animate character in?
	public TranslateTransition animateCharacterOut(Node character) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(character);
		translate.setByX(590);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.play();
		// translate.setOnFinished(e -> );
		return translate;

	}

	public TranslateTransition animateButtonIn(Node button) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(button);
		translate.setByX(-350);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.play();
		return translate;

	}

	public TranslateTransition animateButtonOut(Node button) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(button);
		translate.setByX(370);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.play();
		return translate;

	}

	public TranslateTransition animateDialogueBoxIn(Node image) {

		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(image);
		translate.setByY(720);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.play();
		// translate.setOnFinished(e -> dialogueActive = true);
		return translate;

	}

	// I heard you like light theme

	public TranslateTransition animateDialogueBoxOut(Node image, Stage window, Scene transition) {

		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(image);
		translate.setByY(-720);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.setOnFinished(e -> window.setScene(transition));
		translate.play();
		// translate.setOnFinished(e -> dialogueActive = true);
		return translate;

	}

	
}
