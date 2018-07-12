/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 11, 2018
 *******************************************************************/
package com.jda.algorithm_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.jda.utility.Util;
import com.jda.utility.Util.Stopwatch;
import com.jda.utility.Utility;

public class SearchAndSort<T1> implements Comparator<T1> {

	public class BST<T> implements Comparator<T> {
		T	value;
		BST	left;
		BST	right;

		BST(T value) {
			this.value = value;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(T o1, T o2) {
			if (o1.getClass().toString().endsWith("Integer")) return ((Integer) o1).compareTo((Integer) o2);
			if (o1.getClass().toString().endsWith("String")) return ((String) o1).compareToIgnoreCase((String) o2);
			return 0;
		}
		
		public boolean has(T value) {
			if (compare(value, this.value) == 0) return true;
			if (compare(value, this.value) < 0 && null != left) return left.has(value);
			if (compare(value, this.value) > 0 && null != right) return right.has(value);
			return false;
		}

		public void insert(T value) {
			if (compare(value, this.value) <= 0) {
				if (null == left) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else if (null == right) {
				right = new BST(value);
			} else {
				right.insert(value);
			}
		}
	}

	public static void main(String[] args) {
		Utility utility = new Utility();
		SearchAndSort programs = new SearchAndSort<>();
		utility.printLine("What do you want to enter?");
		utility.printLine("s : Strings \t i : Integers");
		char ch = utility.readString().toLowerCase().charAt(0);
		utility.printLine("How many of them?");
		int n = utility.readInteger();

		switch (ch) {
			case 's':
				ArrayList<String> strings = new ArrayList<>();
				utility.printLine("Enter " + n + " strings");
				
				for (int i = 0; i < n; i++) {
					strings.add(utility.readString());
				}
				utility.printLine("What do you want to search for?");
				String stringToSearch = utility.readString();
				programs.searchAndSort(strings, stringToSearch);
				break;
			case 'i':
				ArrayList<Integer> integers = new ArrayList<>();
				utility.printLine("Enter " + n + " integers");
				for (int i = 0; i < n; i++) {
					integers.add(utility.readInteger());
				}
				utility.printLine("What do you want to search for?");
				Integer integerToSearch = utility.readInteger();
				programs.searchAndSort(integers, integerToSearch);
				break;
			default:
		}
	}

	/**
	 * @param items
	 * @param itemToSearch
	 * @return
	 */
	private <T> boolean binarySearch(ArrayList<T> items, T itemToSearch) {
		BST tree = new BST(items.get(0));
		items.forEach(tree::insert);
		return tree.has(itemToSearch);
	}
	
	// /**
	// * @param items
	// * @return
	// */
	// private <T> ArrayList<T> bubbleSort(ArrayList<T> items) {
	// ArrayList<T1> sorted = (ArrayList<T1>) items;
	// int n = sorted.size();
	// for (int i = 0; i < n - 1; i++) {
	// for (int j = 0; j < n - 1; j++) {
	// T1 input = sorted.get(j);
	// T1 input2 = sorted.get(j + 1);
	// if (compare(input, input2) > 0) {
	// Collections.swap(sorted, j, j + 1);
	// }
	// }
	// }
	// return (ArrayList<T>) sorted;
	// }
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T1 t, T1 t2) {
		if (t.getClass().toString().endsWith("Integer")) return ((Integer) t).compareTo((Integer) t2);
		if (t.getClass().toString().endsWith("String")) return ((String) t).compareToIgnoreCase((String) t2);
		return 0;
	}
	
	/**
	 * @param items
	 * @return
	 */
	private <T> ArrayList<T> insertionSort(ArrayList<T> items) {
		int n = items.size();
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				T1 i1 = (T1) items.get(j - 1);
				T1 i2 = (T1) items.get(j);
				if (compare(i1, i2) > 0) {
					Collections.swap(items, j - 1, j);
				}
			}
		}
		return items;
	}

	/**
	 * @param items
	 */
	private <T> void searchAndSort(ArrayList<T> items, T itemToSearch) {
		Stopwatch binarySearchWatcher = new Stopwatch();
		Stopwatch insertionSortWatcher = new Stopwatch();
		Stopwatch bubbleSortWatcher = new Stopwatch();

		binarySearchWatcher.start();
		boolean found = binarySearch(items, itemToSearch);
		binarySearchWatcher.stop();
		System.out.println("found = " + found);
		System.out.println("Binary search took " + binarySearchWatcher.elapsedTimeSeconds() + " s");

		insertionSortWatcher.start();
		ArrayList<T> insertionSorted = insertionSort(items);
		insertionSortWatcher.stop();
		System.out.println(insertionSorted);
		System.out.println("Insertion sort took " + insertionSortWatcher.elapsedTimeSeconds() + " s");

		bubbleSortWatcher.start();
		ArrayList<T> bubbleSorted = Util.bubbleSort(items);
		bubbleSortWatcher.stop();
		System.out.println(bubbleSorted);
		System.out.println("Bubble sort took " + bubbleSortWatcher.elapsedTimeSeconds() + " s");

	}

}
