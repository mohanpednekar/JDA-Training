package com.jda.programs.oop.stockmarket;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.util.Reader;

public class Stocks extends JsonArrayList<Stock, String> {
  
  Stocks(Gson gson, String file) {
    super(gson, file);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Stock>>() {}.getType(), file);
  }
  
  Stocks() {}
  
  boolean have(double shares, Stock stockToSell) {
    for (Stock stock : data) {
      if (stock.is(stockToSell.getId()) && stock.has(shares)) { return true; }
    }
    return false;
  }
  
  public boolean add(Stock stock) {
    if (find(stock.getId()) == null) {
      data.add(stock);
      return true;
    } else {
      System.out.println("Stock symbol already exists");
    }
    return false;
  }
  
  public void remove(Stock stock) {
    data.remove(stock);
  }
  
  boolean soldAll(Stock stock) {
    return data.stream().anyMatch(holding -> holding.is(stock.getId()) && holding.reduce(stock));
  }
  
  public void purchase(Stock stock) {
    if (find(stock.getId()) == null) {
      data.add(stock);
    } else {
      find(stock.getId()).increase(stock.findValue());
    }
  }
}
