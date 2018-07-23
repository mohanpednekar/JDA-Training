package com.jda.algorithmprograms;

import com.jda.utility.Util;
import com.jda.utility.Util.TemperatureUnit;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class TemperatureConversion {

  public static
  void main(String[] args) {
    Reader reader = new Utility().new Reader();

    System.out.println("Let's convert temperature");

    System.out.println("Enter temperature in degree Celcius");
    double tempCelcius1 = reader.readDouble();
    double tempFahrenheit1 = Util.temperatureConversion(tempCelcius1, TemperatureUnit.Fahrenheit);
    System.out.println("The temperature in degree Fahrenheit is " + tempFahrenheit1);

    System.out.println("\nEnter temperature in degree Fahrenheit");
    double tempFaahrenheit2 = reader.readDouble();
    double tempCelcius2 = Util.temperatureConversion(tempFaahrenheit2, TemperatureUnit.Celsius);
    System.out.println("The temperature in degree Celcius is " + tempCelcius2);
  }
}
