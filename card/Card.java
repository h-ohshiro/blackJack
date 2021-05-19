package card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card{

  // カード52枚を生成
  public List<Integer> cardCreate() {
    List<Integer> deck = new ArrayList<>(52);
    int k;
    for(int i=1 ; i <= 52 ; i++ ){
      k = i;
      k %= 13;
      if(k == 0){
        k = 13;
      }
      deck.add(k);
      }
    Collections.shuffle(deck);
    return deck;
  }

  // カードを文字列に変更
  public List<String> toRank(List<Integer> cards) {
    List<String> strCard = new ArrayList<>();
    for(int i=0; i < cards.size(); i++){
      switch (cards.get(i)) {
        case 1:
        strCard.add("A");
        break;
        case 11:
        strCard.add("J");
        break;
        case 12:
        strCard.add("Q");
        break;
        case 13:
        strCard.add("K");
        break;
        default:
        strCard.add(String.valueOf(cards.get(i)));
      }
    }
    return strCard;
  }

  public int cardSum(List<Integer> cards) {
    int cardSum = 0;
    for(int i=0 ; i < cards.size() ; i++){
      if(cards.get(i) > 10){
        cards.set(i, 10);
      }
        cardSum += cards.get(i);
    }
    return cardSum;
  }

  public void result(List<Integer> playerCard, List<Integer> dealerCard) {
    int playerResult = 21 - cardSum(playerCard);
    int dealerResult = 21 - cardSum(dealerCard);
    if(playerResult == dealerResult){
      System.out.println("引き分けです");
    } else if(playerResult < dealerResult){
      System.out.println("あなたの勝ちです ^o^");
    } else {
      System.out.println("あなたの負けです ;_;");
    }

  }

}
