package app.idea;

import java.util.HashMap;
import java.util.Map;

public class Q13RomanToInteger {

  //  Roman numerals are represented by seven different symbols:
  //  I, V, X, L, C, D and M.
  // Symbol       Value
  // I             1
  // V             5
  // X             10
  // L             50
  // C             100
  // D             500
  // M             1000
  // It is guaranteed that s is a valid roman numeral in the range [1, 3999].
  public int romanToInt(String s) {
    int answer = 0;
    int prevValue = 0;

    for (int i = s.length() - 1; i >=0; i--) {
      int currentValue = switch (s.charAt(i)) {
        case 'M' -> 1000;
        case 'D' -> 500;
        case 'C' -> 100;
        case 'L' -> 50;
        case 'X' -> 10;
        case 'V' -> 5;
        case 'I' -> 1;
        default -> throw new IllegalArgumentException("Invalid Roman character");
      };
      // The Golden Rule: If the current value is less than the
      // value to its right, it must be subtracted.
      answer += currentValue < prevValue ? -currentValue : currentValue;
      prevValue = currentValue;
    }
    return answer;
  }

  // The performance is worse than above but a Map is often seen as more "pluggable" than a large switch block.
  // This is the "Interview Choice"—it’s easier to explain to a recruiter in 30 seconds
  // because it follows the natural reading order.
  public int romanToIntV2(String s) {
    Map<Character, Integer> romanMap = new HashMap<>();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    int total = 0;
    int n = s.length();

    for (int i = 0; i < n; i++) {
      int currentVal = romanMap.get(s.charAt(i));

      // If this is not the last character and the next character is larger
      if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
        total -= currentVal;
      } else {
        total += currentVal;
      }
    }
    return total;
  }
}
