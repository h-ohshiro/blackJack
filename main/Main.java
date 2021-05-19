package main;
import java.util.List;

import card.Card;
import human.*;

public class Main {

  public static int deckCount = 4;
  public static boolean burst;

  public static void main(String[] args) {

    System.out.println("ブラックジャックを始めます。");
    Player player = new Player();
    Dealer dealer  = new Dealer();
    Card card = new Card();
    // デッキ作成
    List<Integer> deck = card.cardCreate();
    // カードをそれぞれ2枚配る
    dealer.cardReady(deck, dealer.cards);
    player.cardReady(deck, player.cards);
    // プレイヤーのカードを表示する
    player.cardOpen(player.cards);
    // ディーラーのカード2枚のうち1枚を表示する
    dealer.cardOpen(dealer.cards.get(0));
    // プレイヤーのカード追加
    player.cardAdd(deck, player.cards);
    // ディーラーのカード追加
    dealer.cardAdd(deck, dealer.cards);
    // 結果
    if(!burst){
      // ディーラーのカードオープン
      dealer.cardOpen(dealer.cards);
      card.result(player.cards, dealer.cards);
    }
  }
}
