package com.jda.objectorientedprograms.classes;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.utility.Reader;

public class Customers extends JsonArrayList<Customer> {

  public Customers(Gson gson, String customersFile) {
    super(gson, customersFile);
    data = Reader.readArrayListFromFile(gson, new TypeToken<ArrayList<Customer>>() {}.getType(),
        customersFile);
  }

  public void show(long custId) {
    data.forEach(customer -> {
      if (customer.getId() == custId) {
        System.out.println(customer);
      }
    });
  }
  
  public Customer find(long customerId) {
    for (Customer customer : data) {
      if (customer.getId() == customerId) { return customer; }
    }
    return null;
  }

}