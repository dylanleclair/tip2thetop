package app;

import java.lang.Math;

public class Money extends ChoiceCenter{
	

	private double money; // the current amount of money player has
	
	// Setters and getters
	
	public double getMoney() {
		return this.money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	/**
	 * @param dm an int, the number of daily mistakes
	 * @param cs an int, customer satisfaction points
	 * @param gulag an int, gulag points
	 * @param tips a double, the tips for the day(selling stuff money goes here)
	 * @param bonus a double, the bonus added to to the basic payment
	 * @param spendings a double, the spendings you do during the day, ie. buying the toaster
	 */
	/*
	 * the sysout print statements can be replaced with display methods onto gui
	 */
	public double[] calc(int dm, int cs, int gulag, double tips, double bonus, double spendings){
		double addon = 0.0;
		double penalty = 0.0;
		double basic = 100.0+bonus;
		double daily = basic;
		//calcualtions
		if(gulag >0) {
			penalty = basic - basic*(1.0-(0.14*(dm+gulag)));
		}
		else {
			penalty = basic - basic*(1.0-(0.14*dm));
		}
		if(cs <0) {
			penalty-=Math.round((basic*(1.0+(0.02*cs))-basic)*1000.00)/1000.00;
		}
		penalty = Math.round((penalty)*1000.00)/1000.00;
		daily-=penalty;
		addon = Math.round((daily*(1.0+(0.02*cs))-daily)*1000.00)/1000.00;
		if(cs>=0) {
			daily+=addon;
		}
		
		else {
			addon = 0.00;
		}
		daily+=tips;
		daily-=70.0+spendings;
		daily = Math.round(daily*1000.00)/1000.00;
		money+=daily;
		money = Math.round(money*1000.00)/1000.00;
		
		double[] toReturn = {basic, penalty ,addon ,tips , -70.00-spendings, daily, money};
		//print statements
		System.out.println("Basic payment: \t\t$"+basic);
		System.out.println("Penalty: \t\t-$"+penalty);
		System.out.println("Bonuses: \t\t+$"+addon);
		System.out.println("Tips: \t\t\t+$"+tips);
		System.out.println("Daily Spendings: \t-$70.0");
		if(spendings>0) {
			System.out.println(" \t\t\t-$"+spendings);
		}
		System.out.println("--------------------------");
		System.out.println("Sub Total: \t$"+daily);
		System.out.println("Total: \t\t$"+money);

		
		// GUI implementation
		return toReturn;
		
	}


}