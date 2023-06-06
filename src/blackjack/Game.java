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
import java.util.Random;
import java.util.Scanner;
public class Game {

    Player players[]=new Player[4];
    Card card_deck[]=new Card[52];
    static int highest_score=0;
    
    void card_deck_generator(Card cards[])
    {
        int counter=0;
        for(int i=0;i<4;i++)
        {
          for(int j=0;j<13;j++)
          {
              int suit=i;
              int rank=j;
              int value;
              if(j>9)
              {
                  value=10;
              }
              else
              {
                  value=j+1;
              }
              cards[counter]=new Card(suit,rank,value);
              counter+=1;
          }  
        }
    }
    
    Card generator(Card cards[])
    {
        Random random_card=new Random();
        int random_index=random_card.nextInt(51);
        while(cards[random_index]==null)
        {
            random_index=random_card.nextInt(51);
        }
        Card player_card=new Card(cards[random_index].getSuit(),cards[random_index].getRank(),cards[random_index].getValue());
        cards[random_index]=null;
        return player_card;
    }
    
    void startGame(Player player[])
    {
        GUI gui=new GUI();
        for(int k=0;k<4;k++)
        {
            if(k<3)
            {
            System.out.println("Enter the name of Player "+(k+1));
            Scanner input=new Scanner(System.in);
            String name=input.next();

            Card current_card=generator(card_deck);
            player[k]=new Player(name);
            player[k].addPlayerCards(current_card);
            gui.updatePlayerHand(current_card, k);
            current_card=generator(card_deck);
            player[k].addPlayerCards(current_card);
            gui.updatePlayerHand(current_card, k);
            player[k].setNumber_cards(2);
            }
            else 
            {
               
            
            Card current_card=generator(card_deck);
            player[k]=new Player("Dealer");
            player[k].addDealerCards(current_card);
            gui.updateDealerHand(current_card, card_deck);
            current_card=generator(card_deck);
            player[k].addDealerCards(current_card);
            gui.updateDealerHand(current_card, card_deck);
            player[3].setNumber_cards(2);
            
            }
            
        }
    }
    
    void updateHighScore(Player player)
    {
        
        if(player.getScore()>=highest_score && player.getScore()<=21)
        {
            highest_score=player.getScore();
        }
    }
    
}
