package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(currentSave.getPath()));
			String line = reader.readLine();			
			// eventually this will be something like:
			// globalVariable/class.setVariable() with type cast from string
			// will be diff for each line tho, so looping will be different.. maybe use an array to simplify / shorten
			while (line != null) {
				System.out.println(line);
				lines.add(line);
				line = reader.readLine();
				
			}
			reader.close();
		} catch (Exception e) {
			
		}
		dayOn = Integer.parseInt(lines.get(0));
		goodPoints = Integer.parseInt(lines.get(1));
		badPoints = Integer.parseInt(lines.get(2));
		
		if(lines.size()>0 && lines.size() <4) {
			dayOn = Integer.parseInt(lines.get(0));
			goodPoints = Integer.parseInt(lines.get(1));
			badPoints = Integer.parseInt(lines.get(2));
		}
		//System.out.println(dayOn +", "+ goodPoints +", "+ badPoints);
		// here we would start transition into whatever day // start the gameplay
	}
	
	//not being used, may be able to delete
	public static File getSave() { // may be needed to invoke saveWriter - keep for now
		return currentSave;
	}
	
	/**
	 * Is implemented in saveWriter.
	 * This method "prints" the necessary info for a save file into the save file.
	 * @param out a PrintWriter, which writes files as if you are printing output. 
	 */
    public static void generateSave (PrintWriter out) {
    	out.println("1");//Class.getDay() the date the players currently on
    	out.println("2");//Class.getGoodPoints player good points
    	out.println("5");//Class.getBadPOints player bad points
    	// creating two string methods for diff objects which hold variables to be stored could be v helpful
    	// other variables to be stored in save here
    	// we should draft up a consistent format before we implement this -- we don't want to have to change order. 
    }
    
    /**
     * Creates a new save file. This is only ever done at the start of a new game.
     * @param filename - a String, the name of the file to be generated as a .txt
     */
    public static void createSaveFile(String filename) {
    
    	filename = filename.replace(' ', '-');
    	File defaultSave = new File("./resources/saves/" + filename + ".txt");
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
    public static void saveWriter(File saveFile) {
    	
    	try {
        	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(saveFile.getPath())));
        	generateSave(out);
        	out.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
}
