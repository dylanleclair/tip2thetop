package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Save {
    
	private static ObservableList<String> names = FXCollections.observableArrayList();
	protected static File currentSave;
	
	// make an arraylist of files, iterate through saves directory and add each files to the arraylist
	// that way, it's easier to access diff saves / get number of saves / etc
	
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
	
	public static void loadSave(String name) {
		
		System.out.println(name);
		currentSave = new File("./resources/saves/" + name);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(currentSave.getPath()));
			String line = reader.readLine();			
			// eventually this will be something like:
			// globalVariable/class.setVariable() with type cast from string
			// will be diff for each line tho, so looping will be different.. maybe use an array to simplify / shorten
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			
		}

	}
	
	// do we even need these?
	// if we set the load save button to just load a save, then we shouldn't. I'll keep em for now tho
	public static void selectSave(int index) {
		// needs to be implemented on loading screen
		currentSave = new File("./resources/saves/" + names.get(index));
	}
	
	public static File getSave() {
		return currentSave;
	}
	
    public static void generateSave (PrintWriter out) {
    	out.println("hello");
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

    }
    
    /**
     * Early implementation of a save feature for the game. 
     * To be used at the end of each day as part of the transitional screen.
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
