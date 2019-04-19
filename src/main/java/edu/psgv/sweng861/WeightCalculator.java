package edu.psgv.sweng861;

import java.util.ArrayList;

public class WeightCalculator {
	private double oHPressMax;
	private double deadliftMax;
	private double benchMax;
	private double squatMax;
	
	
	public WeightCalculator(double oHPressMax, double deadliftMax, double benchMax, double squatMax) {
		super();
		//all calculations are based off 90% of users entered 1 rep max
		this.oHPressMax = oHPressMax * .9;
		this.deadliftMax = deadliftMax * .9;
		this.benchMax = benchMax * .9;
		this.squatMax = squatMax * .9;
	}
	
	public WeightCalculator() {};
	
	public double getoHPressMax() {
		return oHPressMax;
	}
	public void setoHPressMax(double oHPressMax) {
		this.oHPressMax = oHPressMax;
	}
	public double getDeadliftMax() {
		return deadliftMax;
	}
	public void setDeadliftMax(double deadliftMax) {
		this.deadliftMax = deadliftMax;
	}
	public double getBenchMax() {
		return benchMax;
	}
	public void setBenchMax(double benchMax) {
		this.benchMax = benchMax;
	}
	public double getSquatMax() {
		return squatMax;
	}
	public void setSquatMax(double squatMax) {
		this.squatMax = squatMax;
	}
	
	public ArrayList<Integer> calcWeekOne(double input) {
		ArrayList<Integer> setWeights = new ArrayList<>();
		
		int set1 = (int)Math.round(input * .65);
		int set2 = (int)Math.round(input * .75);
		int set3 = (int)Math.round(input * .85);
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		return setWeights;
	}
	
	public ArrayList<Integer> calcWeekTwo(double input){
		ArrayList<Integer> setWeights = new ArrayList<>();
		
		int set1 = (int)Math.round(input * .7);
		int set2 = (int)Math.round(input * .8);
		int set3 = (int)Math.round(input * .9);
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		return setWeights;
	}
	
	public ArrayList<Integer> calcWeekThree(double input){
		ArrayList<Integer> setWeights = new ArrayList<>();
		
		int set1 = (int)Math.round(input * .78);
		int set2 = (int)Math.round(input * .85);
		int set3 = (int)Math.round(input * .95);
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		return setWeights;
	}
	public ArrayList<Integer> calcWeekFour(double input){
		ArrayList<Integer> setWeights = new ArrayList<>();
		
		int set1 = (int)Math.round(input * .4);
		int set2 = (int)Math.round(input * .5);
		int set3 = (int)Math.round(input * .6);
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		return setWeights;
	}
}
