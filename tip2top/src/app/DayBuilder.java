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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
import javafx.util.Duration;

/**
 * Builds the scenes / related objects necessary for each day of the game.
 */
public class DayBuilder {

	private StackPane today = new StackPane();
	NPC manager = new NPC(null);
	
	public int keys[] = {1,1,1,1,1,1,1,1,1,1,1,1};

	public StackPane getToday() {
		return today;
	}
	// one layer for background (index 0)
	// one layer for character (index 1)
	// one layer for desk/foreground (index 2)
	// one layer for borderpane w buttons n shit to make it interactive?

	private int day = 1;
	// private static int satisfaction;
	// private static int gulagPoints;
	private ObservableList<String> guests = FXCollections.observableArrayList();
	private ObservableList<String> email = FXCollections.observableArrayList();
	private BorderPane amigo = new BorderPane();
	private Button nextC = new Button();
	private int index = 0;
	private boolean dialogueActive = false;
	private ImageView activeCharacter;
	private ArrayList<String> active = new ArrayList<>();
	private Text slot1 = new Text("");
	private Text slot2 = new Text("");
	private Text slot3 = new Text("");

	// Pat created this to load images for day
	
	public void loadKeys() {
		Image img1, img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12;
		Button k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12;
		
		try {
			img1 = new Image(new FileInputStream("./resources/keys/key1.png"));
			ImageView key1 = new ImageView(img1);
			
			img2 = new Image(new FileInputStream("./resources/keys/key2.png"));
			ImageView key2 = new ImageView(img2);
			
			img3 = new Image(new FileInputStream("./resources/keys/key3.png"));
			ImageView key3 = new ImageView(img3);
			
			img4 = new Image(new FileInputStream("./resources/keys/key4.png"));
			ImageView key4 = new ImageView(img4);
			
			img5 = new Image(new FileInputStream("./resources/keys/key5.png"));
			ImageView key5 = new ImageView(img5);
			
			img6 = new Image(new FileInputStream("./resources/keys/key6.png"));
			ImageView key6 = new ImageView(img6);
			
			img7 = new Image(new FileInputStream("./resources/keys/key7.png"));
			ImageView key7 = new ImageView(img7);
			
			img8 = new Image(new FileInputStream("./resources/keys/key8.png"));
			ImageView key8 = new ImageView(img8);
			
			img9 = new Image(new FileInputStream("./resources/keys/key9.png"));
			ImageView key9 = new ImageView(img9);
			
			img10 = new Image(new FileInputStream("./resources/keys/key10.png"));
			ImageView key10 = new ImageView(img10);
			
			img11 = new Image(new FileInputStream("./resources/keys/key11.png"));
			ImageView key11 = new ImageView(img11);
			
			img12 = new Image(new FileInputStream("./resources/keys/key12.png"));
			ImageView key12 = new ImageView(img12); 
			
			if(keys[0]==1) {
				k1 = new Button();
				k1.setGraphic(key1);
				k1.setId("1");
				k1.setBackground(null);
				today.getChildren().add(k1);
			} 
			if(keys[1]==1) {
				k2 = new Button();
				k2.setGraphic(key2);
				k2.setId("2");
				k2.setBackground(null);
				today.getChildren().add(k2);
			}
			if(keys[2]==1) {
				k3 = new Button();
				k3.setGraphic(key3);
				k3.setId("3");
				k3.setBackground(null);
				today.getChildren().add(k3);
			}
			if(keys[3]==1) {
				k4 = new Button();
				k4.setGraphic(key4);
				k4.setId("4");
				k4.setBackground(null);
				today.getChildren().add(k4);
			}
			if(keys[4]==1) {
				k5 = new Button();
				k5.setGraphic(key5);
				k5.setId("5");
				k5.setBackground(null);
				today.getChildren().add(k5);
			}
			if(keys[5]==1) {
				k6 = new Button();
				k6.setGraphic(key6);
				k6.setId("6");
				k6.setBackground(null);
				today.getChildren().add(k6);
			}
			if(keys[6]==1) {
				k7 = new Button();
				k7.setGraphic(key7);
				k7.setId("7");
				k7.setBackground(null);
				today.getChildren().add(k7);
			}
			if(keys[7]==1) {
				k8 = new Button();
				k8.setGraphic(key8);
				k8.setId("8");
				k8.setBackground(null);
				today.getChildren().add(k8);
			}
			if(keys[8]==1) {
				k9 = new Button();
				k9.setGraphic(key9);
				k9.setId("9");
				k9.setBackground(null);
				today.getChildren().add(k9);
			}
			if(keys[9]==1) {
				k10 = new Button();
				k10.setGraphic(key10);
				k10.setId("10");
				k10.setBackground(null);
				today.getChildren().add(k10);
			}
			if(keys[10]==1) {
				k11 = new Button();
				k11.setGraphic(key11);
				k11.setId("11");
				k11.setBackground(null);
				today.getChildren().add(k11);
			}
			if(keys[11]==1) {
				k12 = new Button();
				k12.setGraphic(key12);
				k12.setId("12");
				k12.setBackground(null);
				today.getChildren().add(k12);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void loadDay() {
		Image image, image2, image3, image4, image5;
		Boolean pressed = false;
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

			image5 = new Image(new FileInputStream("./resources/dayimg/dialogbox.png"));
			ImageView imageView5 = new ImageView(image5);
			imageView5.setManaged(false);
			imageView5.setLayoutY(-720);
			today.getChildren().add(imageView5);
			
			loadKeys();

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

			// change styling n such later

			handler.setBottom(accessAmigo);
			handler.setRight(nextC);

			handler.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

				// it appears that the error occurs in the inheritance here somehow?

				int top = 0;
				int middle = 1;
				int bottom = 2;
				int clickCount = 1;

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
							animateCharacterOut(activeCharacter);
						}

					}
				}
			});

			today.getChildren().add(handler); // 6th item in pane
			// pane.getChildren().add(amigo); // need to change how amigo is implemented to
			// another layer on stackpane? or even change scene.
			runDay(handler);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void runDay(BorderPane handler) {
		if (day == 1) {
			ArrayList<NPC> dailyCharacters = manager.initializeCharacters(day);

			Collections.shuffle(dailyCharacters);
			dailyCharacters.add(new NPC("Tiff"));
			dailyCharacters.add(0, new NPC("Aleksandra"));
			animateButtonIn(nextC);

			nextC.setOnAction(e -> {

				// animate nextC out if index > 0

				if (index == 0) {
					animateButtonOut(nextC);
					animateDialogueBoxIn(today.getChildren().get(3)); // 4 is the index of dialogue box in stackpane
																		// today
				}

				if (index > 0) {
					animateButtonOut(nextC);

				}

				// stuff for each character
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
					for (int i = 0; i < 3; i++) active.add(" ");

					animateCharacterIn(characterView);

					// SequentialTransition seqT = new
					// SequentialTransition(animateCharacterIn(characterView).setOnFinished(e ->
					// System.out.println("Holy fuck")));
					// seqT.play();

					// some kind of event listener to control the flow of options

					// dialogueActive = true;
					ArrayList<String> dialogue = manager.getDialogue(character.getName(), day);
					playDialog(handler, dialogue);

					// System.out.println("tracker lol");

					// NPC.getDialogue(character.getName(),day);
					// do character dialogue -- listeners / etc will be muted so the player can't
					// screw around while dealing w customers

					index++;

					// animateCharacterOut(characterView);
				} catch (Exception c) {
					c.printStackTrace();
				}

				if (index == dailyCharacters.size()) {
					// end the day
				}

			});

		}
	}

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

	public void buildAmigoScreen() {

		// set the background image
		try {
			Image background = new Image(new FileInputStream("./resources/gameimg/amigobkg.png"));
			BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
			Background emailbkg = new Background(bgImg);
			amigo.setBackground(emailbkg);
		} catch (Exception e) {
		}

		Button viewGuests = new Button();
		Button viewEmails = new Button();
		Button exit = new Button();

		VBox amigoButtons = new VBox(20);
		amigoButtons.getChildren().addAll(viewGuests, viewEmails, exit);

		amigo.getChildren().add(amigoButtons);

		// viewGuests.setOnAction(e -> amigo.setCenter(checkins));
		// viewEmails.setOnAction(e -> amigo.setCenter(emails));
		exit.setOnAction(e -> amigo.getChildren().clear());

	}

	public void buildEmailScreen() { // focus on this AFTER the email screen is built
		try {
			amigo.getChildren().clear();
			Image background = new Image(new FileInputStream("./resources/menuimg/email.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
			Background emailbkg = new Background(bgImg);
			amigo.setBackground(emailbkg);
		} catch (Exception e) {
		}

		ListView<String> emails = new ListView<>(email);
		if (email.isEmpty())
			email.add("You have no new emails!");

		amigo.getChildren().add(emails);

	}

	public void buildCheckInScreen(ArrayList<NPC> dailyCharacters) {
		try {
			// clearing the borderpane and setting an appropriate background
			amigo.getChildren().clear();
			Image background = new Image(new FileInputStream("./resources/menuimg/checkin.jpg"));
			BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
			Background checkinbkg = new Background(bgImg);
			amigo.setBackground(checkinbkg);
		} catch (Exception e) {
		}

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

}
