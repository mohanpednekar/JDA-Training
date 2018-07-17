package com.jda.algorithm_programs;

import com.jda.utility.Util;

public
class MonthlyPayment {

  public static
  void main(String[] args) {
    double p = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    double r = Double.parseDouble(args[2]);

    System.out.println(Util.monthlyPayment(p, y, r));
  }
}
