package com.jda.objectorientedprograms.classes;

import org.json.simple.JSONObject;

public
class Stock {

  private String name;
  private long number;
  private double price;

  public
  Stock(JSONObject jsonObject) {
    name = (String) jsonObject.get("name");
    number = (long) jsonObject.get("number");
    price = (double) jsonObject.get("price");
  }

  public
  double findValue() {
    double value = number * price;
    System.out.println("Value of " + name + " is " + value);
    return value;
  }
}
