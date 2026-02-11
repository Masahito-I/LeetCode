package app.idea;

public class Q26RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int k = 1; // Index for the "unique" position

    for (int i = 1; i < nums.length; i++) {
      // If the current element is different from the previous unique one
      if (nums[i] != nums[k - 1]) {
        nums[k] = nums[i]; // Move the unique element forward
        k++;
      }
    }

    return k;
  }
}
