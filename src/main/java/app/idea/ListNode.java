package app.idea;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListNode {
  int val;
  ListNode next;

  ListNode(int val) { this.val = val; }
}
