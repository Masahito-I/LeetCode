package app.idea;

import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum {
  // O(n^2)
  // You are using nested loops. For every element,
  // you iterate through the rest of the array.
  // If the array has 10,000 elements,
  // you could perform up to 100 million comparisons.
  public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i+1; j < numbers.length; j++) {
        if (numbers[i]+numbers[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  // O(n)
  // Using a Hash Map
  public int[] twoSumV2(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      int complement = target - numbers[i]; // 9 - 3 = 4

      if (map.containsKey(complement)) { // if map contains 4,
        return new int[]{ map.get(complement), i}; // returns the value and index i
      }

      map.put(numbers[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
