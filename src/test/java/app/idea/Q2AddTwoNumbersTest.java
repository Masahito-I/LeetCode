package app.idea;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Q2AddTwoNumbersTest {

  private final Q2AddTwoNumbers q2AddTwoNumbers = new Q2AddTwoNumbers();

  @ParameterizedTest
  @MethodSource("provideAddTwoNumbersCases")
  void testAddTwoNumbers(int[] l1Array, int[] l2Array, int[] expectedArray) {
    Q2AddTwoNumbers.ListNode l1 = toListNode(l1Array);
    Q2AddTwoNumbers.ListNode l2 = toListNode(l2Array);

    Q2AddTwoNumbers.ListNode result = q2AddTwoNumbers.addTwoNumbers(l1, l2);

    assertListEquals(expectedArray, result);
  }

  private static Stream<Arguments> provideAddTwoNumbersCases() {
    return Stream.of(
            // 1. Existing Example 1: Standard case
            Arguments.of(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),

            // 2. Existing Example 2: The "Just Zeros" case
            Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),

            // 3. The "Carry at the very end" case (Triggers: carry != 0)
            // 5 + 5 = 10 -> [0, 1]
            Arguments.of(new int[]{5}, new int[]{5}, new int[]{0, 1}),

            // 4. L1 shorter than L2 (Triggers: l1 == null && l2 != null)
            // 1 + 99 = 100 -> [0, 0, 1]
            Arguments.of(new int[]{1}, new int[]{9, 9}, new int[]{0, 0, 1}),

            // 5. L2 shorter than L1 (Triggers: l1 != null && l2 == null)
            // 99 + 1 = 100 -> [0, 0, 1]
            Arguments.of(new int[]{9, 9}, new int[]{1}, new int[]{0, 0, 1}),

            // 6. Chain reaction carries (Tests continuous carry != 0)
            // 999 + 1 = 1000 -> [0, 0, 0, 1]
            Arguments.of(new int[]{9, 9, 9}, new int[]{1}, new int[]{0, 0, 0, 1})
    );
  }

  // --- Helper Methods ---

  private Q2AddTwoNumbers.ListNode toListNode(int[] arr) {
    Q2AddTwoNumbers.ListNode dummy = new Q2AddTwoNumbers.ListNode(0);
    Q2AddTwoNumbers.ListNode curr = dummy;
    for (int val : arr) {
      curr.setNext(new Q2AddTwoNumbers.ListNode(val));
      curr = curr.getNext();
    }
    return dummy.getNext();
  }

  private void assertListEquals(int[] expected, Q2AddTwoNumbers.ListNode actual) {
    for (int val : expected) {
      assertNotNull(actual, "List ended earlier than expected");
      assertEquals(val, actual.getVal());
      actual = actual.getNext();
    }
    assertNull(actual, "List is longer than expected");
  }

}
