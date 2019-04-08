package app;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class ChoiceCenter {

	private int gulagPoints;
	private int daymistakes;
	private int totalmistakes;
	private int customerSatisfaction;
	private boolean tiff_icecream;
	private boolean jason_mint;
	private int choice = 0;
	
	
	// arrays for prompts
	
	
	public String choicePoint(int day, String character){
		if(day ==1) {
			if(character.equalsIgnoreCase("Yvonne")) {
				choice = getChoiceYesNo("Are you Russian?", "Well... which is it?");//function to prompt choice from player
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
				choice = getChoiceABCD("Making Upgrades...", "How much does a Premium room cost?");//function to prompt choice from player
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
			if(character.equalsIgnoreCase("Dylan")) {
				choice = 0;//function to prompt choice from player
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
				choice = 0;//function to prompt choice from player
				if(choice == 1) {//yes email housekeeping
					gulagPoints++;
					jason_mint = true;
					//return "weeee";//filler prompt name
				}
				if(choice == 2) {//no email
					gulagPoints--;
					jason_mint = false;
					//return "weeee";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("Patricia")) {
				choice = 0;//function to prompt choice from player
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
					return "weeee";//filler prompt name
				}
				if(choice ==2) {//no shampoo
					gulagPoints--;
					customerSatisfaction--;
					return "weeee";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("Jason")) {
				//effect point
				if(jason_mint == true) {
					customerSatisfaction++;
					return "weeee";//filler prompt name
					//tip +10
				}
				else {
					customerSatisfaction--;
					return "weeee";//filler prompt name
					
				}
			}
			
		}
		if(day ==4) {
			if(character.equalsIgnoreCase("Tiff")) {
				choice = 0; //function to prompt choice
				if(choice==1) {//give pillow
					customerSatisfaction++;
					//dailymistakes++;
					return "weeee";//filler prompt name
				}
				if (choice ==2) {//does not give pillow
					//customerSatisfaction--;
					return "weeee";//filler prompt name
				}
			}
			//insert phone session for Patricia
			if(character.equalsIgnoreCase("jason")) {
				choice = 0; //function to prompt choice
				if(choice ==1) {//yes buy lyryx
					gulagPoints--;
					//customerSatisfaction++;
					return "weeee";//filler prompt name
				}
				if(choice ==2) {//no buy
					gulagPoints++;
					//customerSatisfaction--;
					return "weeee";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("yvonne")) {
				choice = 0;
				if(choice ==1) {//yes buy toaster
					
				}
				if (choice ==2) {//no buy
					
				}
			}
			
		}
		
		return "";
	}
	
	
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
			}
		}
	}
	
	public int getChoiceYesNo(String header,String content) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip To the Top - Enter a choice!");
		alert.setHeaderText(header);
		alert.setContentText(content);

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

	public int getChoiceABCD(String header,String content) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Tip To the Top - Enter a choice!");
		alert.setHeaderText(header);
		alert.setContentText(content);

		ButtonType buttonTypeOne = new ButtonType("30");
		ButtonType buttonTypeTwo = new ButtonType("55");
		ButtonType buttonTypeThree = new ButtonType("40");
		ButtonType buttonTypeFour = new ButtonType("65");

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
