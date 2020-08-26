package com.revature.tier1;

public class NumberSumLength {

	/*come back to tthis*/
	public static boolean checkNumberPowerLength(long num) {
		String numString = Long.toString(num);
		System.out.println("numString " +numString);
		char[] numDigits = numString.toCharArray();
		int[] intDigits  = new int[numDigits.length];
		System.out.println("charrArray " + Character.toString(numDigits[numDigits.length -1]));
		for (int i = 0; i < numDigits.length; i++) {
			
			intDigits[i] = Integer.parseInt(Character.toString(numDigits[i]));
		}
		int powers = 0;
		long numSum = 0;
		for (int i = 0; i < intDigits.length; i++) {
			numSum += intDigits[i]^numDigits.length;
			powers += numDigits.length;
		}
		
		return (numSum==num);
	}
}
