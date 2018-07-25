package com.jda.objectorientedprograms.classes;

import com.jda.utility.Enums.TradeType;
import com.jda.utility.Reader;

public class Trade {
  
  private long      ref;
  private long      customerId;
  private String    symbol;
  private TradeType tradeType;
  private double    amount;
  private double    shares;
  private long      timestamp;

  public Trade(Reader reader, TradeType tradeType) {
    System.out.println("Enter customer id, stock symbol and amount of money (separated by spaces)");
    customerId = reader.readLong();
    symbol = reader.readString();
    this.tradeType = tradeType;
    amount = reader.readDouble();
    timestamp = System.currentTimeMillis();
  }

  public long getRef() {
    return ref;
  }

  public double pricePerShare() {
    return amount / shares;
  }

  @Override
  public String toString() {
    return "Trade [ref=" + ref + ", customerId=" + customerId + ", symbol=" + symbol
        + ", tradeType=" + tradeType + ", amount=" + amount + ", shares=" + shares + ", timestamp="
        + timestamp + "]";
  }
  
  public Stock findStock(Stocks stocks) {
    Stock stock = stocks.find(symbol);
    if (stock != null) {
      if (tradeType == TradeType.SELL) {
        return stock;
      } else if (stock.isWorth(amount)) { return stock; }
    }
    return null;
  }
  
  public Customer findCustomer(Customers customers) {
    Customer customer = customers.find(customerId);
    if (customer != null) {
      if ((tradeType == TradeType.BUY) && customer.canAfford(amount)) { return customer; }
      if ((tradeType == TradeType.SELL) && customer.has(shares)) { return customer; } ;
    }
    return null;
  }

  public void commit(long ref, Customer customer, Stock stock) {
    this.ref = ref;
  }
}
