package edu.psgv.sweng861;

import java.util.ArrayList;

public class WeightCalculator {
	private double oHPressMax;
	private double deadliftMax;
	private double benchMax;
	private double squatMax;
	
	
	public WeightCalculator(double oHPressMax, double deadliftMax, double benchMax, double squatMax) {
		super();
		this.oHPressMax = oHPressMax;
		this.deadliftMax = deadliftMax;
		this.benchMax = benchMax;
		this.squatMax = squatMax;
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
	
	public ArrayList<Double> calcWeekOne(double input) {
		ArrayList<Double> setWeights = new ArrayList<>();
		
		double set1 = input * .65;
		double set2 = input * .75;
		double set3 = input * .85;
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		
		return setWeights;
	}
	
	public ArrayList<Double> calcWeekTwo(double input){
		ArrayList<Double> setWeights = new ArrayList<>();
		
		double set1 = input * .7;
		double set2 = input * .8;
		double set3 = input * .9;
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		
		return setWeights;
	}
	
	public ArrayList<Double> calcWeekThree(double input){
		ArrayList<Double> setWeights = new ArrayList<>();
		
		double set1 = input * .78;
		double set2 = input * .85;
		double set3 = input * .95;
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		
		return setWeights;
	}
	public ArrayList<Double> calcWeekFour(double input){
		ArrayList<Double> setWeights = new ArrayList<>();
		
		double set1 = input * .4;
		double set2 = input * .5;
		double set3 = input * .6;
		setWeights.add(set1);
		setWeights.add(set2);
		setWeights.add(set3);
		
		
		return setWeights;
	}
	
}
