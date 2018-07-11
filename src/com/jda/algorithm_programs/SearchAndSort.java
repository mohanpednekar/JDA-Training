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
			if (o1.getClass().toString().endsWith("String")) return ((String) o1).compareTo((String) o2);
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
	
	/**
	 * @param items
	 */
	private static <T> void insertionSort(ArrayList<T> items) {
		int n = items.size();
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (compare((T1) items.get(j - 1), (T1) items.get(j)) > 0) {
					Collections.swap(items, i, j);
				}
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
				for (int i = 0; i < n; i++) {
					strings.add(utility.readString());
				}
				utility.printLine("What do you want to search for?");
				String stringToSearch = utility.readString();
				programs.searchAndSort(strings, stringToSearch);
				break;
			case 'i':
				ArrayList<Integer> integers = new ArrayList<>();
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
		for (T item : items) {
			tree.insert(item);
		}
		
		return tree.has(itemToSearch);
	}

	/**
	 * @param items
	 */
	private <T> void bubbleSort(ArrayList<T> items) {
		int n = items.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				T1 input = (T1) items.get(i);
				T1 input2 = (T1) items.get(j);
				if (compare(input, input2) > 0) {
					Collections.swap(items, i, j);
				}
			}
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T1 t, T1 t2) {
		if (t.getClass().toString().endsWith("Integer")) return ((Integer) t).compareTo((Integer) t2);
		if (t.getClass().toString().endsWith("String")) return ((String) t).compareTo((String) t2);
		return 0;
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
		
		insertionSortWatcher.start();
		insertionSort(items);
		insertionSortWatcher.stop();
		
		bubbleSortWatcher.start();
		bubbleSort(items);
		bubbleSortWatcher.stop();
	}
	
}