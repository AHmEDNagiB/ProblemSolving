package smallestPositiveInteger;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{-5, 50, 3, 8, 3, 5, 7, 1, 6, 9, 10, 2}));
        System.out.println(firstMissingPositiveBestPractice1(new int[]{-5, 50, 3, 8, 3, 5, 7, 1, 6, 9, 10, 2}));

    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> positiveElements = new HashSet();
        for (int element : nums) {
            if (element > 0)
                positiveElements.add(element);
        }
        int i = 1;
        for (; i <= nums.length; i++) {
            if (!positiveElements.contains(i)) return i;
        }
        return i++;
    }


    // https://emre.me/coding-patterns/cyclic-sort/
    public static int firstMissingPositiveBestPractice1(int[] inputArray) {
        int i = 0;
        while (i < inputArray.length) {
            if (inputArray[i] > 0 && inputArray[i] <= inputArray.length && inputArray[i] != inputArray[inputArray[i] - 1]) {
                swap(inputArray, i, inputArray[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != i + 1) {
                return i + 1;
            }
        }
        return inputArray.length + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
