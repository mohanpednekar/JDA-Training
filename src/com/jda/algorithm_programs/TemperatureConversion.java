package com.jda.algorithm_programs;

import com.jda.utility.Util;
import com.jda.utility.Util.TemperatureUnit;
import com.jda.utility.Utility;

public
class TemperatureConversion {

  public static
  void main(String[] args) {
    Utility utility = new Utility();

    System.out.println("Let's convert temperature");

    System.out.println("Enter temperature in degree Celcius");
    double tempCelcius1 = utility.readDouble();
    double tempFahrenheit1 = Util.temperatureConversion(tempCelcius1, TemperatureUnit.Fahrenheit);
    System.out.println("The temperature in degree Fahrenheit is " + tempFahrenheit1);

    System.out.println("\nEnter temperature in degree Fahrenheit");
    double tempFaahrenheit2 = utility.readDouble();
    double tempCelcius2 = Util.temperatureConversion(tempFaahrenheit2, TemperatureUnit.Celsius);
    System.out.println("The temperature in degree Celcius is " + tempCelcius2);
  }
}
