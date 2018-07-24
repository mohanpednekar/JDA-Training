package com.jda.objectorientedprograms.classes;

import com.jda.utility.Enums.CardSuit;
import com.jda.utility.Enums.CardValue;

public
class Card {

  CardSuit suit;
  CardValue value;

  public
  Card(CardSuit suit, CardValue value) {
    this.suit = suit;
    this.value = value;
  }
}
