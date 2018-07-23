package com.jda.objectorientedprograms;

import com.jda.objectorientedprograms.classes.Product;
import com.jda.utility.Constants;
import com.jda.utility.Reader;
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
  private static String OUTPUT = Constants.OUTPUT_PATH + "inventory.json";

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
      char choice;
      updateJson(inventoryMap);
      Reader reader = new Reader();
      do {
        choice = reader.readString().charAt(0);
        switch (choice) {
          case 'a':
            addProductTo(inventoryMap);
            break;
          case 'r':
            removeProductFrom(inventoryMap);
            break;
          default:
            choice = 'q';
        }
      } while (choice != 'q');
    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }

  private static
  void removeProductFrom(HashMap<String, ArrayList<Product>> inventoryMap) {
    System.out.println("What do you want to remove from inventory");
    Reader reader = new Reader();
    String item = reader.readLine();
    ArrayList<Product> itemToRemove = inventoryMap.get(item);
    if (itemToRemove == null) {
      System.out.println("This commodity doesn't exist");
      return;
    }
    System.out.println("Which one?");
    String productName = reader.readLine();
    Product productToRemove = null;
    for (Product product : itemToRemove) {
      if (product.getName().equals(productName)) { productToRemove = product; }
    }
    if (productToRemove == null) { System.out.println("This item doesn't exist"); }
    else { itemToRemove.remove(productToRemove); }
    updateJson(inventoryMap);
  }

  private static
  void addProductTo(HashMap<String, ArrayList<Product>> inventoryMap) {
    System.out.println("What do you want to add to inventory");
    Reader reader = new Reader();
    String item = reader.readLine();
    inventoryMap.putIfAbsent(item, new ArrayList<>());
    inventoryMap.get(item).add(new Product(reader));
    updateJson(inventoryMap);
  }

  private static
  void updateJson(HashMap<String, ArrayList<Product>> inventoryMap) {
    StringBuilder jsonString = createJsonString(inventoryMap);
    Util.printToFile(OUTPUT, jsonString);
    for (String key : inventoryMap.keySet()) {
      System.out.println(key + " is worth " + calculateValueOf(inventoryMap.get(key)));
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
      jsonString.append("\"").append(key).append("\" : ")
          .append(Util.createJSONFromArray(inventoryMap.get(key)));
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
