package app.idea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q28FindIndexOfFirstOccurrenceTest {
  private final Q28FindIndexOfFirstOccurrence solution = new Q28FindIndexOfFirstOccurrence();

  @ParameterizedTest(name = "Index of \"{1}\" in \"{0}\" should be {2}")
  @CsvSource({
          "sadbutsad, sad, 0",        // Example 1: Match at start
          "leetcode, leeto, -1",      // Example 2: No match
          "hello, ll, 2",             // Match in middle
          "mississippi, issip, 4",    // Partial matches before real match
          "abc, abcd, -1",            // Needle longer than haystack
          "aaaaa, bba, -1",           // Completely different characters
          "a, a, 0"                   // Single character match
  })
  void testStrStr(String haystack, String needle, int expected) {
    assertEquals(expected, solution.strStr(haystack, needle));
  }

  @Test
  void testEmptyNeedle() {
    // Standard Java indexOf returns 0 for an empty string.
    // Depending on the requirement, ensure your code handles it.
    assertEquals(0, solution.strStr("any", ""));
  }
}
