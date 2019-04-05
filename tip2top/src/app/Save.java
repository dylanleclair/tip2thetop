package app;

import java.io.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Save {
    
	private static ObservableList<String> names = FXCollections.observableArrayList();
	protected static File currentSave;
	protected static int dayOn;
	protected static int goodPoints;
	protected static int badPoints;
	
	// make an arraylist of files, iterate through saves directory and add each files to the arraylist
	// that way, it's easier to access diff saves / get number of saves / etc
	
	/**
	 * Loads the names of the save files into an ObservableList which displays
	 * this information on the Load Game interface. Is also referenced when loading saves
	 * and writing saves as it stores the names of them all.
	 */
	public static void initializeSaves() {
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
	public static void loadSave(String name) {
		
		currentSave = new File("./resources/saves/" + name);
		
		
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(currentSave.getPath()));
			ArrayList<NPC> characters = (ArrayList<NPC>)reader.readObject();
			ArrayList<Email> emails = (ArrayList<Email>)reader.readObject();
			int currentDay = reader.readInt();
			double currentMoney = reader.readDouble();
			boolean tiff_icecream = reader.readBoolean();
			boolean jason_mints = reader.readBoolean();
			boolean has_toaster = reader.readBoolean();
			// eventually this will be something like:
			// globalVariable/class.setVariable() with type cast from string
			// will be diff for each line tho, so looping will be different.. maybe use an array to simplify / shorten
			reader.close();
			for(int x = 0; x< characters.size(); x++) {
				System.out.println(characters.get(x));
			}
			
		} catch (Exception e) {
			
		}
		
		/*
		dayOn = Integer.parseInt(lines.get(0));
		goodPoints = Integer.parseInt(lines.get(1));
		badPoints = Integer.parseInt(lines.get(2));
		
		if(lines.size()>0 && lines.size() <4) {
			dayOn = Integer.parseInt(lines.get(0));
			goodPoints = Integer.parseInt(lines.get(1));
			badPoints = Integer.parseInt(lines.get(2));
		}
		*/
		//System.out.println(dayOn +", "+ goodPoints +", "+ badPoints);
		// here we would start transition into whatever day // start the gameplay
	}
	
	//not being used, may be able to delete
	public static File getSave() { // may be needed to invoke saveWriter - keep for now
		return currentSave;
	}
	
	
    public static void generateSave (ObjectOutputStream out, ArrayList<NPC> allCharacters, ArrayList emails, int day, double money, boolean tiff_icecream, boolean jason_mints, boolean has_toaster) {
    	
    	try {
    		
			out.writeObject(allCharacters);
			out.writeObject(emails);
			out.writeInt(day);
			out.writeDouble(money);
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
    	ArrayList<NPC> test = new ArrayList<NPC>(2);
    	test.add(new NPC("Tiff"));
    	test.add(new NPC("test"));
    	try {
    		out.writeInt(1);
    		out.writeInt(5);
			out.writeObject(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
    
	 public static void saveWriter(File saveFile, ArrayList allCharacters, ArrayList emails, int day, double money, boolean tiff_icecream, boolean jason_mints, boolean has_toaster) {
	    	
	    	try {
	        	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile.getPath()));
	        	generateSave(out, allCharacters,  emails, day, money, tiff_icecream, jason_mints, has_toaster);
	        	out.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }
    
}
