package app;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.control.ButtonType;


/**
 * Prompts the user for choices and handles interaction with the game accordingly.
 */
public class ChoiceCenter {

	private int gulagPoints;
	private int daymistakes;
	private int customerSatisfaction;
	private boolean tiff_icecream;
	private boolean jason_mint;
	private boolean has_toaster;
	private int choice = 0;
	private double tips;
	private double spendings;
	private double bonus;
	public boolean isTiff_icecream() {
		return tiff_icecream;
	}

	// Setters and getters

	public void setTiff_icecream(boolean tiff_icecream) {
		this.tiff_icecream = tiff_icecream;
	}


	public boolean isJason_mint() {
		return jason_mint;
	}


	public void setJason_mint(boolean jason_mint) {
		this.jason_mint = jason_mint;
	}


	public boolean isHas_toaster() {
		return has_toaster;
	}


	public void setHas_toaster(boolean has_toaster) {
		this.has_toaster = has_toaster;
	}	
	
	
	public double getSpendings() {
		return spendings;
	}


	public void setSpendings(double spendings) {
		this.spendings = spendings;
	}


	public double getBonus() {
		return bonus;
	}


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}


	public double getTips() {
		return tips;
	}


	public void setTips(double tips) {
		this.tips = tips;
	}


	public int getGulagPoints() {
		return gulagPoints;
	}


	public int getDaymistakes() {
		return daymistakes;
	}


	public int getCustomerSatisfaction() {
		return customerSatisfaction;
	}


	public void setGulagPoints(int gulagPoints) {
		this.gulagPoints = gulagPoints;
	}


	public void setDaymistakes(int daymistakes) {
		this.daymistakes = daymistakes;
	}


	public void setCustomerSatisfaction(int customerSatisfaction) {
		this.customerSatisfaction = customerSatisfaction;
	}

	/**
	 * Main logical handler for choices in the game. Whenever a choicePoint is prompted, choicePoint returns a prompt for the dialogue to be displayed. 
	 * @param day an int, the current day in game
	 * @param character a String, the name of the character on screen. 
	 * @return a String, which serves as the prompt for dialogue to be processed.
	 */
	public String choicePoint(int day, String character){
		if(day ==1) {
			if(character.equalsIgnoreCase("Yvonne")) {
				choice = getChoiceTwoOptions("Are you Russian?", "Well... which is it?", "Yes", "No");//function to prompt choice from player
				if(choice == 1){//yes russian
					gulagPoints++;
					return "russian_yes";
				}
				if(choice ==2) {//no russian
					return "russian_no";
				}
				//if(choice ==3) {//ask why
				//	return "russian_why";
				//}
			}
			if(character.equalsIgnoreCase("Jason")) {
				choice = getChoiceABCD("Making Upgrades...", "How much does a Premium room cost?", "30", "55", "40", "65");//function to prompt choice from player
				if(choice ==1) {//choice (a)$30
					customerSatisfaction++;
					gulagPoints++;
					return "upgrade_a";
				}
				if(choice ==2) {//choice (b)$55
					customerSatisfaction--;
					gulagPoints++;
					return "upgrade_b";
				}
				if(choice ==3) {//choice (c)$40
					customerSatisfaction++;
					gulagPoints--;
					return "upgrade_c";
				}
				if(choice ==4) {//choice (d)$65
					customerSatisfaction--;
					gulagPoints++;
					return "upgrade_d";
				}
			}
			if(character.equalsIgnoreCase("Tiff")) {
				choice = getChoiceYesNo("Ice Cream with Tiff", "Are you feeling hungry, or?");//function to prompt choice from player
				if(choice == 1) {//yes
					gulagPoints--;
					customerSatisfaction++;
					tiff_icecream = true;
					return "iceCream_yes";
				}
				if(choice == 2) {//no
					gulagPoints++;
					customerSatisfaction--;
					tiff_icecream = false;
					return "iceCream_no";
				}
			}
		}
		if(day == 2) {
			if(character.equalsIgnoreCase("Mystery")) {
				choice = getChoiceTwoOptions("Is the big boss in the fort?", "Is Aleksandra in the office or out with her Romeo? Earth to you, sleepyhead.", "Yeah, she is.", "No, sorry.");
				if(choice == 1) {//yes she is
					gulagPoints++;
					return "aleks_yes";
				}
				if(choice ==2) {//no she isnt
					gulagPoints--;
					return "aleks_no";
				}
			}
			
			if(character.equalsIgnoreCase("Dylan")) {
				choice = getChoiceTwoOptions("Do you know your policy?", "Does the Three Eagle Hotel offer discounts to customers who several nights?", "Yes", "No");//function to prompt choice from player
				if(choice == 1) {//yes discount
					gulagPoints++;
					return "longerStay_yes";
				}
				if(choice ==2) {//no discount
					gulagPoints--;
					daymistakes++;
					return "longerStay_no";
				}
			}
			/*
			 * the part here for jason is an amigo function session
			 * will change after when proper functions are ready
			 */
			if(character.equalsIgnoreCase("Jason")) {
				choice = getChoiceTwoOptions("Email housekeeping?", "Are you going to hook your boy Jason up with some complimentary mints or what?", "Of course", "No, we're poor");
				if(choice == 1) {//yes email housekeeping
					gulagPoints++;
					jason_mint = true;
					return "mints_yes";
				}
				if(choice == 2) {//no email
					gulagPoints--;
					jason_mint = false;
					return "mints_no";
				}
			}
			
			
			
			if(character.equalsIgnoreCase("Patricia")) {
				choice = getChoiceTwoOptions("Do you know Patty P the superstar?", "Does Patricia look familiar? Maybe she's some kind of sports star? How are you supposed to know who she is?", "Yes, of course","No? Who is she??");//function to prompt choice from player
				if(choice ==1) {//yes, know her
					customerSatisfaction++;
					return "famous_yes";
				}
				if(choice ==2) {//no, do not know her
					customerSatisfaction--;
					return "famous_no";
				}
			}
			if(character.equalsIgnoreCase("tiff")) {
				//effect point, does not call function to prompt choice.
				if(tiff_icecream == true) {
					return "room_yes";
				}
				else {
					return "room_no";
					//slip note animation
				}
			}
		}
		if(day ==3) {
			if(character.equalsIgnoreCase("Yvonne")) {
				choice = getChoiceYesNo("Sneak shampoo?", "Are you gonna sneak some shampoo to Yvonne?");
				if(choice ==1) {//yes shampoo
					gulagPoints++;
					customerSatisfaction++;
					daymistakes++;
					return "shampoo_yes";
				}
				if(choice ==2) {//no shampoo
					gulagPoints--;
					customerSatisfaction--;
					return "shampoo_no";
				}
			}
			if(character.equalsIgnoreCase("Jason")) {
				//effect point
				if(jason_mint == true) {
					customerSatisfaction++;
					tips+=10;
					return "gotMints";
					
				}
				else {
					customerSatisfaction--;
					return "noGot_mints";
					
				}
			}
			
		}
		if(day ==4) {
			if(character.equalsIgnoreCase("Tiff")) {
				choice = getChoiceTwoOptions("Give pillow?", "Wanna be nice and sneak her a pillow?", "Sure", "Noway");
				if(choice==1) {//give pillow
					customerSatisfaction++;
					daymistakes++;
					return "pillow_yes";//filler prompt name
				}
				if (choice ==2) {//does not give pillow
					customerSatisfaction--;
					return "pillow_no";//filler prompt name
				}
			}
			//insert email session for Patricia (currently cut)
			if(character.equalsIgnoreCase("jason")) {
				choice = getChoiceTwoOptions("Buy Lyryx?", "Uh...Are you gonna accept the offer?", "Why not? It sounds cool.", "Nope. I'm a poor hotel worker");
				if(choice ==1) {//yes buy lyryx
					gulagPoints--;
					customerSatisfaction++;
					spendings+=40.0;
					return "sell_Lyes";
				}
				if(choice ==2) {//no buy
					gulagPoints++;
					customerSatisfaction--;
					return "sell_Lno";
				}
			}
			if(character.equalsIgnoreCase("yvonne")) {
				choice = getChoiceTwoOptions("Buy toaster?", "Wanna toast up your day by buying this toasty toaster? (You can toast your breakfast with this too)", "Yeah! Hot breakfast!", "Nah. I'm poor");
				if(choice ==1) {//yes buy toaster
					spendings+=1.0;
					has_toaster = true;
					return "sellToaster_yes";
				}
				if (choice ==2) {//no buy
					has_toaster = false;
					return "sellToaster_no";
				}
			}
			if(character.equalsIgnoreCase("dylan")) {
				choice = getChoiceTwoOptions("Give pillow?", "Wanna be nice and sneak him some puffy pillows?", "Sure!", "No.");
				if(choice ==1) {//yes pillow
					customerSatisfaction++;
					daymistakes++;
					return "pillows_yes";
				}
				if(choice == 2) {// no pillows
					customerSatisfaction--;
					return "pillows_no";
				}
			}
			
		}
		
		if(day == 5) {
			if(character.equalsIgnoreCase("anna")) {
				choice = getChoiceTwoOptions("People missing?", "Have you noticed anything about those disappearances?", "Yeah...", "What? No...");
				if(choice == 1) {//yes missing
					daymistakes++;
					gulagPoints++;
					return "missing_yes";
				}
				if(choice ==2) {//no missing 
					customerSatisfaction++;
					return "missing_no";
				}
			}
			if(character.equalsIgnoreCase("dylan")) {
				choice = getChoiceTwoOptions("Leave with Dylan?", "Do you wish to leave with Dylan and fly off to a new future?", "Sure! Let's go.", "Sorry, I still got work to do.");
				if(choice == 1) {//yes leave with dylan 
					//triggers alternate ending
					Game.gameb.buildTransitionScreen(Game.transition, Game.window, Game.mainscene, Game.dayb, Game.transitionsc, Game.menusc);
					Game.window.setScene(Game.transitionsc);
				}
				if(choice == 2) {//no leave with dylan
					return "leave_no";
				}
			}
			if(character.equalsIgnoreCase("yvonne")) {
				choice = getChoiceYesNo("Give soap?", "Give Yvonne more soap?");
				if(choice == 1) {//yes give soap
					customerSatisfaction++;
					return "soap_yes";
				}
				if(choice == 2) {//not give soap
					daymistakes++;
					customerSatisfaction--;
					return "soap_no";
				}
			}
			if(character.equalsIgnoreCase("Tiff")) {
				//effect point
				if(has_toaster) {
					return "toaster_yes";
					//connects to toaster 2
				}
				else {
					return "toaster_no";
				}
			}
			
		}
		if(day ==6) {
	
			if(character.equalsIgnoreCase("Dimitri")) {
				if(has_toaster) {
					choice = getChoiceTwoOptions("Sell the toaster?", "You wanna sell your toaster away to Dimitri and get that extra money?", "Why not? Bye Bye toaster.", "NO, i like my toaster.");
					if(choice ==1) {//sell toaster
						has_toaster = false;
						tips+=10;
						return "toaster_yes";
					}
					if(choice == 2) {
						return "toaster_no";
					}
				}
				else {//you don't have toaster
					return "noToaster";
				}
			}
			if(character.equalsIgnoreCase("dylan")) {
				choice = getChoiceTwoOptions("Where?", "You know where dylan can go and read up some old newspapers?", "The library", "The town hall");
				if(choice == 1) {//library
					customerSatisfaction++;
					return "read_a";
				}
				if(choice == 2) {//town hall
					gulagPoints++;
					return "read_b";
				}
			}
			
			if(character.equalsIgnoreCase("patricia")) {
				choice = getChoiceTwoOptions("Give Patricia blankets?", "Do you wanna give out some blankets to Patricia?", "yessss", "nah");
				if(choice == 1) {//yessss
					customerSatisfaction++;
					gulagPoints--;
					return "b_yes";
				}
				if(choice == 2) {//no
					daymistakes++;
					customerSatisfaction--;
					gulagPoints++;
					return "b_no";
				}
			}
		}
		if(day == 7) {
			if(character.equalsIgnoreCase("yvonne")) {
				choice = getChoiceTwoOptions("Give Yvonne shampoo and conditioner?", "You gonna give Yvonne her extra shampoo and conditioners? I mean, we have plenty.", "Sure!", "Nah. Sorry Yvonne.");
				if(choice == 1) {//yess give s and c
					customerSatisfaction++;
					gulagPoints--;
					return "bot_yes";
				}
				if(choice == 2) {//no give
					customerSatisfaction--;
					gulagPoints++;
					daymistakes++;
					return "bot_no";
				}
			}
			if(character.equalsIgnoreCase("Dimitri")) {
				choice = getChoiceYesNo("Uhh.....Dimitri?", "Ask Dimitri if he is okay?");
				if(choice == 1) {//yes
					customerSatisfaction++;
					return "hot_yes";
				}
				if(choice == 2) {//no
					customerSatisfaction--;
					gulagPoints++;
					return "hot_no";
				}
			}
		}
		
		return "";
	}

	
