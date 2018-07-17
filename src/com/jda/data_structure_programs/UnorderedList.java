package com.jda.data_structure_programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

interface List<T> {

  void add(T item);

  void remove(T item);

  boolean search(T item);

  boolean isEmpty();

  int size();

  void append(T item);

  int index(T item);

  void insert(int pos, T item);

  T pop();

  T pop(int pos);
}

public
class UnorderedList<T> implements List<T> {

  static String DATA_PATH = "C:/Users/1023345/IdeaProjects/JDA-Training/data";
  static String INPUT = DATA_PATH + "/input/unorderedLists.txt";
  static String OUTPUT = DATA_PATH + "/output/unorderedLists.txt";

  public static
  void main(String[] args) {
    String[] words;
    try {
      words = new String(Files.readAllBytes(Paths.get(INPUT))).split("\\s");
    } catch (IOException e) {
      System.out.println("Reading file failed");
      return;
    }
  }

  @Override
  public
  void add(T item) {

  }

  @Override
  public
  void remove(T item) {

  }

  @Override
  public
  boolean search(T item) {
    return false;
  }

  @Override
  public
  boolean isEmpty() {
    return false;
  }

  @Override
  public
  int size() {
    return 0;
  }

  @Override
  public
  void append(T item) {

  }

  @Override
  public
  int index(T item) {
    return 0;
  }

  @Override
  public
  void insert(int pos, T item) {

  }

  @Override
  public
  T pop() {
    return null;
  }

  @Override
  public
  T pop(int pos) {
    return null;
  }
}
