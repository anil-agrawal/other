package assignments.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = new int[] { 1, 0, 6, 2, 1, 0, 2, 0, 13 };
		System.out.println("Data is : " + Arrays.asList(array));
		System.out.println("Max product of contiguous subarray is : " + solution.maxProduct(array));
	}

	static class Solution {
		public int maxProduct(int[] nums) {
			List<Integer> zeroLocations = new ArrayList<Integer>();
			List<Integer> negativeLocations = new ArrayList<Integer>();
			int product = 1;
			for (int loc = 0; loc < nums.length; loc++) {
				if (nums[loc] == 0) {
					zeroLocations.add(loc);
				} else if (nums[loc] < 0) {
					negativeLocations.add(loc);
				}
				product *= nums[loc];
			}

			// Case 1 : No zero with no negative values
			if (zeroLocations.isEmpty() && negativeLocations.isEmpty()) {
				// Do nothing (Product of all elements already calculated)
				return product;
			}

			// Case 2 : No zero with even number of negative values
			if (zeroLocations.isEmpty() && negativeLocations.size() % 2 == 0) {
				// Do nothing (Product of all elements already calculated)
				return product;
			}

			// Case 3 : No zero with odd number of negative values (first/last value is negative)
			if (zeroLocations.isEmpty() && negativeLocations.size() % 2 != 0 && (nums[0] < 0 || nums[nums.length - 1] < 0)) {
				// Divide by negative number
				if (nums[nums.length - 1] < 0) {
					product = product / nums[nums.length - 1];
				} else {
					product = product / nums[0];
				}
				return product;
			}

			// Case 4 : No zero with odd number of negative values (negative values are somewhere in middle)
			if (zeroLocations.isEmpty() && negativeLocations.size() % 2 != 0) {
				int[][] results = new int[4][3];
				int resultCounter = -1;
				int tempProd = 1;
				int firstNegativeValueIndex = negativeLocations.get(0);

				// Find products of all numbers before and after firstNegativeValueIndex
				// separately
				for (int loc = 0; loc < nums.length; loc++) {
					if (loc == 0 || loc == firstNegativeValueIndex + 1) {
						results[++resultCounter][0] = loc;
						tempProd *= nums[loc];
					} else if (loc < firstNegativeValueIndex || loc > firstNegativeValueIndex) {
						tempProd *= nums[loc];
						results[resultCounter][1] = loc;
						results[resultCounter][2] = tempProd;
					} else if (loc == firstNegativeValueIndex) {
						tempProd = 1;
					}
				}
				product = results[0][2] > results[1][2] ? results[0][2] : results[1][2];

				tempProd = 1;
				int lastNegativeValueIndex = negativeLocations.get(negativeLocations.size() - 1);
				// Find products of all numbers before and after lastNegativeValueIndex separately
				if (lastNegativeValueIndex != firstNegativeValueIndex) {
					for (int loc = 0; loc < nums.length; loc++) {
						if (loc == 0 || loc == lastNegativeValueIndex + 1) {
							results[++resultCounter][0] = loc;
							tempProd *= nums[loc];
						} else if (loc < lastNegativeValueIndex || loc > lastNegativeValueIndex) {
							tempProd *= nums[loc];
							results[resultCounter][1] = loc;
							results[resultCounter][2] = tempProd;
						} else if (loc == lastNegativeValueIndex) {
							tempProd = 1;
						}
					}
					int prod2 = results[2][2] > results[3][2] ? results[2][2] : results[3][2];
					product = product > prod2 ? product : prod2;
				}
				return product;
			}

			// Case 5 : Zero with no negative values
			if (!zeroLocations.isEmpty() && negativeLocations.isEmpty()) {
				int[][] results = new int[zeroLocations.size() + 1][3];
				int resultCounter = -1;
				int tempProd = 1;

				// Find products of all numbers before and after zero values separately
				if (nums[0] == 0) {
					results[++resultCounter][0] = 0;
					results[resultCounter][1] = 0;
					results[resultCounter][2] = 0;
				} else {
					results[++resultCounter][0] = 0;
				}
				for (int loc = 0; loc < nums.length; loc++) {
					if (zeroLocations.contains(loc)) {
						results[resultCounter][1] = loc - 1;
						results[resultCounter][2] = tempProd;
						results[++resultCounter][0] = loc + 1;
						tempProd = 1;
					} else {
						tempProd *= nums[loc];
						results[resultCounter][1] = loc;
						results[resultCounter][2] = tempProd;
					}
				}
				product = 0;
				for (int counter = 0; counter <= zeroLocations.size(); counter++) {
					product = product > results[counter][2] ? product : results[counter][2];
				}
				return product;
			}

			// Case 6 : Zero with negative values
			if (!zeroLocations.isEmpty() && !negativeLocations.isEmpty()) {
				return 0;
			}
			return product;
		}
	}

}
