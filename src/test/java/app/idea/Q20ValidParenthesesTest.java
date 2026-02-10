package app.idea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Q20ValidParenthesesTest {
  private final Q20ValidParentheses validator = new Q20ValidParentheses();

  @ParameterizedTest(name = "Input \"{0}\" should be valid: {1}")
  @CsvSource({
          "(), true",
          "()[]{}, true",
          "(], false",
          "([)], false",
          "({[]}), true",
          "((, false",
          ")), false",
          "{[]}, true"
  })
  void testIsValid(String input, boolean expected) {
    assertEquals(expected, validator.isValid(input));
  }

  @Test
  void testEmptyString() {
    // Technically an empty string is often considered valid in these problems
    assertTrue(validator.isValid(""));
  }

  @Test
  void testSingleCharacter() {
    assertFalse(validator.isValid("("));
    assertFalse(validator.isValid("]"));
  }
}
