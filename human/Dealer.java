package human;

import java.util.List;

public class Dealer extends PlayerBase{

  public void cardOpen(int card) {
    String str;
    switch (card) {
      case 11:
        str = "J";
        break;
      case 12:
        str = "Q";
        break;
      case 13:
        str = "K";
        break;
      default:
        str = String.valueOf(card);
        break;
    }
    System.out.println("ディーラーのカードの1枚は\"" + str + "\"です。");
  }

  public void cardOpen(List<Integer> cards) {
    int cardSum = 0;
    card.Card card = new card.Card();
    List<String> cardNum = card.toRank(cards);
    cardSum = card.cardSum(cards);
    System.out.println("ディーラーのカードは" + cardNum + "で合計は" + cardSum + "ポイントです。");
  }
  // ディーラーのカード2枚をセット
  public List<Integer> cardReady(List<Integer> deck, List<Integer> card) {
    card.add(0, deck.get(0));
    card.add(0, deck.get(2));
    return card;
  }
  // ディーラーのポイントが17以上になるまで引き続ける
  public List<Integer> cardAdd(List<Integer> deck, List<Integer> cards) {
    card.Card card = new card.Card();
    while (true) {
      if(card.cardSum(cards) > 21){
        List<String> cardNum = card.toRank(cards);
        int cardSum = card.cardSum(cards);
        System.out.println("ディーラーのカードは" + cardNum + "で合計は" + cardSum + "ポイントです。");
        System.out.println("ディーラーがバーストしました。あなたの勝ちです。 ^o^");
        main.Main.burst = true;
        break;
      }
      if(card.cardSum(cards) < 17){
        cards.add(deck.get(main.Main.deckCount));
      } else {
        break;
      }
    } return cards;
  }
}