/**
* Allows for more than one choice to be made during a given day (so as not to spam choice point even more) -- use for amenities!!
*
*/
	public String secondaryChoicePoint(int day, String character){
		if(day ==2) {
			if(character.equalsIgnoreCase("Jason")) {
				choice = getChoiceTwoOptions("Are you Russian?", "Well... which is it?", "Yes", "No");//function to prompt choice from player
				if(choice == 1){//yes russian
					gulagPoints++;
					return "russian_yes";
				}
				if(choice ==2) {//no russian
					return "russian_no";
				}
				//if(choice ==3) {//ask why
				//	return "russian_why";
				//}
				
				
			}
		}
			return "";
		}
	
  
  	/**
	 * The prompts for each character are initialized so that the program can read the XML files accordingly, and decisions for later days can easily be changed by editing these lists.
	 * @param allCharacters an ArrayList<NPC>, which stores all the characters as NPC objects.
	 */
	public void initializePrompts(ArrayList<NPC> allCharacters) {
		
		for (NPC character : allCharacters) {
			if (character.getName().equals("Dylan") ) {
				character.getPrompts().add("firstDay");
				character.getPrompts().add("longerStay");
				character.getPrompts().add("roomSwap");
				character.getPrompts().add("pillows");
				character.getPrompts().add("leave"); // make dylan last on day 5
				character.getPrompts().add("read");
				character.getPrompts().add("checkOut");
			} else if (character.getName().equals("Aleksandra")) {
				character.getPrompts().add("firstDay");
				character.getPrompts().add("secondDay");
				character.getPrompts().add("thirdDay");
				character.getPrompts().add("fourthDay");
				character.getPrompts().add("fifthDay");
				character.getPrompts().add("sixthDay");
				character.getPrompts().add("seventhDay");
				System.out.println("size = "+character.getPrompts().size());
			} else if (character.getName().equals("Harriet")) {
				character.getPrompts().add("rude");
				character.getPrompts().add("");
			} else if (character.getName().contentEquals("Yvonne")) {
				character.getPrompts().add("russian");
				character.getPrompts().add("");
				character.getPrompts().add("shampoo");
				character.getPrompts().add("sellToaster");
				character.getPrompts().add("soap");
				character.getPrompts().add("roomService");
				character.getPrompts().add("bottles");
			} else if (character.getName().contentEquals("Jason")) {
				character.getPrompts().add("upgrade");
				character.getPrompts().add("mints");
				character.getPrompts().add("day3");
				character.getPrompts().add("sell_lyrynx");
				character.getPrompts().add("checkOut");
			} else if (character.getName().contentEquals("Patricia")) {
				character.getPrompts().add("");
				character.getPrompts().add("famous");
				character.getPrompts().add(""); // add some dialogue for her for day 3, because day 3 is really short rn
				character.getPrompts().add("bigNeck");
				character.getPrompts().add("");
				character.getPrompts().add("blankets");
				character.getPrompts().add("checkOut");
			} else if (character.getName().contentEquals("Tiff")) {
				character.getPrompts().add("iceCream");
				character.getPrompts().add("room");
				character.getPrompts().add(""); 
				character.getPrompts().add("pillows");
				character.getPrompts().add("toaster");// update when player chooses toaster
				character.getPrompts().add("toiletPaper");
				
			} else if (character.getName().contentEquals("Mystery")) {
				character.getPrompts().add("");
				character.getPrompts().add("aleks");
			} else if (character.getName().contentEquals("Benjamin")) {
				character.getPrompts().add("");
				character.getPrompts().add("");
				character.getPrompts().add("checkIn");
				character.getPrompts().add("checkOut");
			} else if (character.getName().contentEquals("Anna")) {
				for (int i = 0; i < 4; i++)
					character.getPrompts().add("");
				character.getPrompts().add("missing");
				character.getPrompts().add("Sad");
				
			} else if (character.getName().contentEquals("Dimitri")) {
				for (int i = 0; i < 4; i++)
					character.getPrompts().add("");
				character.getPrompts().add("checkIn"); // day 5
				character.getPrompts().add("ifToaster"); 
				character.getPrompts().add("hot");
				
				
			}
				
		}
	}
	
	/**
	 * Creates an alert that presents the user with two customizable options.
	 * @param header - a String, the title of the alert.
	 * @param content - a String, the body text of the alert.
	 * @param option1 - a String, the choice to be displayed in button 1 of the alert.
	 * @param option2  - a String, the choice to be displayed in button 2 of the alert.
	 * @return an int, which is processed using choicePoint.
	 */
	public int getChoiceTwoOptions(String header,String content, String option1, String option2) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip To the Top - Enter a choice!");
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.getDialogPane().setMinWidth(320);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		
		ButtonType buttonTypeOne = new ButtonType(option1);
		ButtonType buttonTypeTwo = new ButtonType(option2);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		   return 1;
		} else if (result.get() == buttonTypeTwo) {
		   return 2;
		} 
		
		return 0;
		
	}
	
	
	/**
	 * A less customized version of getChoiceTwoOptions
	 * @param header - a String, the title text of the alert
	 * @param content - a String, the body text of the alert.
	 * @return an int, which is processed using choicePoint.
	 */
	public int getChoiceYesNo(String header,String content) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip To the Top - Enter a choice!");
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.getDialogPane().setMinWidth(250);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		
		ButtonType buttonTypeOne = new ButtonType("Yes");
		ButtonType buttonTypeTwo = new ButtonType("No");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		   return 1;
		} else if (result.get() == buttonTypeTwo) {
		   return 2;
		} 
		
		return 0;
		
	}

	
	/**
	 * Creates a choice prompt with a title, header and 4 options. All are defined by String passed as parameters.
	 * @param header - the header for the choice alert
	 * @param content - the body / content of the choice alert
	 * @param buttonA - the first option
	 * @param buttonB - the second option
	 * @param buttonC - the third option
	 * @param buttonD - the fourth option
	 * @return an int, 1-4 depending on the choice made (handled by choicePoint)
	 */
	public int getChoiceABCD(String header,String content, String buttonA, String buttonB, String buttonC, String buttonD) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip To the Top - Enter a choice!");
		alert.setHeaderText(header);
		alert.setContentText(content);

		
		alert.getDialogPane().setMinWidth(350);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		
		ButtonType buttonTypeOne = new ButtonType(buttonA);
		ButtonType buttonTypeTwo = new ButtonType(buttonB);
		ButtonType buttonTypeThree = new ButtonType(buttonC);
		ButtonType buttonTypeFour = new ButtonType(buttonD);
		
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeFour);

		Optional<ButtonType> result = alert.showAndWait(); // change this to allow the user to refer to the Amigo 1000 in the future.
		if (result.get() == buttonTypeOne){
		   return 1;
		} else if (result.get() == buttonTypeTwo) {
		   return 2;
		} else if (result.get() == buttonTypeThree) {
			return 3;
		} else if (result.get() == buttonTypeFour) {
			return 4;
		}
		
		return 0;
		
	}
	
	/**
	 * Get's the choice which determines the ending that the player will receive.
	 * @return a number, which is processed in buildTransitionScreen (GameBuilder) to build the desired ending.
	 */
	public int getChoiceFinale() {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip to the Top - will you win?");
		alert.setHeaderText("Which character is the one behind all the madness?");
		alert.setContentText("Choose carefully...");
		
		ButtonType buttonTypeOne = new ButtonType("Yvonne");
		ButtonType buttonTypeTwo = new ButtonType("Dylan");
		ButtonType buttonTypeThree = new ButtonType("Jason");
		ButtonType buttonTypeFour = new ButtonType("Aleksandra");
		ButtonType buttonTypeFive = new ButtonType("Patricia");
		ButtonType buttonTypeSix = new ButtonType("Tiff");
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == buttonTypeOne){
			   return 1;
			} else if (result.get() == buttonTypeTwo) {
			   return 2;
			} else if (result.get() == buttonTypeThree) {
				return 3;
			} else if (result.get() == buttonTypeFour) {
				return 4;
			} else if (result.get() == buttonTypeFive) {
				return 5;
			} else if (result.get() == buttonTypeSix) {
				return 6;
			}
		
		
			return 0;
	}
	
	
	/**
	 * Like choicePoint, but adds returns emails for use within the game.
	 * @param day - an int, the current day ingame
	 * @param characterName - the String name of the current character
	 * @return an Email, processed by DayBuilder.
	 */
	public Email emailPoint (int day, String characterName) {
		
		if (day == 3 && characterName.equalsIgnoreCase("Benjamin")) {
			return new Email("Housekeeping", "An empty room?" , "Hey, its housekeeping. One of the rooms is locked.. Also, it has had the do not disturb sign for basically a week now. I'm sure whoever is inside is not going to come out anytime soon. I'm not even sure if there's a guest inside of it anymore." );
		} else if (day == 3 && characterName.equalsIgnoreCase("Yvonne")) {
			return new Email("harriet240@yoml.com", "Awful Service", "Hello. I stopped by a couple days ago, and the service was absymal. The individual at the fron desk is clearly a doorknob and should be replaced with a more capable candidate. Perhaps if somone with actual brain cells was at the desk, I would have considered staying, but what's a man supposed to do? Just go with it? Unbelievable. Please get back to me if you fire that lously clerk.");
		} else if (day == 4 && characterName.equalsIgnoreCase("Tiff")) {
			return new Email("Aleksandra", "Stop being a good employee!", "You being so good forces me to give you a bonus because of the �ethics� and �morals� stuff. Are you here to steal my money or make money for me? I’m trying to run a profitable business here! Expect the raise. You finished reading this? Now close this silver block on your Amigo and get back to work!");
		} else if (day == 4 && characterName.equalsIgnoreCase("Patricia")) {
			return new Email("brokesalesman64@yaloo.ca", "Howdy there partner!", "You feel like your future’s blurry, or you just never know what to do, well no probelmo. We got the right thing just for you. Try out our magical pure-polish cleanser that can clean any surface in no time. It can clean your glasses, your windows, even your favorite crystal ball to let you see your future crystal clear! Let our cleanser make those surfaces shine your future ahead! Try one 369ml just for $15.99, $15.99! You think that’s not a good enough deal, well we have a set of 2*400ml of our magical cleanser for just 20.99, **20.99!!!!** With a bonus of our magical scrubber customized just for you! Dial the code: 2392732539 to get another 1.99 off!! Limited sale for just 20 minutes! Be quick, be fast and scrub away with our one and only MAGICAL SCCRRRRRUBBER!");
		} else if (day == 5 && characterName.equalsIgnoreCase("Yvonne")) {
			return new Email("annathesnack@bmail.com", "Weird noises?", "Hello, I just wanted to express some concern for the people across the hall from me? I can’t tell what it is most of the time. It’s sounding like children laughing at one moment, then an old woman sobbing in the next. And currently it sounds like two people going at it. Please help.");
		} else if (day == 5 && characterName.equalsIgnoreCase("Tiff")) {
			return new Email ("mysteryman86@hotmail.com", "...", "You’re really starting to tread on thin ice… I hope you manage to get it together for the last 2 days... Also, your boss is weird.");
		} else if (day == 6 && characterName.equalsIgnoreCase("Yvonne")) {
			return new Email ( "aleeismybabee@gulag.net", "Dining Hall", "Hello, my friend. How many rooms would you like in the dining hall of the gulag? Everything is almost ready to go. Get ready. Yours Truly, M.");
		} else if (day == 6 && characterName.equalsIgnoreCase("Dimitri")) {
			return new Email ("jasonmathgod@uofyaloo.ca", "A favour?","Dear Three Eagle Hotel Staff: I would like to request if it were possible for your wonderful establishment to display a few ads for Lyrynx. I’ve attached them below, have a great day. Cheers, Jason");
		} else if (day == 6 && characterName.equalsIgnoreCase("Tiff")) {
			return new Email ("loveuboo@coolmail.com","hey there babee ;)","i know how you were lookin at me the other nite. dont be afraid to call ;)) u know when and where. ~xoxoooxo");
		} else if (day == 7 && characterName.equalsIgnoreCase("Patricia")) {
			return new Email ("mysterman86@hotmail.ca", "Everything is ready.", "My dear friend. Everything is set to go. Everything will be commencing soon. We are only moments away. It was very nice knowing you. I hope that one day, wherever we end up we can do business together again. Best wishes, M");
			
		} else if (day == 7 && characterName.equalsIgnoreCase("Dimitri")) {
			return new Email("mysteryman86@hotmail.ca", "URGENT", "Dearest friend. There is something wrong. It should have happened. Why didn’t it happen? Please let me stay at your place for a few days. I will be here soon. I’m worried. I hope you are well. Best, M");
		}
		
		return new Email();
	}
	
}
