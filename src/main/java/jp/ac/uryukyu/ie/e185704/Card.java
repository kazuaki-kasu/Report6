package jp.ac.uryukyu.ie.e185704;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Card {
    /**
    トランプのコンストラクタ
    @param num トランプの数字
    @param suit マーク
     */
    String suit;
    int num;

    Card(String suit, int num) {
        this.suit = suit;
        this.num = num;
    }
    Card(){}

    /**
    @param suit トランプのマーク
    @param trampNum マークごとのトランプの枚数
    @return ArrayList<Card> Cards:Cardクラスで作ったトランプの配列
     */
    String[] suits = {"♠︎", "♣︎", "♦︎", "❤︎"};
    int trampNum = 13;
    ArrayList<Card> Cards = new ArrayList<Card>();

    ArrayList<Card> makeCards() {
        for (String s : suits) {
            for (int i = 1; i <= trampNum; i++) {
                Card card = new Card(s, i);
                Cards.add(card);
            }
        }
        return Cards;
    }

    /**
     * 山札からプレイヤーにカードを5枚配るメソッド
    @param numOfPlayer:プレイヤーの人数 後々入力された人数に設定したかった
    @param numOfCard:一人一人に配るカードの枚数
    @return ArrayList<Card> tehuda:各々の手札の配列
    */
    ArrayList<Card> tehuda = new ArrayList<Card>();

    public ArrayList<Card> hunds() {
        int numCard = 5;
        int player = 1;

        for (int i = 0; i < player; i++) {
            for (int j = 0; j < numCard; j++) {
                Random num = new Random();
                int num2 = num.nextInt(Cards.size());

                tehuda.add(Cards.get(num2));
                Cards.remove(num2);
            }
        }
        for (Card c : tehuda) {
            System.out.println(c.suit + c.num);
        }
        return tehuda;
    }

    /**
     * カードを選び交換するメソッド
     * @changeIndex 交換するカードの番号
     * @changeIndexList カード番号のリスト
     * @Cards 山札
     */
    void changeCard() {
        Scanner scan = new Scanner(System.in);

        System.out.println("交換したいカードの枚数:");
        int changeNum = scan.nextInt();

        ArrayList<Integer> changeIndexList = new ArrayList<Integer>();
        for (int i = 0; i < changeNum; i++) {
            System.out.println("交換したいカード(上から1~5): ");
            int changeIndex = scan.nextInt();

            if (changeIndex > tehuda.size()) {
                System.out.println("1~5の数字を入力してください");
                int changeIndex2 = scan.nextInt();
                changeIndexList.add(changeIndex2);
            } else {
                changeIndexList.add(changeIndex);
            }
        }
        for (int i : changeIndexList) {
            Random num = new Random();
            int num2 = num.nextInt(Cards.size());

            tehuda.set(i - 1, Cards.get(num2));
            Cards.remove(num2);
        }
        for (Card c : tehuda) {
            System.out.println(c.suit + c.num);
        }
    }
}
