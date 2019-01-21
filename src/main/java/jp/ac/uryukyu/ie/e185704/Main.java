package jp.ac.uryukyu.ie.e185704;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card c = new Card(); //インスタンス呼び出し
        c.makeCards();
        System.out.println(c.Cards.size());

        //手札表示
        c.tehuda();
        //カード交換
//        System.out.println(c.tehuda.size());
//        System.out.println(c.Cards.size());

        c.changeCard();
    }
}
