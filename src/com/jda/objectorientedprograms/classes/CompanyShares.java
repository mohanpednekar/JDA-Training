package com.jda.objectorientedprograms.classes;

public
class CompanyShares {

  private String symbol;
  private long number;
  private long timestamp;

  public
  String getSymbol() {
    return symbol;
  }

  public
  long getNumber() {
    return number;
  }

  public
  void buy(long number) {
    this.number += number;
  }

  public
  void sell(long number) {
    this.number -= number;
  }

  public
  long getValue(StockPortfolio portfolio) {
    return number * 1;
  }

  private
  long currentPrice(String symbol) {
    return 0;
  }
}
