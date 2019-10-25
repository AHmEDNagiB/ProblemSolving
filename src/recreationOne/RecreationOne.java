package recreationOne;

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
            b.add(1l);
            b.add(1l);
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
