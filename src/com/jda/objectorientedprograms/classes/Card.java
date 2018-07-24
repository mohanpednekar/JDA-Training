package com.jda.objectorientedprograms.classes;

import com.jda.utility.Enums.CardSuit;
import com.jda.utility.Enums.CardValue;

public
class Card implements Comparable<Card> {

  CardSuit suit;
  CardValue value;

  public
  Card(CardSuit suit, CardValue value) {
    this.suit = suit;
    this.value = value;
  }

  @Override
  public
  String toString() {
    return suit.singleChar() + "" + value.singleChar() + "  ";
  }

  @Override
  public
  int compareTo(Card card) {
    int suitCompare = suit.compareTo(card.suit);
    if (suitCompare != 0) { return suitCompare; }
    return value.compareTo(card.value);
  }
}
