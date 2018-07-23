package com.jda.objectorientedprograms.classes;

import com.jda.datastructures.LinkedList;

public
class StockAccount {

  String name;
  LinkedList<CompanyShares> companyShares = new LinkedList<>();

  double valueof(StockPortfolio portfolio) {
    double value = 0;
    int n = companyShares.size();
    for (int i = 0; i < n; i++) {
      companyShares.get(i).getValue(portfolio);
    }

    return value;
  }
}
