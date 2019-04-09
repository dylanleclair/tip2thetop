package app;

import java.lang.Math;

public class Money extends ChoiceCenter{
	

	private double money; // the current amount of money player has
	
	public double getMoney() {
		return this.money;
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
	public void calc(int dm, int cs, int gulag, double tips, double bonus, double spendings){
		double addon = 0.0;
		double penalty = 0.0;
		double basic = 100.0+bonus;
		double daily = basic;
		//calcualtions
		penalty = basic - basic*(1.0-(0.15*dm+0.01*gulag));
		if(cs <0) {
			penalty-=Math.round((basic*(1.0+(0.02*cs))-basic)*1000.0)/1000.0;
		}
		daily-=penalty;
		addon = Math.round((daily*(1.0+(0.02*cs))-daily)*1000.0)/1000.0;
		if(cs>=0) {
			daily+=addon;
		}
		else {
			addon = 0.00;
		}
		daily+=tips;
		daily-=70.0+spendings;
		daily = Math.round(daily*1000.0)/1000.0;
		money+=daily;
		
		//print statements
		System.out.println("Basic payment: \t\t$"+basic);
		System.out.println("Penalty: \t\t-$"+penalty);
		System.out.println("Bonuses: \t\t+$"+addon);
		System.out.println("Tips: \t\t\t+$"+tips);
		System.out.println("Daily Spendings: \t-$70.00");
		if(spendings>0) {
			System.out.println(" \t\t\t-$"+spendings);
		}
		System.out.println("--------------------------");
		System.out.println("Sub Total: \t$"+daily);
		System.out.println("Total: \t\t$"+money);

		
		// GUI implementation
		
		
	}
	
	
	public static void main(String[] args) {
		//testing code
		
		Money test = new Money();
		
		test.money = 100.0;
		test.calc(1, 2, 0, 10.0, 0, 29.99);
		System.out.println();
		test.calc(0, -2, 2, 0, 0, 0);

	}

}