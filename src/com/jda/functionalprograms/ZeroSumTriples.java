package com.jda.functionalprograms;

import com.jda.utility.Utility;

public
class ZeroSumTriples {
	public static
	void main(String[] args) {
		Utility utility = new Utility();
		utility.printLine("How many integers do you want to read?");
		int n = utility.readInteger();
		utility.printLine("Enter " + n + " integers");
		int[] array = utility.readIntegerArray(n);
		int count = findZeroSumTriples(array);
		utility.printLine("There are " + count + " zero sum triples");

	}

	private static
	int findZeroSumTriples(int[] array) {
		int n = array.length;
		int count = 0;
		for (int i = 0; i < n - 2; i++)
			for (int j = i + 1; j < n - 1; j++)
				for (int k = j + 1; k < n; k++)
					if (array[i] + array[j] + array[k] == 0) {
						count++;
						System.out.println(array[i] + " " + array[j] + " " + array[k]);
					}
		return count;
	}
}
