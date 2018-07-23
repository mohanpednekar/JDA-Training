package com.jda.datastructureprograms;

import com.jda.datastructures.OrderedList;
import com.jda.utility.Utility;
import java.util.HashMap;

public
class NumberSlot {

  static String DATA_PATH = "C:/Users/1023345/IdeaProjects/JDA-Training/data";
  static String INPUT = DATA_PATH + "/input/numberSlots.txt";
  static String OUTPUT = DATA_PATH + "/output/numberSlots.txt";

  public static
  void main(String[] args) {
    System.out.println("Your hash table looks like this");
    HashMap<Integer, OrderedList<Integer>> map = createMap(INPUT, 11);
    System.out.println(map);

    //TODO input
  }

  private static
  HashMap<Integer, OrderedList<Integer>> createMap(String inputFilePath, int nSlots) {
    HashMap<Integer, OrderedList<Integer>> map = new HashMap<>();
    String[] words = Utility.getWordsFromFile(inputFilePath);
    for (String word : words) {
      Integer number = Integer.parseInt(word);
      map.putIfAbsent(number % nSlots, new OrderedList<>());
      map.get(number % nSlots).add(number);
    }
    return map;
  }
}
