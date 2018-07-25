package com.jda.objectorientedprograms.classes;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.utility.Reader;

public class Stocks extends JsonArrayList<Stock> {

  public Stocks(Gson gson, String file) {
    super(gson, file);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Stock>>() {}.getType(), file);
  }

  public void show(String symbol) {
    data.forEach(stock -> {
      if (stock.getSymbol().equals(symbol)) {
        System.out.println(stock);
      }
    });
  }

  public Stock find(String symbol) {
    for (Stock stock : data) {
      if (stock.getSymbol().equals(symbol)) { return stock; }
    }
    return null;
  }
}