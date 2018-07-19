package com.jda.data_structure_programs;

import com.jda.utility.OrderedList;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public
class OrderedListProgram {

  static String DATA_PATH = "C:/Users/1023345/IdeaProjects/JDA-Training/data";
  static String INPUT = DATA_PATH + "/input/orderedLists.txt";
  static String OUTPUT = DATA_PATH + "/output/orderedLists.txt";

  public static
  void main(String[] args) {
    OrderedList<Integer> orderedList = readFromFile(INPUT);
    if (orderedList == null) { return; }

    System.out.println(orderedList);
    System.out.println("Which word do you want to search for?");
    Reader reader = new Utility().new Reader();
    Integer numberToSearch = reader.readInteger();

    boolean found = orderedList.search(numberToSearch);
    if (found) { orderedList.remove(numberToSearch); }
    else { orderedList.add(numberToSearch); }

    orderedList.printToFile(OUTPUT);
    System.out.println(readFromFile(OUTPUT));
  }

  private static
  OrderedList<Integer> readFromFile(String filePath) {
    OrderedList<Integer> orderedList = new OrderedList<>();
    String[] words = getWordsFromFile(filePath);
    if (words == null) { return null; }
    for (String word : words) {
      orderedList.add(Integer.parseInt(word));
    }
    return orderedList;
  }

  private static
  String[] getWordsFromFile(String filePath) {
    String[] words;
    try {
      words = new String(Files.readAllBytes(Paths.get(filePath))).split("\\s");
    } catch (IOException e) {
      System.out.println("Reading file failed");
      return null;
    }
    return words;
  }
}
