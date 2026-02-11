package app.idea;

public class Q21MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode answer = new ListNode(-101);
    ListNode curr = answer;

    while (list1 != null && list2 != null) {

      if (list1.val < list2.val) {
        curr.next = new ListNode(list1.val);
        list1 = list1.next;
      } else {
        curr.next = new ListNode(list2.val);
        list2 = list2.next;
      }
      curr = curr.next;
    }
    curr.next = list1 != null ? list1 : list2;
    return answer.next;
  }
}
