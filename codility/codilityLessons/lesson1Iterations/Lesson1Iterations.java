package codility.codilityLessons.lesson1Iterations;

    import java.util.concurrent.atomic.AtomicBoolean;
    import java.util.stream.Stream;

public class Lesson1Iterations {
    public static void main(String[] args) {
        System.out.println(solution(9));
        System.out.println(solution(529));
        System.out.println(solution(20 ));
        System.out.println(solution(15));
        System.out.println(solution(32));
        System.out.println("-------------------------");
        System.out.println(calculateBinaryGap(9));
        System.out.println(calculateBinaryGap(529));
        System.out.println(calculateBinaryGap(20 ));
        System.out.println(calculateBinaryGap(15));
        System.out.println(calculateBinaryGap(32));


    }

    public static int solution(int N) {
        AtomicBoolean startsWithOne = new AtomicBoolean(false);
        int[] zeros = new int[]{0, 0};

        Integer.toBinaryString(N).chars().forEach(chr -> {
            if (chr == '1' && !startsWithOne.get()) {
                startsWithOne.set(true);
                zeros[0] = 0;
            } else if (chr == '1' && startsWithOne.get()) {
                zeros[0] = Math.max(zeros[1], zeros[0]);
                zeros[1] = 0;
            }
            else if (chr == '0' && startsWithOne.get()){
                zeros[1] ++;
            }
        });
        return zeros [0];
    }


    // best practise
    static int calculateBinaryGap(int N) {
        return Stream
                .of(
                        // integer to binary string
                        Integer.toBinaryString(N)
                                // trim 0(s) at the end
                                .replaceAll("0+$", "")
                                // split string with 1(s)
                                .split("1+"))
                // lambda expressions: use filter to keep not null elements
                .filter(a -> a != null)
                // method references: convert string to integer by using the
                // length of string
                .map(String::length)
                // method references: find the largest number in the stream by
                // using integer comparator
                .max(Integer::compare)
                // return 0 if nothing matches after the process
                .orElse(0);
    }
}
