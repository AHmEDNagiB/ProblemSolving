public class SmallestPositiveInteger {


    /*
    *
    * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].*/

    public static void main(String[] args) {
        createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }

    public static String createPhoneNumber(int[] numbers) {
        String res = "(";
        for (int i = 0; i <= 9; i++) {
            res += numbers[i];
            if (i == 2)
                res += ") ";
            else if (i == 5)
                res += "-";
        }
        System.out.println(res);
        return res;
    }
}
