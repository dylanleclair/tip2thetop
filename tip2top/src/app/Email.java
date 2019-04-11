package app;

import java.io.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Email implements Serializable{

	private String subject;
	private String sender;
	private String message;
	
	public String getSubject() {
		return subject;
	}

	public String getSender() {
		return sender;
	}

	public String getMessage() {
		return message;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Email() {
		
	}
	
	public Email(String sender, String subject, String message) {
		this.sender = sender;
		this.subject = subject;
		this.message = message;
	}
	
	public void initializeEmails (ArrayList<Email> emailList) {
		emailList.add(new Email("DarkAssassin13", "Watch out!!", "Hey!! " + 
				"As you can see, there is no need for me to introduce myself to you because I don't have any business with you. My duty as I am mailing you now is just to ASSASSINATE YOU. If you don't comply, I have to do it as I have already been paid for that. But I have to ask you this question. What is the problem you have with your friend that made him to hire us to kill you?\n" + 
				"\n" + 
				"Now do you want to LIVE OR DIE? As someone has paid us to kill you. Get back to me now if you are ready to pay some fees to spare your life -- $3,800 is all you need to spend."));
		emailList.add(new Email("Dr. Bakare Tunde", "We need your space expertise.", "I am Dr. Bakare Tunde, the cousin of a Nigerian Astronaut, Air Force Major Abacha Tunde. He was the first African in space when he made a secret flight to the Salyut 6 space station in 1979. He was on a later Soviet spaceflight, Soyuz T-16Z, to the secret Soviet military space station Salyut 8T in 1989. He was stranded there in 1990 when the Soviet Union was dissolved. His other Soviet crew members returned to Earth on the Soyuz T-16Z, but his place was taken up by return cargo. There have been occasional supply flights to keep him going since that time. He is in good humor but wants to come home.\n" + 
				"\n" + 
				"In the 14 years since he has been on the station, he has accumulated flight pay and interest amounting to almost $15,000,000. This is held in a trust at the Lagos National Savings and Trust Association. If we can obtain access to this money, we can place a down payment with the Russian Space Authorities for a return flight to bring him back to Earth. I am told this will cost $3,000,000. In order to access his trust fund, we need your assistance."));
		
		emailList.add(new Email("Hello", "It's me", "I've been wondering if after all these years you'd like to meet"));

	}
	

	
	/**
	 * Returns the string of the message, in a format to be displayed by the screen.
	 */
	public String toString() {
		
		String messagePreview = message.substring(0, 20);
		messagePreview.replace("\n", " ").replace("\r", " ");

		
		String toReturn = "From: " + sender + " | " + subject + " | " + messagePreview + "...";
		
		return toReturn;
	}
}
