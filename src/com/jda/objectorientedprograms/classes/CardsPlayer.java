package com.jda.objectorientedprograms.classes;

import java.util.ArrayList;

public
class CardsPlayer {

  ArrayList<Card> cards = new ArrayList<>();

  public
  void receiveCard(Card card) {
    cards.add(card);
  }
}
