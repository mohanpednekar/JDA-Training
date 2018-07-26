package com.jda.objectorientedprograms.stockmarket;

public class JsonIdHolder<T extends Comparable<T>> {

  T id;

  public T getId() {
    return id;
  }

  boolean is(T id) {
    
    return this.id.equals(id);
  }
}
