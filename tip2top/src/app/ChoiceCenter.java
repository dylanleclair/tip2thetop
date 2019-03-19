package app;

public class ChoiceCenter extends DayBuilder {

	private int gulagPoints;
	private int daymistakes;
	private int totalmistakes;
	
	public String choicePoint(int day, String character){
		if(day ==1) {
			if(character.equalsIgnoreCase("Yvonne")) {
				int choice = 0;//function to prompt choice from player
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
				int choice = 0;
				if(choice ==1) {//choice (a)$35
					//customerSatification++
					gulagPoints++;
					return "upgrade_a";
				}
				if(choice ==2) {//choice (b)$55
					//customerSatification--;
					gulagPoints++;
					return "upgrade_b";
				}
				if(choice ==3) {//choice (c)$40
					//customerSatification++
					gulagPoints--;
					return "upgrade_c";
				}
				if(choice ==1) {//choice (d)$65
					//customerSatification--;
					gulagPoints++;
					return "upgrade_d";
				}
			}
			if(character.equalsIgnoreCase("Tiff")) {
				int choice = 0;
				if(choice == 1) {//yes
					gulagPoints--;
					//tiff points++
					return "iceCream_yes";
				}
				if(choice == 2) {//no
					gulagPoints++;
					//tiff points--
					return "iceCream_no";
				}
			}
			
			
		}
		
		return "";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
