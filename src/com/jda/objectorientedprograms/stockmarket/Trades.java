package com.jda.objectorientedprograms.stockmarket;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.utility.Reader;
import java.util.ArrayList;

class Trades extends JsonArrayList<Trade, Long> {

  Trades(Gson gson, String file) {
    super(gson, file);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Trade>>() {}.getType(), file);
    maxId = findHighestId();
  }

  void commit(Trade trade, Customer customer, Stock stock) {
    maxId += 1;
    trade.commit(maxId, customer, stock);
    data.add(trade);
  }
}
