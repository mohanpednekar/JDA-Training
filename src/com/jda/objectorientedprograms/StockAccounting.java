package com.jda.objectorientedprograms;

import com.jda.objectorientedprograms.stockmarket.StockAccount;
import com.jda.objectorientedprograms.stockmarket.StockAccount.Choice;
import com.jda.utility.Constants;

public
class StockAccounting {

  private static String CUSTOMERS = Constants.LIVE_PATH + "customers.json";
  private static String STOCKS = Constants.LIVE_PATH + "stocks.json";
  private static String TRADES = Constants.LIVE_PATH + "trades.json";

  public static
  void main(String[] args) {

    StockAccount stockAccount = new StockAccount(CUSTOMERS, STOCKS, TRADES);
    String inputFormat = generateInputFormat(Choice.values());
    System.out.println(inputFormat);
    stockAccount.performOperations(inputFormat);
  }

  private static
  String generateInputFormat(Choice[] choices) {
    StringBuilder format = new StringBuilder();
    format.append("Welcome to Stock Market\n");
    for (Choice choice : choices) {
      if (choice == Choice.ERROR) { continue; }
      String readable = choice.name().replaceAll("_", " ").toLowerCase();
      format.append("Enter \"").append(readable).append("\" to ").append(readable).append("\n");
    }
    return format.toString();
  }
}
