package app.idea;

public class Q2AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    // Output: [7,0,8]
    // Explanation: 342 + 465 = 807.

    ListNode dummyHead = new ListNode(0); // A placeholder to build the list
    ListNode curr = dummyHead;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      // Get values (use 0 if we've reached the end of one list)
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;

      // Calculate sum and carry
      int sum = x + y + carry;
      carry = sum / 10;

      // Create new node with the digit part (sum % 10)
      curr.next = new ListNode(sum % 10);
      curr = curr.next;

      // Move to the next nodes in l1 and l2
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    return dummyHead.next; // Return the actual list starting after the dummy
  }
}
