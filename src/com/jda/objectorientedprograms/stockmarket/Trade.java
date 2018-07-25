package com.jda.objectorientedprograms.stockmarket;

import com.google.gson.annotations.SerializedName;
import com.jda.utility.Enums.TradeType;
import com.jda.utility.Reader;

public
class Trade extends JsonIdHolder<Long> {

  @SerializedName("ref")
  private Long id;
  private long customerId;
  private String symbol;
  private TradeType tradeType;
  private double amount;
  private double shares;
  private long timestamp;

  Trade(Reader reader, TradeType tradeType) {
    System.out.println("Enter customer id, stock symbol and amount of money (separated by spaces)");
    customerId = reader.readLong();
    symbol = reader.readString();
    this.tradeType = tradeType;
    amount = reader.readDouble();
    timestamp = System.currentTimeMillis();
  }

  @Override
  public
  Long getId() {
    return id;
  }

  public
  void setId(Long id) {
    this.id = id;
  }

  @Override
  public
  String toString() {
    return "Trade [id=" + id + ", customerId=" + customerId + ", symbol=" + symbol + ", tradeType="
        + tradeType + ", amount=" + amount + ", shares=" + shares + ", timestamp=" + timestamp
        + "]";
  }

  Stock findStock(Stocks stocks) {
    Stock stock = stocks.find(symbol);
    if (stock != null) {
      if (tradeType == TradeType.SELL) {
        return stock;
      }
      else if (stock.isWorth(amount)) { return stock; }
    }
    return null;
  }

  Customer findCustomer(Customers customers, Stock stock) {
    Customer customer = customers.find(customerId);
    switch (tradeType) {
      case BUY:
        if ((customer != null) && customer.canAfford(amount)) { return customer; }
        break;
      case SELL:
        if ((customer != null) && customer.has(shares, stock)) { return customer; }
    }
    return null;
  }

  void commit(Long ref, Customer customer, Stock stock) {
    id = ref;
    shares = stock.worth(amount);
    switch (tradeType) {
      case BUY:
        customer.buy(new Stock(stock, amount));
        stock.reduce(amount);
        break;
      case SELL:
        customer.sell(new Stock(stock, amount));
        stock.increase(amount);
        break;
    }
  }
}
