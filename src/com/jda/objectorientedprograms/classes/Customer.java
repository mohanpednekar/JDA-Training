package com.jda.objectorientedprograms.classes;

public class Customer {

  private long   id;
  private String name;
  private String surname;
  private long   mobile;
  private double balance;
  
  public double getBalance() {
    return balance;
  }

  public long getId() {
    return id;
  }
  
  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", mobile=" + mobile
        + ", balance=" + balance + "]";
  }
  
  public boolean has(double shares) {
    // TODO Auto-generated method stub
    return true;
  }
  
  public boolean canAfford(double amount) {
    return balance > amount;
  }

}
