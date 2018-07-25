package com.jda.objectorientedprograms.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jda.utility.Enums.TradeType;
import com.jda.utility.Reader;

public class StockAccount {
  public enum Choice {
    BUY, SELL, SHOW_CUSTOMER, SHOW_STOCK, SHOW_TRADE, SHOW_CUSTOMERS, SHOW_STOCKS, SHOW_TRADES, QUIT, ERROR
  }
  
  private Customers customers;
  private Trades    trades;
  private Stocks    stocks;
  private Gson      gson;
  
  public void performOperations(String inputFormat) {

    Reader reader = new Reader();
    boolean done = false;
    while (!done) {
      switch (getChoice(reader)) {

        case BUY:
          Trade buyTrade = new Trade(reader, TradeType.BUY);
          Customer buyer = buyTrade.findCustomer(customers);
          Stock boughtStock = buyTrade.findStock(stocks);
          if ((buyer != null) && (boughtStock != null)) {
            trades.commit(buyTrade, buyer, boughtStock);
          }
          break;
        case SELL:
          Trade sellTrade = new Trade(reader, TradeType.SELL);
          Customer seller = sellTrade.findCustomer(customers);
          Stock soldStock = sellTrade.findStock(stocks);
          if ((seller != null) && (soldStock != null)) {
            trades.commit(sellTrade, seller, soldStock);
          }

          break;
        case SHOW_CUSTOMER:
          System.out.println("Enter customer id");
          long custId = reader.readLong();
          customers.show(custId);
          break;
        case SHOW_CUSTOMERS:

          customers.showAll();
          break;
        case SHOW_STOCK:
          System.out.println("Enter stock symbol");
          String symbol = reader.readString();
          stocks.show(symbol);
          break;
        case SHOW_STOCKS:
          stocks.showAll();;
          break;
        case SHOW_TRADE:
          System.out.println("Enter trade reference");
          long ref = reader.readLong();

          trades.show(ref);
          break;
        case SHOW_TRADES:
          trades.showAll();;
          System.out.println(trades);
          break;

        case QUIT:
          done = true;
          break;
        default:
          System.out.println(inputFormat);;
      }
    }
  }
  
  private Choice getChoice(Reader reader) {
    Choice choice;
    try {
      choice = Choice.valueOf(reader.readLine().toUpperCase().replaceAll(" ", "_"));
    } catch (Exception e) {
      return Choice.ERROR;
    }
    return choice;
  }
  
  public StockAccount(String customersFile, String stocksFile, String tradesFile) {
    gson = new GsonBuilder().setPrettyPrinting().create();
    customers = new Customers(gson, customersFile);
    trades = new Trades(gson, tradesFile);
    stocks = new Stocks(gson, stocksFile);
  }
  
  public void writeToJson() {
    customers.printToFile();
    trades.printToFile();
    stocks.printToFile();
    
  }
  
}
