package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class Distance {
	private static double distanceFromOrigin(double x, double y) {
		return Utility.euclideanDistance(x, y, 0.0, 0.0);
	}
	
	public static void main(String[] args) {
		Utility utility = new Utility();
		if (!utility.checkCmdArgs(args, 2)) return;
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		utility.printLine("The distance of (" + x + "," + y + ") from origin is " + distanceFromOrigin(x, y));
		
	}
}
