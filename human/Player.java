package human;

import java.util.List;
import java.util.Scanner;

public class Player extends PlayerBase {

  public List<Integer> cardReady(List<Integer> deck, List<Integer> card) {
    card.add(0, deck.get(1));
    card.add(0, deck.get(3));
    return card;
  }

  public void cardOpen(List<Integer> cards) {
    int cardSum = 0;
    card.Card card = new card.Card();
    List<String> cardNum = card.toRank(cards);
    cardSum = card.cardSum(cards);
    System.out.println("あなたのカードは" + cardNum + "で合計は" + cardSum + "ポイントです。");
  }

  public List<Integer> cardAdd(List<Integer> deck, List<Integer> cards) {
    card.Card card = new card.Card();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if(card.cardSum(cards) > 21){
        System.out.println("バーストしました。あなたの負けです。");
        main.Main.burst = true;
        break;
      } else {
      System.out.println("カードを追加しますか？(\"Y\" か \"N\"を入力)");
      String answer = scanner.next();
      if(answer.equalsIgnoreCase("y")) {
        cards.add(deck.get(main.Main.deckCount));
        main.Main.deckCount++;
        cardOpen(cards);

      } else if(answer.equalsIgnoreCase("n")){
        break;
    }
  }
    } return cards;
  }
}
