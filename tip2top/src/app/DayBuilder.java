package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
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
	Booking bmanager = new Booking(null);
	ChoiceCenter cmanager = new ChoiceCenter();
	Email emanager = new Email();
	Money moneyManager = new Money();
	

	BorderPane handler = new BorderPane();
	
	
	// NPC Management
	ArrayList<NPC> allCharacters = new ArrayList<NPC>();
  	// daily characters
	private ArrayList<NPC> dailyCharacters = new ArrayList<NPC>();
	private NPC character = null;
	
	// make a function in NPC to fill this with all characters
	
	public int keys[] = {1,1,1,1,1,1,1,1,1,1,1,1};
	public Node key[] = {null,null,null,null,null,null,null,null,null,null,null,null};

	
	// Amigo 1000 resources
	private ObservableList<String> bookings = FXCollections.observableArrayList(); // list of bookings toStrings displayed in Amigo
	private ObservableList<String> emailsObservable = FXCollections.observableArrayList(); // list of emails toStrings displayed in Amigo 1000 
	private ArrayList<Email> email_list = new ArrayList<Email>(); // list of emails in the Amigo 1000
	private Button nextC = new Button(); 
	private boolean clickable = false;
	private int index = 0;
	
	
	// Image of the character currently in slot 1 / being displayed
	private ImageView activeCharacter;
	
	// dialogue slots + trackers
	private ArrayList<String> active = new ArrayList<>();
	private boolean dialogueActive = false;
	private Text slot1 = new Text("");
	private Text slot2 = new Text("");
	private Text slot3 = new Text("");
	
	
	//Setters and getters (self-explanatory)
	
	public ArrayList<NPC> getDailyCharacters() {
		return dailyCharacters;
	}

	public void setDailyCharacters(ArrayList<NPC> dailyCharacters) {
		this.dailyCharacters = dailyCharacters;
	}

	public Money getMoneyManager() {
		return moneyManager;
	}

	public void setChoiceManager(Money moneyManager) {
		this.cmanager = moneyManager;
	}

	public ChoiceCenter getChoiceManager() {
		return cmanager;
	}

	public void setMoneyManager(Money moneyManager) {
		this.moneyManager = moneyManager;
	}
	
	public StackPane getToday() {
		return today;
	}

	private int day = 1;
	
	public int[] getKeys() {
		return keys;
	}

	public void setKeys(int[] keys) {
		this.keys = keys;
	}
	
	public ArrayList<NPC> getAllCharacters() {
		return allCharacters;
	}

	public void setAllCharacters(ArrayList<NPC> allCharacters) {
		this.allCharacters = allCharacters;
	}

	public Node[] getKey() {
		return key;
	}

	public void setKey(Node[] key) {
		this.key = key;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public ArrayList<Email> getEmail_list() {
		return email_list;
	}

	public void setEmail_list(ArrayList<Email> email_list) {
		this.email_list = email_list;
	}

	

	public ObservableList<String> getBookings() {
		return bookings;
	}

	public void setBookings(ObservableList<String> bookings) {
		this.bookings = bookings;
	}

	public ObservableList<String> getEmailsObservable() {
		return emailsObservable;
	}

	public void setEmailsObservable(ObservableList<String> emailsObservable) {
		this.emailsObservable = emailsObservable;
	}
	

  
	// Pat created this to load images for day
	
	/**
	 * Highlights selected keys
	 * @param node - the key to be highlighted.
	 */
	public void addEvent(Node node) {
		DropShadow shadow = new DropShadow();
		DropShadow highlight = new DropShadow();
		DropShadow give = new DropShadow();
		
		shadow.setColor(Color.BLACK);
		shadow.setOffsetY(10);
		
	    highlight.setColor(Color.YELLOW);
	    highlight.setSpread(12);
	    highlight.setRadius(3);
	    
	    give.setColor(Color.RED);
	    give.setSpread(12);
	    give.setRadius(3);
		
		node.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	int temp;
		        	temp = Integer.parseInt(node.getId());
		        	temp -= 1;
		        	if(keys[temp]==1) {
		        		node.setEffect(highlight);
		        	}
		          }
		        });

		node.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  int temp;
		        	  temp = Integer.parseInt(node.getId());
		        	  temp -= 1;
		        	  if(keys[temp]==1) {
		        		  node.setEffect(shadow);
		        	  }
		        	  
		          }
		        });
		
		node.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						
						
					}
				});
		
		node.addEventHandler(MouseEvent.MOUSE_RELEASED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						
						int temp;
						temp = Integer.parseInt(node.getId());
						temp -= 1;
						
						if(keys[temp]==1) {
							for(int i = 0;i<12;i++) {
								key[i].setEffect(shadow);
								keys[i]= 1;
									
								
							}
							keys[temp]= 2;
							node.setEffect(highlight);
						}else if(keys[temp]==2&& character != null) {
							if(character.getName().equals("Yvonne")&&temp+1==12) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							} else if(character.getName().equals("Jason")&&temp+1==6) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}else if(character.getName().equals("Dylan")&&temp+1==3) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}else if(character.getName().equals("Tiff")&&temp+1==2) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}else if(character.getName().equals("Patricia")&&temp+1==10) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}else if(character.getName().equals("Dylan")&&temp+1==1&&character.getKey()==3) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}else if(character.getName().equals("Benjamin")&&temp+1==7) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}else if(character.getName().equals("Anna")&&temp+1==11) {
								keys[temp]=3;
								node.setEffect(give);
								
								character.setKey(temp+1);
								System.out.print(character.getKey());
								
								TranslateTransition translate = new TranslateTransition();
								translate.setDuration(Duration.millis(1300));
								translate.setNode(node);
								translate.setByX(300);
								translate.setByY(-250);
								translate.setCycleCount(1);
								translate.setAutoReverse(false);
								translate.play();
								
								 FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
								 ft.setDelay(Duration.millis(1300));
							     ft.setFromValue(1.0);
							     ft.setToValue(0);
							     ft.setCycleCount(1);
							     ft.setAutoReverse(true);
							 
							     ft.play();
							}
							
							//Could add negative points here
							
							
						}
						
					}
				});
}

	/**
	 * Loads the basic interface for the day and it's necessary elements. (including keys, characters, images, etc)
	 * @param window - the Stage, needed to switch scenes.
	 * @param amigoscreen - the scene for the Amigo 1000s interface
	 * @param transition - the scene for the transition screen to be built onto.
	 */
	public void loadDay(Stage window, Scene amigoscreen, Scene transition) {
		Image image, image2, image3, image5;
		try {
			nextC.setLayoutX(1300);
			nextC.setLayoutY(650);
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
			
			
			
			Image img1, img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12;
			//Button k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12;
			
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
				
				key[0]=key1;
				key[1]=key2;
				key[2]=key3;
				key[3]=key4;
				key[4]=key5;
				key[5]=key6;
				key[6]=key7;
				key[7]=key8;
				key[8]=key9;
				key[9]=key10;
				key[10]=key11;
				key[11]=key12;
				
				
				if(keys[0]==1) {
					key1.setId("1");
					addEvent(key1);
					key1.setX(40);
					key1.setY(50);
					handler.getChildren().add(key1);
				} 
				if(keys[1]==1) {
					key2.setId("2");
					addEvent(key2);
					key2.setX(40);
					key2.setY(50);
					handler.getChildren().add(key2);
				}
				if(keys[2]==1) {
					key3.setId("3");
					addEvent(key3);
					key3.setX(40);
					key3.setY(50);
					handler.getChildren().add(key3);
				}
				if(keys[3]==1) {
					key4.setId("4");
					addEvent(key4);
					key4.setX(40);
					key4.setY(50);
					handler.getChildren().add(key4);
				}
				if(keys[4]==1) {
					key5.setId("5");
					addEvent(key5);
					key5.setX(40);
					key5.setY(50);
					handler.getChildren().add(key5);
				}
				if(keys[5]==1) {
					key6.setId("6");
					addEvent(key6);
					key6.setX(40);
					key6.setY(50);
					handler.getChildren().add(key6);
				}
				if(keys[6]==1) {
					key7.setId("7");
					addEvent(key7);
					key7.setX(40);
					key7.setY(50);
					handler.getChildren().add(key7);
				}
				if(keys[7]==1) {
					key8.setId("8");
					addEvent(key8);
					key8.setX(40);
					key8.setY(50);
					handler.getChildren().add(key8);
				}
				if(keys[8]==1) {
					key9.setId("9");
					addEvent(key9);
					key9.setX(40);
					key9.setY(50);
					handler.getChildren().add(key9);
				}
				if(keys[9]==1) {
					key10.setId("10");
					addEvent(key10);
					key10.setX(40);
					key10.setY(50);
					handler.getChildren().add(key10);
				}
				if(keys[10]==1) {
					key11.setId("11");
					addEvent(key11);
					key11.setX(40);
					key11.setY(50);
					handler.getChildren().add(key11);
				}
				if(keys[11]==1) {
					key12.setId("12");
					addEvent(key12);
					key12.setX(40);
					key12.setY(50);
					handler.getChildren().add(key12);
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				Image amigobtn = new Image(new FileInputStream("./resources/gameimg/a.png"));
				
				ImageView amigobtng = new ImageView(amigobtn);
				
				DropShadow shadow = new DropShadow();
				DropShadow highlight = new DropShadow();
				
				shadow.setColor(Color.BLACK);
				shadow.setOffsetY(10);
				
			    highlight.setColor(Color.YELLOW);
			    highlight.setSpread(12);
			    highlight.setRadius(3);
				
				amigobtng.addEventHandler(MouseEvent.MOUSE_ENTERED,
				        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	amigobtng.setEffect(highlight);
				          }
				        });

				amigobtng.addEventHandler(MouseEvent.MOUSE_EXITED,
				        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	  amigobtng.setEffect(shadow);
				        	  
				        	  
				          }
				        });
				
				amigobtng.addEventHandler(MouseEvent.MOUSE_PRESSED,
				        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	  window.setScene(amigoscreen);
				        	  
				        	  
				          }
				        });
				
					
					
				
				
				handler.setBottom(amigobtng);
				
				

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
			
			
			// initializing everything
			
			manager.populateAllCharacters(allCharacters);
			cmanager.initializePrompts(allCharacters);
			
			emanager.initializeEmails(email_list);
			
			for (Email item : email_list) {
				emailsObservable.add(item.toString());
			}

			bmanager.loadBookings(allCharacters, bookings);
			
			manager.initializeCharacters(day, allCharacters, dailyCharacters);
			
			// change styling n such later

			
			handler.setRight(nextC);
			
			//@TODO change this to a keyboard button press so it doesn't cause bugs with amigo + keys
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
					if (dialogueActive&&(mouseEvent.getY() < 280 || mouseEvent.getX() > 800)) {
						if (clickCount <= active.size() - 2) {
							clickCount++;

							if (top < active.size())
								slot1.setText(active.get(top));
							if (middle <= active.size() - 1)
								slot2.setText(active.get(middle));
							if (bottom <= active.size() - 2)
								slot3.setText(active.get(bottom));
							if (active.get(bottom + 1).contentEquals("choice")) {
								String prompt = cmanager.choicePoint(day, character.getName());
								ArrayList<String> read = Reader.getDialogue(character.getName(), prompt);
								active.remove(bottom+1);
								active.addAll(bottom + 1, read);
							}
							if (active.get(bottom + 1).contentEquals("choice2")) {
								//String prompt = cmanager.choicePoint
							} if (active.get(bottom + 1).contentEquals("--You have a new email!--")) {
								addEmail(cmanager.emailPoint(day, character.getName()));
							}
							
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
							//animateCharacterOut(activeCharacter); // change this to next character button.
						}

					}
				}
			});

			today.getChildren().add(handler); // 6th item in pane
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

}


	/**
	 * Handles the "day" of events as a whole. Controls which characters are on the screen, advances characters and triggers animations.
	 * @param window a Stage, needed to switch between days.
	 * @param transition a Scene, the transition scene for the game. (between days)
	 */
	public void runDay(Stage window, Scene transition) {
		
		Collections.shuffle(dailyCharacters);
		
			if (day == 1) {
				
				dailyCharacters.add(manager.getCharacter("Tiff", allCharacters)); // move this to initialize characters
				System.out.println(dailyCharacters.toString());

			} 

			dailyCharacters.add(0, manager.getCharacter("Aleksandra", allCharacters));
			animateButtonIn(nextC);

			nextC.setOnAction(e -> {
				
				if (clickable) {
					
					
					clickable = false;

					// animate nextC out if index > 0

					if (index == 0) {
						animateButtonOut(nextC);
						animateDialogueBoxIn(today.getChildren().get(3)); // 3 is the index of dialogue box in stackpane
						runCharacter();													// today
					}

					if (index > 0) {
						animateButtonOut(nextC);
						animateCharacterOut(activeCharacter, handler, window, transition);
					}
					
					index++;
					//System.out.println(index);
					
					
				}
				

			});

		
	}

	/**
	 * Is responsible for running a single character. Triggers necessary animations and loads necessary images.
	 * Additionally, this retreives the initial dialogue for the character.
	 */
	public void runCharacter() {
		if (index == 0) character = dailyCharacters.get(index);
		if (index >= 1) character = dailyCharacters.get(index -1); // just corrects the index to fix a bug where a player was skipped.

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

			//System.out.println(character.getPrompts().size());
			//System.out.println(allCharacters.get(5).getPrompts().size());
			ArrayList<String> read = Reader.getDialogue(character.getName(), character.getPrompts().get(day - 1));
			
			playDialog(handler, read);

		} catch (Exception c) {
			c.printStackTrace();
		}
	}
	
	
	/**
	 * Handles the dialog functionality of the game. Responds to mouse click
	 * @TODO - remove/fix the default / enter key functionality (it's broke)?
	 * @param pane a BorderPane, in which the dialog labels are displayed
	 * @param dialog an ArrayList<String> which stores dialog to be played.
	 */
	public void playDialog(BorderPane pane, ArrayList<String> dialog) {
		//System.out.println(dialog.toString());

		active.addAll(dialog); // we need to separate this so we can ensure it is done correctly?
		for (int i = 0; i < 3; i++)
			active.add(" ");
    
		// get the array list for the given npc and prompt

		
		VBox container = new VBox(10);

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

		//System.out.println(amigo.getChildren().size());
		
		viewGuests.setOnAction(e -> {
			buildCheckInScreen(dailyCharacters, amigo);
		});
		viewEmails.setOnAction(e -> {
			buildEmailScreen(amigo);
		});
		exit.setOnAction(e -> window.setScene(mainscene));

	}

	/**
	 *  Builds the interface for the email screen of the Amigo 1000
	 * @param amigo the StackPane to build onto.
	 */
	public void buildEmailScreen(StackPane amigo) { 

		// add functionality for emails to be opened (also need a new button!)
		
		Image image;
		try {
			image = new Image(new FileInputStream("./resources/gameimg/amigo/emailsamigo.png"));
			ImageView imageView = new ImageView(image);
			amigo.getChildren().add(imageView);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		
		BorderPane handler = new BorderPane();
		
		ListView<String> emails = new ListView<>(emailsObservable);

		Button open = new Button();
		Button back = new Button();

		try {
		Image openimg = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/readbtn.jpg"));
		open.setGraphic(new ImageView(openimg));
		Image backimg = new Image(new FileInputStream("./resources/gameimg/amigo/buttons/back.png"));
		back.setGraphic(new ImageView(backimg));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(open, back);
		
		for (Node item : buttons.getChildren()) 
			item.setStyle("-fx-base: #000000;");
		
		handler.setCenter(emails);
		handler.setRight(buttons);
		// event handling for buttons

		BorderPane.setMargin(buttons, new Insets(250, 240, 0, 30));
		BorderPane.setMargin(emails, new Insets(250, 20, 140 ,220));
		
		amigo.getChildren().add(handler);
		
		//System.out.println(amigo.getChildren().size());
		
		open.setOnAction(e -> {
			
			Email selected = email_list.get(emails.getSelectionModel().getSelectedIndex());
			
			
			//System.out.println("display the message lol");
			
			Alert email = new Alert(AlertType.INFORMATION);
			email.setTitle("AmigoEmail 1.0");
			email.setHeaderText("From: " + selected.getSender());
			email.setContentText(selected.getMessage());
			email.getDialogPane().setMinWidth(530);
			email.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			// add custom email icon
			email.setResizable(true);
			
			

			email.showAndWait();
		
		});
		back.setOnAction(e -> {
			amigo.getChildren().remove(amigo.getChildren().size() - 1);
			amigo.getChildren().remove(amigo.getChildren().size() - 1);
		});
	}
		
	/**
	 * Builds the check in screen for the Amigo 1000.
	 * @param dailyCharacters an ArrayList<NPC>, the list of characters for the day.
	 * @param amigo a StackPane which the check in screen is built onto. 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buildCheckInScreen(ArrayList<NPC> dailyCharacters, StackPane amigo) {
		
		// @TODO complete integration with bookings class
		
		Image image;
		try {
			image = new Image(new FileInputStream("./resources/gameimg/amigo/guestamigo.png"));
			ImageView imageView = new ImageView(image);
			amigo.getChildren().add(imageView);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		BorderPane handler = new BorderPane();
		
		ListView<String> guestlist = new ListView<>(bookings);
		TextField guestName = new TextField("Name"); // change to ComboBox
		ComboBox roomNum = new ComboBox(); // change to ComboBox
		ComboBox roomType = new ComboBox();
		for (int i = 1; i <= 12; i++) roomNum.getItems().add(i);
		roomType.getItems().addAll("Basic ($30)", "Premium ($40)", "Luxury ($55)");
		
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
		addName.getChildren().addAll(guestName, roomNum, roomType); 

		VBox buttons = new VBox(20);
		buttons.getChildren().addAll(addGuest, checkOut, back);
		
		for (Node item : buttons.getChildren()) 
			item.setStyle("-fx-base: #000000;");
		
		// positioning for elements
		
		handler.setCenter(guestlist);
		handler.setTop(addName);
		handler.setRight(buttons);

		BorderPane.setMargin(addName, new Insets(240, 0,0,230));
		BorderPane.setMargin(buttons, new Insets(40, 240, 0, 30));
		BorderPane.setMargin(guestlist, new Insets(40, 20, 140 ,220));
		
		amigo.getChildren().add(handler);
		
		//System.out.println(amigo.getChildren().size());
		
		addGuest.setOnAction(e -> {
			
			String selectedType = (String) roomType.getValue();
			selectedType = selectedType.substring(0, selectedType.length() - 6);
			int roomNumber = (int) roomNum.getValue();
			
			String gname = guestName.getText();
			if(gname.equals("Tiffany")) {
				gname = "Tiff";
			}
			
			// checks if values entered are valid by testing the entered name
			
			if (gname != null) {
				for (NPC character : allCharacters) {
					if (gname.contentEquals(character.getName())) {
						Booking toAdd = new Booking(gname,roomNumber,selectedType);
						character.setBooking(toAdd); // updates the character's booking
						character.setCheckedIn(true);
						bookings.add(toAdd.toString()); // updates the list on screen
						
					}
				}
				
			}
			
		});
		checkOut.setOnAction(e ->{
			bookings.remove(guestlist.getSelectionModel().getSelectedIndex());
			// remove the booking / set guest as checked out
		});
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
	
	/**
	 * Used to trigger the next day of the game.
	 * @param window a Stage, used to change scenes.
	 * @param transitionsc the Scene to switch to between days. 
	 */
	public void triggerNewDay(Stage window, Scene transitionsc) {
		index = 0; // resets index
		day++; // increments day
		nextC.setLayoutX(1300); // resets position of next characters button.
		nextC.setLayoutY(650);
		manager.initializeCharacters(day, allCharacters, dailyCharacters); // initializes characters for next day
		System.out.println(dailyCharacters);
		runDay(window,transitionsc); // runs the next day!
	}

	// Various animations, nothing significant
	
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
	public TranslateTransition animateCharacterOut(Node character, BorderPane handler, Stage window, Scene transition) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(character);
		translate.setByX(590);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.play();
		translate.setOnFinished(e -> {
			if (index -1 < dailyCharacters.size()) runCharacter();
			if (index -1 == dailyCharacters.size()) {
				//System.out.println("LOL");
				animateDialogueBoxOut(today.getChildren().get(3), window, transition);
				//animate dialogue box out
			}
			
		});
		return translate;

	}

	public TranslateTransition animateButtonIn(Node button) {
		TranslateTransition translate = new TranslateTransition();
		translate.setDuration(Duration.millis(1300));
		translate.setNode(button);
		translate.setByX(-370);
		translate.setCycleCount(1);
		translate.setAutoReverse(false);
		translate.setOnFinished(e -> clickable = true);
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
		translate.setOnFinished(e -> {
			
			GameBuilder lol = new GameBuilder();
			
			
			lol.buildTransitionScreen(Game.transition, window, Game.mainscene, Game.dayb, Game.transitionsc, Game.menusc);
			
			window.setScene(transition);
		});
		translate.play();
		// translate.setOnFinished(e -> dialogueActive = true);
		return translate;

	}

	/**
	 * Adds an email to the ListView in the Amigo 1000 and the actual list used for storage of the emails. 
	 * @param toAdd an Email, the email to be added to the previously specified lists.
	 */
	public void addEmail(Email toAdd) {
		email_list.add(0, toAdd);
		emailsObservable.add(0, toAdd.toString());
		
		try {
			
		} catch (Exception e) {
			
		}
		
		
		
	}
	
	
}
