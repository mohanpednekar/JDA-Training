package com.jda.datastructures;

public
class Stack<T> extends List<T> {

  public
  void push(T item) {
    root = new Node<>(item, root);
  }

  public
  T pop() {
    Node<T> node = root;
    root = root.getNext();
    return node.getData();
  }

  public
  T peek() {
    return root.getData();
  }
}
