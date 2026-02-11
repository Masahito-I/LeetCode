package app.idea;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q26RemoveDuplicatesFromSortedArrayTest {

  private final Q26RemoveDuplicatesFromSortedArray q26RemoveDuplicatesFromSortedArray = new Q26RemoveDuplicatesFromSortedArray();

  @ParameterizedTest
  @MethodSource("provideArrays")
  void testRemoveDuplicates(int[] nums, int expectedK, int[] expectedArray) {
    int k = q26RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

    // Verify the number of unique elements
    assertEquals(expectedK, k);

    // Verify the first k elements of the array
    for (int i = 0; i < k; i++) {
      assertEquals(expectedArray[i], nums[i], "Mismatch at index " + i);
    }
  }

  private static Stream<Arguments> provideArrays() {
    return Stream.of(
            // nums, expectedK, expectedFirstKElements
            Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
            Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, 5, new int[]{0,1,2,3,4}),
            Arguments.of(new int[]{1, 2, 3}, 3, new int[]{1, 2, 3}),
            Arguments.of(new int[]{1, 1, 1}, 1, new int[]{1}),
            Arguments.of(new int[]{}, 0, new int[]{}),
            Arguments.of(new int[]{1}, 1, new int[]{1})
    );
  }

}
