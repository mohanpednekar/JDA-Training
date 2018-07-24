package com.jda.objectorientedprograms;

import com.jda.objectorientedprograms.classes.Card;
import com.jda.objectorientedprograms.classes.CardsPlayer;
import com.jda.utility.Enums.CardSuit;
import com.jda.utility.Enums.CardValue;
import java.util.ArrayList;
import java.util.Collections;

public
class DeckOfCards {

  public static
  void main(String[] args) {
    ArrayList<Card> cards = new ArrayList<>();
    for (CardSuit suit : CardSuit.values()) {
      for (CardValue value : CardValue.values()) {
        cards.add(new Card(suit, value));
      }
    }

    Collections.shuffle(cards);
    CardsPlayer[] players = new CardsPlayer[4];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 4; j++) {
        players[j].receiveCard(cards.remove(0));
      }
    }

    Card[][] cardsArray = new Card[4][9];
  }
}
