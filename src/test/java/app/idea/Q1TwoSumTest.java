package app.idea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Q1TwoSumTest {

  private final Q1TwoSum q1TwoSum = new Q1TwoSum();

  @ParameterizedTest
  @MethodSource("provideTwoSumCases")
  void verifyQ1TwoSumTest(int[] numbers, int target, int[] expected) {
    assertArrayEquals(expected, q1TwoSum.twoSum(numbers, target));
  }

  @ParameterizedTest
  @MethodSource("provideTwoSumCases")
  void verifyQ1TwoSumTestWithV2(int[] numbers, int target, int[] expected) {
    assertArrayEquals(expected, q1TwoSum.twoSumV2(numbers, target));
  }

  private static Stream<Arguments> provideTwoSumCases() {
    return Stream.of(
      Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
      Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
      Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
      Arguments.of(new int[]{-1, -8, -3, -4}, -11, new int[]{1, 2})
    );
  }

  @Test
  void testTwoSumException() {
    int[] numbers = {1, 2, 3};
    int target = 10;

    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> q1TwoSum.twoSum(numbers, target),
            "Should throw exception when no solution exists"
    );

    assertEquals("No two sum solution", exception.getMessage());
  }

  @Test
  void testTwoSumExceptionV2() {
    int[] numbers = {1, 2, 3};
    int target = 10;

    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> q1TwoSum.twoSumV2(numbers, target),
            "Should throw exception when no solution exists"
    );

    assertEquals("No two sum solution", exception.getMessage());
  }
}
