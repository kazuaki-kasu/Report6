package jp.ac.uryukyu.ie.e185704;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /* 1:play人数受け取り
        2:人数に応じてカードを配る
         */
        String[] suits = {"♠︎", "♣︎", "♦︎", "❤︎"};
        ArrayList<Card> Cards = new ArrayList<Card>();

        for (String s : suits) {
            for (int i = 1; i < 14; i++) {
                Card card = new Card(s, i);
                Cards.add(card);
            }
        }
        int numOfPlayer = 1;
        int numOfCard = 5;

        for (int i = 0; i < numOfPlayer; i++) {
            ArrayList<Card> tehuda_i = new ArrayList<Card>();
            for(int j = 0; j < numOfCard; j++) {
                Random num = new Random();
                int num2 = num.nextInt(Cards.size());
                tehuda_i.add(Cards.get(num2));
//                System.out.println(Cards.get(num2).suit + Cards.get(num2).num);
                Cards.remove(num2);
            }
        }
    }
}