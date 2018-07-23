package com.jda.objectorientedprograms;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public
class InventoryManagement {

  static String DATA_PATH = "C:/Users/1023345/IdeaProjects/JDA-Training/data";
  static String INPUT = DATA_PATH + "/input/inventory.json";

  public static
  void main(String[] args) {
    JSONParser parser = new JSONParser();
    try {

      JSONObject inventory = (JSONObject) parser.parse(INPUT);
    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }
}
