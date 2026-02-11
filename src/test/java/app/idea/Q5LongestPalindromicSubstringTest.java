package app.idea;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q5LongestPalindromicSubstringTest {

  private final Q5LongestPalindromicSubstring q5LongestPalindromicSubstring = new Q5LongestPalindromicSubstring();

  @ParameterizedTest
  @MethodSource("palindromeProvider")
  void testLongestPalindrome(String input, String expected) {
    String result = q5LongestPalindromicSubstring.longestPalindrome(input);
    // Palindromes can have multiple valid answers (e.g., "aba" or "bab")
    // but they must be the same length as the expected.
    assertEquals(expected.length(), result.length());
    assertTrue(isPalindrome(result));
  }

  private static Stream<Arguments> palindromeProvider() {
    return Stream.of(
            Arguments.of("babad", "bab"), // "aba" is also valid
            Arguments.of("cbbd", "bb"),
            Arguments.of("a", "a"),
            Arguments.of("ac", "a"),      // or "c"
            Arguments.of("racecar", "racecar"),
            Arguments.of("aaaa", "aaaa"),
            Arguments.of( null, ""),
            Arguments.of( "", "")
    );
  }

  private boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}
