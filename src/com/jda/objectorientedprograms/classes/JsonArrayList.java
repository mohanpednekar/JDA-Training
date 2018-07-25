package com.jda.objectorientedprograms.classes;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.jda.utility.Printer;

public class JsonArrayList<T> {
  Gson                gson;
  String              file;
  public ArrayList<T> data;

  public JsonArrayList(Gson gson, String file) {
    this.gson = gson;
    this.file = file;
  }

  public void printToFile() {
    Printer.printToFile(file, gson.toJson(data));
  }

  public void showAll() {
    data.forEach(System.out::println);
  }
}
