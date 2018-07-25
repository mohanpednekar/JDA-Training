package com.jda.objectorientedprograms.classes;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.utility.Reader;

public class Trades extends JsonArrayList<Trade> {
  long ref;
  
  public Trades(Gson gson, String file) {
    super(gson, file);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Trade>>() {}.getType(), file);
    ref = findHighestRef();
  }
  
  private long findHighestRef() {
    long maxRef = 0;
    for (Trade trade : data) {
      if (trade.getRef() > maxRef) {
        maxRef = trade.getRef();
      }
    }
    return maxRef;
  }
  
  public void show(long ref) {
    data.forEach(trade -> {
      if (trade.getRef() == ref) {
        System.out.println(trade);
      }
    });
  }

  public void commit(Trade trade, Customer customer, Stock stock) {

    trade.commit(ref, customer, stock);
    data.add(trade);
  }
}