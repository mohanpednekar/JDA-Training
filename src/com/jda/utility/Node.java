package com.jda.utility;

public
class Node<T> {

  private T data;
  private Node<T> next;

  public
  Node(T data, Node<T> next) {
    setData(data);
    setNext(next);
  }

  public
  Node(T data) {
    setData(data);
    setNext(null);
  }

  @Override
  public
  String toString() {
    return data.toString();
  }

  public
  T getData() {
    return data;
  }

  public
  void setData(T data) {
    this.data = data;
  }

  public
  Node<T> getNext() {
    return next;
  }

  public
  void setNext(Node<T> next) {
    this.next = next;
  }

  public
  boolean hasNext() {
    return next != null;
  }
}
