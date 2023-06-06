/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Monica
 */
public class Card {
    private final int suit;
    private final int rank;
    private final int value;
    Card(int suit,int rank,int value)
    {
        this.suit=suit;
        this.rank=rank;
        this.value=value;
    }
    
    Card (Card thiscard)
    {
        suit=thiscard.suit;
        rank=thiscard.rank;
        value=thiscard.value;
    }
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }   
}
