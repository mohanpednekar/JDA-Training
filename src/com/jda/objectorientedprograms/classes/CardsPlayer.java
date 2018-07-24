package com.jda.objectorientedprograms.classes;

import com.jda.datastructures.OrderedList;
import com.jda.datastructures.Queue;

public
class CardsPlayer {

  Queue<Card> cards = new Queue<>();

  public
  void receiveCard(Card card) {
    cards.enqueue(card);
  }

  @Override
  public
  String toString() {
    return cards.toString();
  }

  public
  void sort() {
    OrderedList<Card> sortedCards = new OrderedList<>();
    while (!cards.isEmpty()) { sortedCards.add(cards.dequeue()); }
    while (!sortedCards.isEmpty()) { cards.enqueue(sortedCards.pop(0)); }
  }
}
