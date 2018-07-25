package com.jda.objectorientedprograms.stockmarket;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.utility.Reader;
import java.util.ArrayList;

public
class Customers extends JsonArrayList<Customer, Long> {

  Customers(Gson gson, String customersFile) {
    super(gson, customersFile);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Customer>>() {}.getType(),
        customersFile);
    maxId = findHighestId();
  }

  public
  void add(Customer newCustomer) {
    maxId += 1;
    newCustomer.setId(maxId);
    data.add(newCustomer);
  }
}

