package com.jda.utility;

public
class Queue<T> extends List<T> {

  public
  void enqueue(T item) {
    if (root == null) {
      root = new Node<>(item);
      return;
    }
    Node<T> node = root;
    while (node.hasNext()) {
      node = node.getNext();
    }
    node.setNext(new Node<>(item));
  }

  public
  T dequeue() {
    Node<T> node = root;
    root = root.getNext();
    return node.getData();
  }
}
