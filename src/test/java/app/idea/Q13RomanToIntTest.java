package app.idea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Q13RomanToIntTest {

  private final Q13RomanToInteger converter = new Q13RomanToInteger();

  @Test
  void testSingleDigits() {
    assertEquals(1, converter.romanToInt("I"));
    assertEquals(5, converter.romanToInt("V"));
    assertEquals(10, converter.romanToInt("X"));
  }

  @ParameterizedTest(name = "Roman {0} should be {1}")
  @CsvSource({
          "III, 3",
          "LVIII, 58",
          "MCMXCIV, 1994",
          "IX, 9",
          "XL, 40",
          "XC, 90",
          "CD, 400",
          "CM, 900",
          "MMXXVI, 2026"
  })
  void testRomanToIntegerConversions(String input, int expected) {
    assertEquals(expected, converter.romanToInt(input));
    assertEquals(expected, converter.romanToIntV2(input));
  }
}
