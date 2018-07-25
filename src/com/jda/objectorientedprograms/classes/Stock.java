package com.jda.objectorientedprograms.classes;

public class Stock {
  private String symbol;
  private String name;
  private double shares;
  private double price;
  
  public double findValue() {
    return shares * price;
  }

  public String getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return "Stock [symbol=" + symbol + ", name=" + name + ", shares=" + shares + ", price=" + price
        + "]";
  }

  public boolean isWorth(double amount) {
    return findValue() > amount;
  }

}
