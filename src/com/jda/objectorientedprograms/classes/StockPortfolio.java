package com.jda.objectorientedprograms.classes;

import com.jda.objectorientedprograms.stockmarket.Stock;
import java.util.ArrayList;
import org.json.simple.JSONArray;

public class StockPortfolio {

  private ArrayList<Stock> stocks = new ArrayList<>();

  public StockPortfolio(JSONArray stockArray) {
    // for (Object stock : stockArray) { stocks.add(new Stock((JSONObject)
    // stock)); }
  }

  public double calculateValue() {
    return stocks.stream().mapToDouble(Stock::findValue).sum();
  }
}
