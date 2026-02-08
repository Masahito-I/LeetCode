package app.idea;

import org.junit.jupiter.api.Test;
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

  @Test
  void testSlidingWindowEviction() {
    long startTime = 1000000; // Arbitrary start time

    // T=0: Add first order
    int windowSize = q3LengthOfLongestSubstring.processNewOrder(101, startTime);
    assertEquals(1, windowSize, "Should have 1 order");

    // T+5s: Add second order (Total 2)
    windowSize = q3LengthOfLongestSubstring.processNewOrder(102, startTime + 5000);
    assertEquals(2, windowSize, "Should have 2 orders");

    // T+11s: Add third order.
    // Order 101 (at T=0) is now 11s old. It should be removed.
    windowSize = q3LengthOfLongestSubstring.processNewOrder(103, startTime + 11000);
    assertEquals(2, windowSize, "Order 101 should have expired");
    // Remaining should be 102 (at T+5s) and 103 (at T+11s)
  }

  @Test
  void testMassiveTimeJumpClearsWindow() {
    q3LengthOfLongestSubstring.processNewOrder(1, 1000);
    q3LengthOfLongestSubstring.processNewOrder(2, 2000);

    // Jump 1 minute into the future
    int windowSize = q3LengthOfLongestSubstring.processNewOrder(3, 70000);

    assertEquals(1, windowSize, "Only the newest order should remain");
  }

  @Test
  void testWhileLoopCoverage() {
    long startTime = 100000;

    // --- Scenario 1: Zero iterations (Window is empty) ---
    // The very first call hits !window.isEmpty() == false
    int size1 = q3LengthOfLongestSubstring.processNewOrder(1, startTime);
    assertEquals(1, size1);

    // --- Scenario 2: Zero iterations (Window not empty, but data is fresh) ---
    // (startTime + 1000) - startTime = 1000. 1000 > 10000 is FALSE.
    int size2 = q3LengthOfLongestSubstring.processNewOrder(2, startTime + 1000);
    assertEquals(2, size2);

    // --- Scenario 3: Multiple iterations (Evicting more than one item) ---
    // We have: Order 1 (T=100s), Order 2 (T=101s)
    // New Order 3 at T=112s.
    // Loop 1: 112 - 100 = 12. 12 > 10 is TRUE. Remove Order 1.
    // Loop 2: 112 - 101 = 11. 11 > 10 is TRUE. Remove Order 2.
    // Loop 3: Window is empty. !window.isEmpty() is FALSE. Stop.
    int size3 = q3LengthOfLongestSubstring.processNewOrder(3, startTime + 12000);
    assertEquals(1, size3, "Should have evicted both previous orders");
  }

  @Test
  void testExactBoundaryCoverage() {
    long startTime = 100000;
    q3LengthOfLongestSubstring.processNewOrder(1, startTime);

    // --- Scenario 4: Boundary check (Exactly 10 seconds) ---
    // 110000 - 100000 = 10000.
    // 10000 > 10000 is FALSE. The loop does NOT run.
    int sizeBoundary = q3LengthOfLongestSubstring.processNewOrder(2, startTime + 10000);
    assertEquals(2, sizeBoundary, "Order at exactly 10s should remain");

    // --- Scenario 5: One iteration ---
    // 110001 - 100000 = 10001.
    // 10001 > 10000 is TRUE. Loop runs ONCE, removes Order 1,
    // then Order 2 is fresh, so loop stops.
    int sizeOneRun = q3LengthOfLongestSubstring.processNewOrder(3, startTime + 10001);
    assertEquals(2, sizeOneRun, "Order 1 should be evicted, 2 and 3 remain");
  }
}
