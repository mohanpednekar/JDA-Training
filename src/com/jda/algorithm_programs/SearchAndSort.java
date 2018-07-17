/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 11, 2018
 *******************************************************************/
package com.jda.algorithm_programs;

import com.jda.utility.Util.Stopwatch;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public
class SearchAndSort<T1> implements Comparator<T1> {

  public static
  void main(String[] args) {
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
   */
  private
  <T> void searchAndSort(ArrayList<T> items, T itemToSearch) {

    Watcher.BINARY.start();
    boolean found = binarySearch(items, itemToSearch);
    Watcher.BINARY.stop();
    System.out.println("found = " + found);

    Watcher.INSERTION.start();
    ArrayList<T> insertionSorted = insertionSort(items);
    Watcher.INSERTION.stop();
    System.out.println(insertionSorted);

    Watcher.BUBBLE.start();
    ArrayList<T> bubbleSorted = Sorting.bubbleSort(items);
    Watcher.BUBBLE.stop();
    System.out.println(bubbleSorted);

    HashMap<Watcher, Long> watchersMap = new HashMap<>();

    for (Watcher watcher : Watcher.values()) {
      System.out.println(watcher.resultString());
      watchersMap.put(watcher, watcher.elapsedTimeNanos());
    }
  }

  /**
   * @param items
   * @param itemToSearch
   * @return
   */
  private
  <T> boolean binarySearch(ArrayList<T> items, T itemToSearch) {
    BST tree = new BST(items.get(0));
    items.forEach(tree::insert);
    return tree.has(itemToSearch);
  }

  /**
   * @param items
   * @return
   */
  private
  <T> ArrayList<T> insertionSort(ArrayList<T> items) {
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
  }  /*
   * (non-Javadoc)
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */

  @Override
  public
  int compare(T1 t, T1 t2) {
    if (t.getClass().toString().endsWith("Integer")) {
      return ((Integer) t).compareTo((Integer) t2);
    }
    if (t.getClass().toString().endsWith("String")) {
      return ((String) t).compareToIgnoreCase((String) t2);
    }
    return 0;
  }

  enum Watcher {
    BINARY("Binary search"), INSERTION("Insertion sort"), BUBBLE("Bubble sort");
    Stopwatch stopwatch = new Stopwatch();
    String watcherName;

    Watcher(String str) {
      watcherName = str;
    }

    public
    void start() {
      stopwatch.start();
    }

    public
    void stop() {
      stopwatch.stop();
    }

    public
    long elapsedTimeNanos() {
      return stopwatch.elapsedTimeNanos();
    }

    public
    String resultString() {
      return watcherName + " took " + elapsedTimeSeconds() + " seconds";
    }

    public
    double elapsedTimeSeconds() {
      return stopwatch.elapsedTimeSeconds();
    }
  }

  public
  class BST<T> implements Comparator<T> {

    T value;
    BST left;
    BST right;

    BST(T value) {
      this.value = value;
    }

    /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public
    int compare(T o1, T o2) {
      if (o1.getClass().toString().endsWith("Integer")) {
        return ((Integer) o1).compareTo((Integer) o2);
      }
      if (o1.getClass().toString().endsWith("String")) {
        return ((String) o1).compareToIgnoreCase((String) o2);
      }
      return 0;
    }

    public
    boolean has(T value) {
      if (compare(value, this.value) == 0) {
        return true;
      }
      if (compare(value, this.value) < 0 && null != left) {
        return left.has(value);
      }
      if (compare(value, this.value) > 0 && null != right) {
        return right.has(value);
      }
      return false;
    }

    public
    void insert(T value) {
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


}
