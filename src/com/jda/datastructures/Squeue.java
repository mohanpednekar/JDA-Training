package com.jda.datastructures;

public
class Squeue<T> extends Queue<T> {

  Stack<T> main = new Stack<>();
  Stack<T> assitant = new Stack<>();

  public
  void enqueue(T item) {
    main.push(item);
  }

  public
  T dequeue() {
    while (!main.isEmpty()) {
      assitant.push(main.pop());
    }
    T item = assitant.pop();
    while (!assitant.isEmpty()) {
      main.push(assitant.pop());
    }
    return item;
  }

  @Override
  public
  boolean isEmpty() {
    return main.isEmpty();
  }
}
