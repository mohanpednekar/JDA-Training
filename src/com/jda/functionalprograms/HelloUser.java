package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class HelloUser {

  private static final String USER_NAME_PLACEHOLDER = "<<UserName>>";

  public static
  void main(String[] args) {
    String template = "Hello <<UserName>>, How are you?";
    System.out.println("The template is as follows");
    System.out.println(template);
    System.out.println("What's your name?");
    Reader reader = new Utility().new Reader();
    String name = reader.readString();
    String greeting = template.replace(USER_NAME_PLACEHOLDER, name);
    System.out.println(greeting);
  }
}
