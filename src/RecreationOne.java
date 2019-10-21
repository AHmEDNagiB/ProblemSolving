/*
Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764.
The sum of the squared divisors is 2500 which is 50 * 50, a square!
Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square.
42 is such a number.
The result will be an array of arrays or of tuples (in C an array of Pair) or a string,
each subArray having two elements, first the number whose squared divisors is a square and then the sum of the squared divisors.
*/

import java.util.ArrayList;

public class RecreationOne {

    public static void main(String[] args) {
        System.out.println(RecreationOne.listSquared(1, 45));
        System.out.println(RecreationOne.listSquared(10, 250));
    }

    public static String listSquared(long m, long n) {
        ArrayList a = new ArrayList();
        ArrayList<Long> b = new ArrayList();
        long sum = 0;
        if (m == 1) {
            b.add((long)1);
            b.add((long)1);
            a.add(b);
            b = new ArrayList();
        }
        for (long j = m; j <= n; j++) {
            for (long i = 1; i <= (j / 2); i++) {
                if (j % i == 0) {
                    sum += i * i;
                }
            }
            sum += j * j;
            if (Math.sqrt(sum) % (int) Math.sqrt(sum) == 0 && sum > 1) {
                b.add(j);
                b.add(sum);
                a.add(b);
                b = new ArrayList();
            }
            sum = 0;
        }
        return a.toString();
    }
}
