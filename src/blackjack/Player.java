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
public class Player {

    public void setIs_winner(boolean is_winner) {
        this.is_winner = is_winner;
    }

    public int getNumber_cards() {
        return number_cards;
    }

    public boolean isIs_blackjack() {
        return is_blackjack;
    }

    public boolean isIs_winner() {
        return is_winner;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNumber_cards(int number_cards) {
        this.number_cards = number_cards;
    }

    public void setIs_blackjack(boolean is_blackjack) {
        this.is_blackjack = is_blackjack;
    }
   private final String name;


   private int score=0;
   private int number_cards=0;
   private  Card[] player_cards=new Card[11];
   private  boolean is_blackjack;
   private  boolean is_winner;
    Player(String name)
    {
        this.name=name;
    }
        public String getName()
    {
        return name;
    }
        
    public void addPlayerCards(Card card)
    {
        player_cards[number_cards]=card;
        number_cards++;
        score+=card.getValue();
    }
    public void addDealerCards(Card card)
    {
        player_cards[number_cards]=card;
        number_cards++;
        score+=card.getValue();
    }
    public int getScore()
    {
        return score;
    }
    public Card[] getPlayer_cards()
    {
        return player_cards;
    }
}
