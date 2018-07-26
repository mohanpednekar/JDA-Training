package com.jda.datastructures;

import java.util.Iterator;

public class LinkedList<T> extends List<T> implements Iterable<T> {
  
  public T get(int pos) {
    Node<T> node = root;
    
    if (pos == 0) {
      T rootData = root.getData();
      root = null;
      return rootData;
    }
    for (int i = 0; i < pos; i++) {
      node = node.getNext();
    }
    return node.getData();
  }
  
  public void add(T item) {
    if (root == null) {
      root = new Node<>(item);
      return;
    }
    Node<T> node = root;
    
    while (node.getNext() != null) {
      node = node.getNext();
    }
    node.setNext(new Node<>(item));
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return new Iterator<T>() {
      
      @Override
      public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
      }
      
      @Override
      public T next() {
        // TODO Auto-generated method stub
        return null;
      }
    };
  }
}
