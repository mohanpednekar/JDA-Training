package com.jda.objectorientedprograms;

import com.jda.objectorientedprograms.classes.Product;
import com.jda.utility.Constants;
import com.jda.utility.Util;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public
class InventoryManagement {

  private static String INPUT = Constants.INPUT_PATH + "inventory.json";

  public static
  void main(String[] args) {
    JSONParser parser = new JSONParser();
    try {

      JSONObject inventoryObj = (JSONObject) parser.parse(new FileReader(INPUT));
      String[] inventories = {"rice", "wheat", "pulses"};
      HashMap<String, ArrayList<Product>> inventoryMap = new HashMap<>();
      for (String inventory : inventories) {
        inventoryMap.put(inventory, readJsonArray(inventoryObj, inventory));
      }
      StringBuilder jsonString = createJsonString(inventoryMap);
      System.out.println(jsonString);
      for (String key : inventoryMap.keySet()) {
        System.out.println(key + " is worth " + calculateValueOf(inventoryMap.get(key)));
      }
    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }

  private static
  ArrayList<Product> readJsonArray(JSONObject inventory, String itemName) {
    ArrayList<Product> items = new ArrayList<>();
    for (Object anInventory : (JSONArray) inventory.get(itemName)) {
      items.add(new Product((JSONObject) anInventory));
    }
    return items;
  }

  private static
  StringBuilder createJsonString(HashMap<String, ArrayList<Product>> inventoryMap) {
    StringBuilder jsonString = new StringBuilder();
    jsonString.append("{");
    Iterator iterator = inventoryMap.keySet().iterator();
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      jsonString.append(key).append(": ").append(Util.createJSONFromArray(inventoryMap.get(key)));
      if (iterator.hasNext()) { jsonString.append(", "); }
    }
    jsonString.append("}");
    return jsonString;
  }

  private static
  long calculateValueOf(ArrayList<Product> products) {
    return products.stream().mapToLong(Product::findValue).sum();
  }
}
