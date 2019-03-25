package app;

public class ChoiceCenter extends DayBuilder {

	private int gulagPoints;
	private int daymistakes;
	private int totalmistakes;
	private boolean tiff_icecream;
	private boolean jason_mint;
	private int choice = 0;
	
	public String choicePoint(int day, String character){
		if(day ==1) {
			if(character.equalsIgnoreCase("Yvonne")) {
				choice = 0;//function to prompt choice from player
				if(choice == 1){//yes russian
					gulagPoints++;
					return "russian_yes";
				}
				if(choice ==2) {//no russian
					return "russian_no";
				}
				if(choice ==3) {//ask why
					return "russian_why";
				}
			}
			if(character.equalsIgnoreCase("Jason")) {
				choice = 0;//function to prompt choice from player
				if(choice ==1) {//choice (a)$35
					//customerSatisfaction++
					gulagPoints++;
					return "upgrade_a";
				}
				if(choice ==2) {//choice (b)$55
					//customerSatisfaction--;
					gulagPoints++;
					return "upgrade_b";
				}
				if(choice ==3) {//choice (c)$40
					//customerSatisfaction++
					gulagPoints--;
					return "upgrade_c";
				}
				if(choice ==1) {//choice (d)$65
					//customerSatisfaction--;
					gulagPoints++;
					return "upgrade_d";
				}
			}
			if(character.equalsIgnoreCase("Tiff")) {
				choice = 0;//function to prompt choice from player
				if(choice == 1) {//yes
					gulagPoints--;
					//tiff points++
					tiff_icecream = true;
					return "iceCream_yes";
				}
				if(choice == 2) {//no
					gulagPoints++;
					//tiff points--
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
					return "dylan_yes";//filler prompt name
				}
				if(choice ==2) {//no discount
					gulagPoints--;
					return "weeee";//filler prompt name
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
					return "weeee";//filler prompt name
				}
				if(choice == 2) {//no email
					gulagPoints--;
					jason_mint = false;
					return "weeee";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("Patricia")) {
				choice = 0;//function to prompt choice from player
				if(choice ==1) {//yes, know her
					//customerSatisfaction++;
					return "weeee";//filler prompt name
				}
				if(choice ==2) {//no, do not know her
					//customerSatisfaction--;
					return "weeee";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("tiff")) {
				//effect point, does not call function to prompt choice.
				if(tiff_icecream == true) {
					return "weeee";//filler prompt name
				}
				else {
					return "weeee";//filler prompt name
					//slip note animation
				}
			}
		}
		if(day ==3) {
			if(character.equalsIgnoreCase("Yvonne")) {
				choice = 0;//function to prompt choice from player
				if(choice ==1) {//yes shampoo
					gulagPoints++;
					//customerSatisfaction++;
					return "weeee";//filler prompt name
				}
				if(choice ==2) {//no shampoo
					gulagPoints--;
					//customerSatisfaction--;
					return "weeee";//filler prompt name
				}
			}
			if(character.equalsIgnoreCase("Jason")) {
				//effect point
				if(jason_mint == true) {
					//customerSatisfaction++;
					return "weeee";//filler prompt name
					//tip +10
				}
				else {
					//customerSatisfaction--;
					return "weeee";//filler prompt name
					
				}
			}
			
		}
		if(day ==4) {
			if(character.equalsIgnoreCase("Tiff")) {
				choice = 0; //function to prompt choice
				if(choice==1) {//give pillow
					//customerSatisfaction++;
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
