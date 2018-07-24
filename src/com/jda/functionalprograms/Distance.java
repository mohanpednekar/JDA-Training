package com.jda.functionalprograms;

import com.jda.utility.Maths;
import com.jda.utility.Printer;
import com.jda.utility.Validation;

public
class Distance {

  public static
  void main(String[] args) {
    if (!Validation.checkCmdArgs(args, 2)) { return; }
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    Printer.printLine(
        "The distance of (" + x + "," + y + ") from origin is " + distanceFromOrigin(x, y));
  }

  private static
  double distanceFromOrigin(double x, double y) {
    return Maths.euclideanDistance(x, y, 0.0, 0.0);
  }
}
