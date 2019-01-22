package jp.ac.uryukyu.ie.e185704;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    Card card = new Card();
    String[] suits = {"♠︎", "♣︎", "♦︎", "❤︎"};
    int trampNum = 13;
    ArrayList<Card> Cards = new ArrayList<>();

    ArrayList<Card> makeCards() {
        for (String s : suits) {
            for (int i = 1; i <= trampNum; i++) {
                Card card = new Card(s, i);
                Cards.add(card);
            }
        }
        return Cards;
    }

    ArrayList<Card> tehuda = new ArrayList<>();
    @Test
    /**
     * 山札からカードを配った時、山札が引いた枚数分減っているかテストするメソッド
     */
    public void hunds(){
        makeCards();
        int numCard = 5;
        for(int i = 0; i<numCard; i++){
            tehuda.add(Cards.get(i));
            Random num = new Random();
            int num2 = num.nextInt(Cards.size());

            Cards.remove(num2);
        }
        assertEquals(47,Cards.size());
    }

    @Test
    /**
     * 山札からカードを交換した時、山札が引いた枚数分減っているかテストするメソッド
     * 元々の入力待ちコードだと入力ができなかったので簡略化した
     */
    void changeCard() {
        Scanner scan = new Scanner(System.in);
        hunds();

        int[] changeIndexList = {1,2,3};
        int changeNum = changeIndexList.length;
        for (int i : changeIndexList) {
            Random num = new Random();
            int num2 = num.nextInt(Cards.size());

            tehuda.set(i - 1, Cards.get(num2));
            Cards.remove(num2);
        }
        assertEquals(47-changeNum,Cards.size());
    }
}