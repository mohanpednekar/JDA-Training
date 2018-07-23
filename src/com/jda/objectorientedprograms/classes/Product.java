package com.jda.objectorientedprograms.classes;

import org.json.simple.JSONObject;

public
class Product {

  private String name;
  private long weight;
  private long priceperkg;

  public
  Product(JSONObject jsonObject) {
    name = (String) jsonObject.get("name");
    weight = (long) jsonObject.get("weight");
    priceperkg = (long) jsonObject.get("priceperkg");
  }

  @Override
  public
  String toString() {
    return "{" + "name : \"" + name + '\"' + ", weight : " + weight + ", priceperkg : " + priceperkg
        + '}';
  }

  public
  long findValue() {
    return weight * priceperkg;
  }
}
