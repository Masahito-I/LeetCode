package app.idea;

public class Q9PalindromeNumber {

  // Given an integer x, return true if x is a palindrome,
  // and false otherwise.
  public boolean isPalindrome(int x) {
    String xString = String.valueOf(x);
    for (int i=0;i<xString.length()/2+1;i++) {
      if (xString.charAt(i) != xString.charAt(xString.length()-1-i)) {
        return false;
      }
    }
    return true;
  }
}
