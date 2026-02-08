package app.idea;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Q9PalindromeNumberTest {

  private final Q9PalindromeNumber q9PalindromeNumber = new Q9PalindromeNumber();

  @ParameterizedTest
  @MethodSource("provideAddTwoNumbersCases")
  void testAddTwoNumbers(int x, boolean expected) {
    boolean result = q9PalindromeNumber.isPalindrome(x);
    assertEquals(expected, result);
  }

  private static Stream<Arguments> provideAddTwoNumbersCases() {
    return Stream.of(
            // Example 1: Standard case
            Arguments.of(121, true),
            // Example 2: Zeroes
            Arguments.of(-121, false),
            // Example 3: Different lengths
            Arguments.of(10, false)
    );
  }

}
