package app.idea;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q3LengthOfLongestSubstringTest {

  private final Q3LengthOfLongestSubstring q3LengthOfLongestSubstring = new Q3LengthOfLongestSubstring();

  @ParameterizedTest
  @MethodSource("provideLongestSubstringCases")
  void verifyQ1TwoSumTest(String s, int expected) {
    assertEquals(expected, q3LengthOfLongestSubstring.lengthOfLongestSubstring(s));
  }

  private static Stream<Arguments> provideLongestSubstringCases() {
    return Stream.of(
            Arguments.of("abcabcbb", 3), // "abc"
            Arguments.of("abcb", 3), // "abc"
            Arguments.of("bbbbb", 1),    // "b"
            Arguments.of("pwwkew", 3),   // "wke"
            Arguments.of("", 0),         // Empty string
            Arguments.of(" ", 1),        // Single space
            Arguments.of("aabaab!bb", 3)      // A tricky edge case!
    );
  }

}
