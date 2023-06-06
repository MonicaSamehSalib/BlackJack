/*P
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Monica
 */
import java.util.Scanner;
public class BlackJack {

    /**
     * @param args the command line arguments
     */
     static Game game=new Game();
    static void hitOrStand(Player player,int numPlayer,GUI gui)
    {
        int command=0;
        Scanner input=new Scanner(System.in);
        int numCards=0;
        while (player.getScore()<21)
        {
            command=input.nextInt();
          if(command==1)
           {
             Card card=game.generator(game.card_deck);
             int current=player.getNumber_cards();
             addCard(numPlayer-1,gui,card);
             //player.player_cards[current]=new Card(card);
             //player.score+=player.player_cards[current].getValue();
             numCards++;
             player.setScore(player.getScore()+card.getValue());
             // if(player.getScore()==21)
             //{
              //player.setIs_blackjack(true);
              //System.out.println("Player "+numPlayer+"'s score ="+player.getScore());
              //break;
             //}
               //else if(player.getScore()>21)
             //{
              //System.out.println("Player "+numPlayer+"'s score ="+player.getScore());
              //break;
              //}
           }
          else 
          {
              break;
          }
          
        } 
           System.out.println("Player "+numPlayer+"'s score ="+player.getScore());
           game.updateHighScore(player);
           System.out.println("Highest Score:"+Game.highest_score);
         game.players[numPlayer-1].setNumber_cards(game.players[numPlayer-1].getNumber_cards()+numCards);
        
    }
    static void hitDealer(Player player, GUI gui)
    {
        int numCards=0;
        while(player.getScore()<=Game.highest_score)
        {
            Card card;
            card = game.generator(game.card_deck);
             int current=player.getNumber_cards();
             addDealer(gui,card);
             //player.player_cards[current]=new Card(card);
             //player.score+=player.player_cards[current].getValue();
             player.setScore(player.getScore()+card.getValue());
             numCards++;
             if(player.getScore()==21)
             {
                 player.setIs_blackjack(true);
                 System.out.println("Dealer's score ="+player.getScore());
                 break;
             }
             else if (player.getScore()>Game.highest_score && Game.highest_score<21 )//&& player.getScore()!=Game.highest_score)
             {
                 player.setScore(Game.highest_score);
                 System.out.println("Dealer's score ="+player.getScore());
                 break;
             }
             else if(player.getScore()>21)
             {
                 System.out.println("Dealer's score ="+player.getScore());
                 break;
             }
        }
        game.players[3].setNumber_cards(numCards);
    }
    
    
   // static void calculateScore(Player player)
    //{
      //  int size=player.getNumber_cards();
        //for(int i=0;i<size;i++)
        //{
          //  game.updateHighScore(player);
        //}
    //}
    
    static void getWinner(Player player[])
    {
        int numOfWinners=0;
        int index=0;
        for(int h=0;h<4;h++)
        {
            if(player[h].getScore()==Game.highest_score)
            {
                numOfWinners++;
            }
            else
            {
                continue;
            }
        }
        if(numOfWinners>1 )
        {
           System.out.println("PUSH Case");
        }
        else 
        {
            for(int g=0;g<4;g++)
            {
                if(player[g].getScore()==Game.highest_score)
                {
                    index=g;
                    break;
                }
            }
            System.out.println("Player "+(index+1)+" Won");
        }
    }
    
    public static void addCard(int index,GUI gui, Card card)
    {
        gui.updatePlayerHand(card, index);
    }
    public static void addDealer(GUI gui, Card card)
    {
        gui.updateDealerHand(card,game.card_deck );
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        GUI gui=new GUI();
        game.card_deck_generator(game.card_deck);
        game.startGame(game.players);

        gui.runGUI(game.card_deck, game.players[0].getPlayer_cards(), game.players[1].getPlayer_cards(), game.players[2].getPlayer_cards(), game.players[3].getPlayer_cards());
        for(int i=0;i<3;i++)
        {
            hitOrStand(game.players[i],(i+1),gui);
            
        }
        
        hitDealer(game.players[3],gui);
       // game.updateHighScore(game.players[3]);
       // for(int j=0;j<4;j++)
       // {
       //     calculateScore(game.players[j]);
       // }
       // for(int k=0;k<4;k++)
       // {
       //     if(game.players[k].getScore()==Game.highest_score)
       //     {
       //         game.players[k].setIs_winner(true);
       //     }
       // }
        
        getWinner(game.players);
    }
    
}
