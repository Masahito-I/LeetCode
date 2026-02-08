package app.idea;

public class Q14LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    for (int i = 0; i < strs[0].length(); i++) {
      char temp = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != temp) {
          return strs[0].substring(0, i);
        }
      }
    }

    return strs[0];
  }

  public String longestCommonPrefixV2(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    // Start with the first string as the prefix
    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
      // While the current string doesn't start with the prefix
      while (strs[i].indexOf(prefix) != 0) {
        // Shorten the prefix by one character from the right
        prefix = prefix.substring(0, prefix.length() - 1);

        // If it becomes empty, there is no common prefix
        if (prefix.isEmpty()) return "";
      }
    }
    return prefix;
  }
}
