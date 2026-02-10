package app.idea;



public class Q5LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return "";
    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
      // Case 1: Odd length (e.g., "aba", center is 'b')
      int len1 = expandAroundCenter(s, i, i);
      // Case 2: Even length (e.g., "abba", center is between 'b' and 'b')
      int len2 = expandAroundCenter(s, i, i + 1);

      int len = Math.max(len1, len2);

      // If we found a new longest palindrome, update our boundaries
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    // Why -1? Because the loop ends when characters DON'T match or out of bounds
    return right - left - 1;
  }
}
