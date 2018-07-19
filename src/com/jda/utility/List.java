package com.jda.utility;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public
class List<T> {

  Node<T> root;

  public
  String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Node<T> node = root;
    while (node != null) {
      stringBuilder.append(node).append(" ");
      node = node.getNext();
    }
    return stringBuilder.toString().trim();
  }

  public
  T pop() {
    Node<T> node = root;
    T nodeData = node.getData();
    Node<T> nextNode = root.getNext();
    if (nextNode == null) {
      root = null;
      return nodeData;
    }
    while (nextNode.getNext() != null) {
      node = nextNode;
      nextNode = nextNode.getNext();
    }
    node.setNext(null);
    return nextNode.getData();
  }

  public
  int index(T item) {
    if (root == null) { return -1; }
    Node<T> node = root;
    for (int i = 0; node != null; node = node.getNext(), i++) {
      if (node.getData().equals(item)) { return i; }
    }
    return -1;
  }

  public
  int size() {
    int count = 0;
    Node<T> node = root;
    while (node != null) {
      node = node.getNext();
      count++;
    }
    return count;
  }

  public
  boolean isEmpty() {
    return root == null;
  }

  public
  void printToFile(String filePath) {
    try (PrintWriter out = new PrintWriter(filePath)) {
      out.println(this);
    } catch (FileNotFoundException e) {
      System.out.println("Writing to file failed");
    }
  }

  public
  void remove(T item) {
    if (root.getData().equals(item)) {
      root = root.getNext();
      return;
    }
    Node<T> node = root;
    while (!node.getNext().getData().equals(item)) {
      node = node.getNext();
    }
    node.setNext(node.getNext().getNext());
  }

  public
  T pop(int pos) {
    Node<T> node = root;

    if (pos == 0) {
      T rootData = root.getData();
      root = null;
      return rootData;
    }
    for (int i = 1; i < pos; i++) {
      node = node.getNext();
    }
    Node<T> nextNode = node.getNext();
    node.setNext(nextNode.getNext());
    return nextNode.getData();
  }

  public
  boolean search(T item) {
    Node<T> node = root;
    while (node != null) {
      if (node.getData().equals(item)) { return true; }
      node = node.getNext();
    }
    return false;
  }
}
