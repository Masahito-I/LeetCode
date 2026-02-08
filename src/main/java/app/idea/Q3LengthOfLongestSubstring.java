package app.idea;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Q3LengthOfLongestSubstring {

  // Sliding Window
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int max = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      // Conflict: Realizing you are over-capacity or hit a snag.
      while(!set.add(s.charAt(right))) { // 追加を試みて、失敗したら（重複していたら）ループの中に入る
        set.remove(s.charAt(left++)); // Letting go of the old to make room for the new.
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

  // 活用例: デリバリーアプリで「配送効率が最大になる（最短時間で多く配れる）ルート内の注文の組み合わせ」の計算。
  // 「配達完了までの制限時間」をキーにする（Time Window）
  // 右端（right）: 新しい注文をルートに追加。
  //
  //左端（left）: ルート全体の所要時間が30分を超えてしまった場合、一番最初に受けた注文（または最も遠い注文）をそのルートから外して別の配達員に回す。
  //
  //キー（判定基準）: ルートの合計推定時間 <= 30分
  // 「配達エリア（座標・距離）」をキーにする（Spatial Window）
  // 右端（right）: 進行方向にある次の注文をチェック。
  //
  // 左端（left）: 現在の配達員の現在地から離れすぎた注文や、逆方向の注文をルートから除外する。
  //
  // キー（判定基準）: 現在の注文間の最大距離 <= 指定キロ数（例: 2km圏内）
  // 窓の幅（例：10秒間）
  private static final long WINDOW_SIZE_MS = 10000;

  // 注文の記録を保持する「窓」
  // Deque：その両方のいいとこ取り。 前からでも後ろからでも追加・削除が可能
  private final Deque<Order> window = new LinkedList<>();

  public int processNewOrder(long orderId,long currentTime) {

    // 1. 新しい注文を「右端」から追加
    window.addLast(new Order(orderId, currentTime));

    // 2. 「左端」をチェック：10秒以上前の古い注文を窓から追い出す
    // これが while(!set.add) の代わりに時間の計算で行う部分です
    while (!window.isEmpty() && (currentTime - window.peekFirst().timestamp) > WINDOW_SIZE_MS) {
      window.removeFirst(); // 古いデータを削除
    }

    // 3. 現在の窓の状態を表示
    System.out.println("直近10秒以内の注文数: " + window.size());
    return window.size();
  }

  // 注文データ保持用クラス
  private static class Order {
    long id;
    long timestamp;
    Order(long id, long timestamp) { this.id = id; this.timestamp = timestamp; }
  }
}
