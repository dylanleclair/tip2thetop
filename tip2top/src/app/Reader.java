package app;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * This class reads the xml files for the dialogue.
 * 
 * ex: getDialogue("Tiff", "iceCream");
 * 		- goes into Tiff xml file
 * 		- iceCream prompt is played
 * 
 * In order to play other snippets of text, change the second paramater.
 * 
 * ex: getDialogue("Tiff", "iceCream_yes");
 * 
 * This will play the dialogue if the user says yes to the choice within the iceCream prompt.
 * 
 * @author Yvonne
 */

public class Reader {
	
	/**
	 * Main reader class for xml files. 
	 * 
	 * @param npc - which npc the player is interacting with
	 * @param prompt - which prompt of text should be displayed
	 * @return dialogue - returns an arraylist of the dialogue that needs to be played
	 */
	public static ArrayList<String> getDialogue(String npc, String prompt) {
		ArrayList<String> dialogue = new ArrayList<String>();
	
		try {
			
			// builds the reader for the xml files according to the npc that was inputted
			File fXmlFile = new File("./resources/dialogue/" + npc + ".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			//gets the node list for the prompt
			NodeList nList = doc.getElementsByTagName(prompt);
			
			// gets the first item in the node list, aka prompt
			Node nNode = nList.item(0);
			
			Element eElement = (Element) nNode;		
			
			// Goes to the current event
			System.out.println("\nCurrent Event: " + nNode.getNodeName()); 	
			
			// gets the length of all prints in the prompt
			int printLength = eElement.getElementsByTagName("print").getLength();
			
			for (int i = 0; i < printLength; i++) {
				
			// increments through the print statements until there are none left
			String line = eElement.getElementsByTagName("print").item(i).getTextContent();
			System.out.println(eElement.getElementsByTagName("print").item(i).getTextContent());
			dialogue.add(line);
			}

		    } catch (Exception e) {
			e.printStackTrace();
		    }
		return dialogue;

		  }
}

