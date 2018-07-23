package com.jda.objectorientedprograms;

import com.jda.utility.Constants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public
class RegexDemo {

  private static String INPUT = Constants.INPUT_PATH + "RegexMessage.txt";

  public static
  void main(String[] args) {
    String message = null;

    try {
      message = new String(Files.readAllBytes(Paths.get(INPUT)));
    } catch (IOException e) {
      System.out.println("Something went wrong");
    }

    if (message == null) { return; }

    System.out.println(message);

    System.out.println("What's your name");

    String result = message.replaceAll(Regex.NAME.toString(), "Mohan")
        .replaceAll(Regex.FULL_NAME.toString(), "Mohan Pednekar")
        .replaceAll(Regex.CONTACT_NUMBER.toString(), "91-8767337673")
        .replaceAll(Regex.DATE.toString(), "23/07/2018");
    System.out.println(result);
  }

  enum Regex {
    NAME("<<name>>"), FULL_NAME("<<full name>>"), CONTACT_NUMBER("91-xxxxxxxxxx"), DATE(
        "^\\d{2}\\/\\d{2}\\/\\d{4}$");

    private String regex;

    Regex(String regex) {
      this.regex = regex;
    }

    @Override
    public
    String toString() {
      return regex;
    }
  }
}
