package app.idea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q14LongestCommonPrefixTest {

  private final Q14LongestCommonPrefix lcp = new Q14LongestCommonPrefix();

  @ParameterizedTest(name = "Prefix for {0} should be \"{1}\"")
  @MethodSource("providePrefixCases")
  void testLongestCommonPrefix(String[] input, String expected) {
    assertEquals(expected, lcp.longestCommonPrefix(input));
    assertEquals(expected, lcp.longestCommonPrefixV2(input));
  }

  private static Stream<Arguments> providePrefixCases() {
    return Stream.of(
            // Example 1: Standard common prefix
            Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),

            // Example 2: No common prefix
            Arguments.of(new String[]{"dog", "racecar", "car"}, ""),

            // Edge Case: All strings are identical
            Arguments.of(new String[]{"apple", "apple", "apple"}, "apple"),

            // Edge Case: One string is a prefix of the others
            Arguments.of(new String[]{"inter", "interview", "intermediate"}, "inter"),

            // Edge Case: Only one string in the array
            Arguments.of(new String[]{"solitude"}, "solitude"),

            // Edge Case: Empty strings in the array
            Arguments.of(new String[]{"a", "", "b"}, "")
    );
  }

  @Test
  void testNullAndEmptyInput() {
    assertEquals("", lcp.longestCommonPrefix(null), "Should return empty for null");
    assertEquals("", lcp.longestCommonPrefixV2(null), "Should return empty for null");
    assertEquals("", lcp.longestCommonPrefix(new String[]{}), "Should return empty for empty array");
    assertEquals("", lcp.longestCommonPrefixV2(new String[]{}), "Should return empty for empty array");
  }

}
