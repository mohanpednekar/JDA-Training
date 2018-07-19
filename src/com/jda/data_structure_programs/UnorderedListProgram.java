package com.jda.data_structure_programs;

import com.jda.utility.UnorderedList;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public
class UnorderedListProgram {

  static String DATA_PATH = "C:/Users/1023345/IdeaProjects/JDA-Training/data";
  static String INPUT = DATA_PATH + "/input/unorderedLists.txt";
  static String OUTPUT = DATA_PATH + "/output/unorderedLists.txt";

  public static
  void main(String[] args) {

    UnorderedList<String> unorderedList = readFromFile(INPUT);
    if (unorderedList == null) { return; }

    System.out.println(unorderedList);
    System.out.println("Which word do you want to search for?");
    Reader reader = new Utility().new Reader();
    String wordToSearch = reader.readString();

    boolean found = unorderedList.search(wordToSearch);
    if (found) { unorderedList.remove(wordToSearch); }
    else { unorderedList.add(wordToSearch); }

    unorderedList.printToFile(OUTPUT);
    System.out.println(readFromFile(OUTPUT));
  }

  private static
  UnorderedList<String> readFromFile(String filePath) {
    UnorderedList<String> unorderedList = new UnorderedList<>();
    String[] words = getWordsFromFile(filePath);
    if (words == null) { return null; }

    for (String word : words) {
      unorderedList.add(word);
    }
    return unorderedList;
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
