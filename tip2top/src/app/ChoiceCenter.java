package app;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.control.ButtonType;

public class ChoiceCenter {

	private int gulagPoints;
	private int daymistakes;
	//private int totalmistakes;
	private int customerSatisfaction;
	private boolean tiff_icecream;
	private boolean jason_mint;
	private boolean has_toaster;
	private int choice = 0;
	private double tips;
	private double spendings;
	private double bonus;
	private boolean toasterPurchased;
	
	
	// arrays for prompts
	
	
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
				choice = getChoiceTwoOptions("Is the big boss in the fort?", "Is Aleksandra in the office or out with her Romeo? Earth to you, sleepyhead.", "Yeah, she is.", "She's with her boy toy.");
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
					return "longerStay_no";
				}
			}
			/*
			 * the part here for jason is an amigo function session
			 * will change after when proper functions are ready
			 */
			if(character.equalsIgnoreCase("Jason")) {
				choice = getChoiceTwoOptions("Email housekeeping?", "Are you going to hook your boy Jason up with some complimentary mints or what?", "Of course", "No, we're poor");//function to prompt choice from player
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
				choice = 0;//function to prompt choice from player
				if(choice ==1) {//yes shampoo
					gulagPoints++;
					customerSatisfaction++;
					return "shampoo_yes";//filler prompt name
				}
				if(choice ==2) {//no shampoo
					gulagPoints--;
					customerSatisfaction--;
					return "shampoo_no";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("Jason")) {
				//effect point
				if(jason_mint == true) {
					customerSatisfaction++;
					tips+=10;
					return "gotMints";//filler prompt name
					
				}
				else {
					customerSatisfaction--;
					return "noGot_mints";//filler prompt name
					
				}
			}
			
		}
		if(day ==4) {
			if(character.equalsIgnoreCase("Tiff")) {
				choice = 0; //function to prompt choice
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
			//insert phone session for Patricia
			if(character.equalsIgnoreCase("jason")) {
				choice = 0; //function to prompt choice
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
				choice = 0;//function to prompt choice
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
				choice = 0;//function to prompt choice
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
				choice = 0;//function to prompt choice
				if(choice == 1) {//yes missing
					daymistakes++;
					return "missing_yes";
				}
				if(choice ==2) {//no missing 
					customerSatisfaction++;
					return "missing_no";
				}
			}
			if(character.equalsIgnoreCase("dylan")) {
				choice = 0;//function to prompt choice
				if(choice == 1) {//yes leave with dylan 
					//triggers alternate ending
				}
				if(choice == 2) {//no leave with dylan
					return "leave_no";
				}
			}
			if(character.equalsIgnoreCase("yvonne")) {
				choice = 0;//function to prompt choice
				if(choice == 1) {//yes give soap
					customerSatisfaction++;
					return "soap_yes";
				}
				if(choice == 2) {//not give soap
					daymistakes++;
					return "soap_no";
				}
			}
			if(character.equalsIgnoreCase("Tiffany")) {
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
	
			if(character.equalsIgnoreCase("dimitri")) {
				if(has_toaster) {
					choice = 0;//function to prompt choice
					if(choice ==1) {//sell toaster
						has_toaster = false;
						tips+=10;
						return "";
					}
					if(choice == 2) {
						return "";
					}
				}
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
				character.getPrompts().add("");
				character.getPrompts().add("");
			} else if (character.getName().equals("Aleksandra")) {
				character.getPrompts().add("firstDay");
				character.getPrompts().add("secondDay");
				character.getPrompts().add("thirdDay");
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
			} else if (character.getName().contentEquals("Jason")) {
				character.getPrompts().add("upgrade");
				character.getPrompts().add("mints");
				character.getPrompts().add("mints-placeholder"); // update when player makes choice on mints
			} else if (character.getName().contentEquals("Patricia")) {
				character.getPrompts().add("");
				character.getPrompts().add("famous");
				character.getPrompts().add(""); // add some dialogue for her for day 3, because day 3 is really short rn
				character.getPrompts().add("bigNeck");
			} else if (character.getName().contentEquals("Tiff")) {
				character.getPrompts().add("iceCream");
				character.getPrompts().add("room");
				character.getPrompts().add("pillows");
				character.getPrompts().add("toaster-placeholder"); // update when player chooses toaster
			} else if (character.getName().contentEquals("Mystery")) {
				character.getPrompts().add("");
				character.getPrompts().add("aleks");
			} else if (character.getName().contentEquals("Benjamin")) {
				character.getPrompts().add("");
				character.getPrompts().add("");
				character.getPrompts().add("checkIn");
				character.getPrompts().add("checkOut");
			} else if (character.getName().contentEquals("Anna")) {

				
			} else if (character.getName().contentEquals("Dimitri")) {
				for (int i = 0; i < 4; i++)
				character.getPrompts().add("");
				
				character.getPrompts().add("checkIn"); // day 5
				character.getPrompts().add("toaster"); 
				// day 6 --- treat this like Tiff's choice point
				
			}
				
		}
	}
	
	
	public int getChoiceTwoOptions(String header,String content, String option1, String option2) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip To the Top - Enter a choice!");
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.getDialogPane().setMinWidth(250);
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
	
}
