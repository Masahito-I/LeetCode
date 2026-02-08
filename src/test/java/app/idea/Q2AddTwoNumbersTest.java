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
            // Example 1: Standard case
            Arguments.of(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),
            // Example 2: Zeroes
            Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),
            // Example 3: Different lengths and multiple carries
            Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1})
    );
  }

  // --- Helper Methods ---

  private Q2AddTwoNumbers.ListNode toListNode(int[] arr) {
    Q2AddTwoNumbers.ListNode dummy = new Q2AddTwoNumbers.ListNode(0);
    Q2AddTwoNumbers.ListNode curr = dummy;
    for (int val : arr) {
      curr.next = new Q2AddTwoNumbers.ListNode(val);
      curr = curr.next;
    }
    return dummy.next;
  }

  private void assertListEquals(int[] expected, Q2AddTwoNumbers.ListNode actual) {
    for (int val : expected) {
      assertNotNull(actual, "List ended earlier than expected");
      assertEquals(val, actual.val);
      actual = actual.next;
    }
    assertNull(actual, "List is longer than expected");
  }

}
