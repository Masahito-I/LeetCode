package app.idea;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Q21MergeTwoSortedListsTest {

  private final Q21MergeTwoSortedLists q21MergeTwoSortedLists = new Q21MergeTwoSortedLists();

  @ParameterizedTest
  @MethodSource("provideMergeCases")
  void testMergeTwoLists(int[] arr1, int[] arr2, int[] expected) {
    ListNode l1 = toListNode(arr1);
    ListNode l2 = toListNode(arr2);

    ListNode result = q21MergeTwoSortedLists.mergeTwoLists(l1, l2);

    assertListEquals(expected, result);
  }

  private static Stream<Arguments> provideMergeCases() {
    return Stream.of(
            // Example 1: Standard case
            Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),

            // Example 2: Both empty
            Arguments.of(new int[]{}, new int[]{}, new int[]{}),

            // Example 3: One empty
            Arguments.of(new int[]{}, new int[]{0}, new int[]{0}),

            // Edge Case: Different lengths
            Arguments.of(new int[]{1, 5}, new int[]{1, 2, 3, 4}, new int[]{1, 1, 2, 3, 4, 5}),

            // Edge Case: Negative numbers
            Arguments.of(new int[]{-10, -5, 0}, new int[]{-8, 2}, new int[]{-10, -8, -5, 0, 2})
    );
  }

  // --- Helper Methods ---

  private ListNode toListNode(int[] arr) {
    if (arr == null || arr.length == 0) return null;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    for (int val : arr) {
      curr.next = new ListNode(val);
      curr = curr.next;
    }
    return dummy.next;
  }

  private void assertListEquals(int[] expected, ListNode actual) {
    if (expected.length == 0) {
      assertNull(actual);
      return;
    }
    for (int val : expected) {
      assertNotNull(actual, "List ended earlier than expected");
      assertEquals(val, actual.val);
      actual = actual.next;
    }
    assertNull(actual, "List is longer than expected");
  }
}
