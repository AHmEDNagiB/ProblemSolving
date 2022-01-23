package smallestPositiveInteger;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder res = new StringBuilder("(");
        for (int i = 0; i <= 9; i++) {
            res.append(numbers[i]);
            if (i == 2)
                res.append(") ") ;
            else if (i == 5)
                res.append("-");
        }
        System.out.println(res);
        return res.toString();
    }
}
