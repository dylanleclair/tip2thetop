package app;

import java.io.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Save {
    
	//TODO add key array to save
	private static ObservableList<String> names = FXCollections.observableArrayList();
	protected static File currentSave;
	protected static int goodPoints;
	protected static int badPoints;
	protected static ArrayList<NPC> characters;
	protected static ArrayList<Email> emails;
	protected static int[] keys;
	protected static int currentDay;
	protected static double currentMoney;
	protected static double bonus;
	protected static boolean tiff_icecream;
	protected static boolean jason_mints;
	protected static boolean has_toaster;
	
	// make an arraylist of files, iterate through saves directory and add each files to the arraylist
	// that way, it's easier to access diff saves / get number of saves / etc
	
	/**
	 * Loads the names of the save files into an ObservableList which displays
	 * this information on the Load Game interface. Is also referenced when loading saves
	 * and writing saves as it stores the names of them all.
	 */
	public static void initializeSaves() {
		names.clear();
		File directory = new File("./resources/saves");
		String[] filesInDir = directory.list();
		for (int i = 0; i < filesInDir.length; i++) {
			names.add(filesInDir[i]);
		}
	}
	
	public static ObservableList<String> getSaves() {
		return names;
	}
	
	/**
	 * This method is used to load a save file, putting a user into the game at the start of the day.
	 * @param name a String, the name of the file to be read from "saves" folder.
	 */
	@SuppressWarnings("unchecked")
	public static void loadSave(String name) {
		
		currentSave = new File("./resources/saves/" + name);

		
		
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(currentSave.getPath()));
			characters = (ArrayList<NPC>)reader.readObject();
			emails = (ArrayList<Email>)reader.readObject();
			keys = (int[])reader.readObject();
			currentDay = reader.readInt();
			currentMoney = reader.readDouble();
			bonus = reader.readDouble();
			tiff_icecream = reader.readBoolean();
			jason_mints = reader.readBoolean();
			has_toaster = reader.readBoolean();
			
			reader.close();
			
			
			Game.dayb.setAllCharacters(characters);
			Game.dayb.setEmail_list(emails);
			Game.dayb.setKeys(keys);
			Game.dayb.setDay(currentDay + 1);
			Game.dayb.getMoneyManager().setMoney(currentMoney);
			Game.dayb.getChoiceManager().setBonus(bonus);
			Game.dayb.getChoiceManager().setTiff_icecream(tiff_icecream);
			Game.dayb.getChoiceManager().setJason_mint(jason_mints);
			Game.dayb.getChoiceManager().setHas_toaster(has_toaster);
			
			// run the day
		
			
			//Game.dayb.buildAmigoScreen(Game.amigo, Game.window, Game.mainscene);

			
			//Game.dayb.loadDay(Game.window, Game.amigoscreen, Game.transitionsc);
			Game.dayb.manager.initializeCharacters(Game.dayb.getDay(), Game.dayb.getAllCharacters(), Game.dayb.getDailyCharacters());
			
			
			Game.dayb.getEmailsObservable().clear();
			for (Email email : emails) {
				Game.dayb.getEmailsObservable().add(email.toString());
			}
			Game.dayb.getBookings().clear();
			for (NPC character : characters ) {
				if (character.isCheckedIn()) {
					
					Game.dayb.getBookings().add(character.getBooking().toString());
					
				}
			}
			

			
			Game.window.setScene(Game.mainscene);
			Game.dayb.runDay(Game.window, Game.transitionsc);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(characters);
		System.out.println(emails);
		for(int k :keys)
			System.out.print(k+", ");
		System.out.println();
		System.out.println(currentDay);
		System.out.println(currentMoney);
		System.out.println(bonus);
		System.out.println(tiff_icecream);
		System.out.println(jason_mints);
		System.out.println(has_toaster);
		
		
		
		// here we would start transition into whatever day // start the gameplay
	}
	
	/**
	 * Returns the current save being run by the game. 
	 * @return a File, the save being used by the game.
	 */
	public static File getSave() { // may be needed to invoke saveWriter - keep for now
		return currentSave;
	}
	
	/**
	 * Generates a save according to given variables
	 * @param out an ObjectOutputStream which is used to write the necessary objects.
	 * @param allCharacters the ArrayList of NPCs to be saved
	 * @param emails the ArrayList of Email to be saved
	 * @param key the int[] which stores key data
	 * @param day an int, reflecting the last day completed.
	 * @param money an int, the money earned by the user / the player's score
	 * @param bonus an int, the amount of bonuses received
	 * @param tiff_icecream a boolean, saved to store choices made by user
	 * @param jason_mints a boolean, saved to store choices made by user
	 * @param has_toaster a boolean, saved to store choices made by user
	 */
    @SuppressWarnings("rawtypes")
	public static void generateSave (ObjectOutputStream out, ArrayList<NPC> allCharacters, ArrayList emails, int[] key, int day, double money, double bonus, boolean tiff_icecream, boolean jason_mints, boolean has_toaster) {
    	
    	try {
    		
			out.writeObject(allCharacters);
			out.writeObject(emails);
			out.writeObject(key);
			out.writeInt(day);
			out.writeDouble(money);
			out.writeDouble(bonus);
			out.writeBoolean(tiff_icecream);
			out.writeBoolean(jason_mints);
			out.writeBoolean(has_toaster);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	// creating two string methods for diff objects which hold variables to be stored could be v helpful
    	// other variables to be stored in save here
    	// we should draft up a consistent format before we implement this -- we don't want to have to change order. 
    }
    /**
	 * Is implemented in saveWriter.
	 * This method "prints" the necessary info for a save file into the save file.
	 * @param out a PrintWriter, which writes files as if you are printing output. 
	 */
    //initialization method
    public static void generateSave (ObjectOutputStream out) {
    	//initializing save file
    	try {
    		out.writeObject(new ArrayList<NPC>());
			out.writeObject(new ArrayList<Email>());
			out.writeObject(new int[0]);
			out.writeInt(1);
			out.writeDouble(0.0);
			out.writeDouble(0.0);
			out.writeBoolean(false);
			out.writeBoolean(false);
			out.writeBoolean(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Creates a new save file. This is only ever done at the start of a new game.
     * @param filename - a String, the name of the file to be generated as a .txt
     */
    public static void createSaveFile(String filename) {
    
    	filename = filename.replace(' ', '-');
    	File defaultSave = new File("./resources/saves/" + filename + ".data");
    	currentSave = defaultSave;
    	try {
    		boolean isCreated = defaultSave.createNewFile();
    		System.out.println("Was a new save created? " + isCreated);
    	} catch (Exception e) {
    	
    	}
    	saveWriter(defaultSave);
    }
    
    /**
     * Early implementation of a save feature for the game. 
     * To be used at the end of each day as part of the transitional screen.
     * @param saveFile a File, the file for the save information to be written to. (current save)
     */
    //initialization method
    public static void saveWriter(File saveFile) {
    	
    	try {
        	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile.getPath()));
        	generateSave(out);
        	out.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    /**
     * takes in data from the game to save to the file specified,
     * the order to enter the parameters is as listed in the parameters section below
     * @param saveFile a File, the file to save to
     * @param allCharacters an ArrayList, that stores every NPC in the game
     * @param emails an ArrayList, that stores all of the players received emails
     * @param key an Node array, that stores the state of the keys
     * @param day an int, the day the player in currently on
     * @param money a double, the money the player currently has
     * @param bonus a double, the raise added to the player's earnings
     * @param tiff_icecream a boolean, for story branching
     * @param jason_mints a boolean, for story branching
     * @param has_toaster a boolean, for story branching
     */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void saveWriter(File saveFile, ArrayList allCharacters, ArrayList emails, int[] key, int day, double money, double bonus, boolean tiff_icecream, boolean jason_mints, boolean has_toaster) {
	    	
	    	try {
	        	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile.getPath()));
	        	generateSave(out, allCharacters,  emails, key, day, money, bonus, tiff_icecream, jason_mints, has_toaster);
	        	out.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }
    
}
