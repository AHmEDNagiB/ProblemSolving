package mexicanWave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class MexicanWave {
    public static void main(String[] args) {

        // starting time
        long start = System.currentTimeMillis();
        System.out.println(Arrays.asList(MexicanWave.wave("hello")));
        System.out.println(Arrays.asList(MexicanWave.wave(" gap ")));
        System.out.println(Arrays.asList(MexicanWave.wave("two words")));
        System.out.println(Arrays.asList(MexicanWave.wave("a b c d e f g h i j k l m n o p q r s t u v w x y z")));
        // ending time
        long end = System.currentTimeMillis();
        System.out.println("time taken by my method " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(Arrays.asList(MexicanWave.wave2("hello")));
        System.out.println(Arrays.asList(MexicanWave.wave2(" gap ")));
        System.out.println(Arrays.asList(MexicanWave.wave2("two words")));
        System.out.println(Arrays.asList(MexicanWave.wave("a b c d e f g h i j k l m n o p q r s t u v w x y z")));
        end = System.currentTimeMillis();
        System.out.println("time taken by best practice method " + (end - start) + "ms");

    }

    public static String[] wave(String str) {
        List<String> wave = new ArrayList<>();
        String upperStr = str.toUpperCase();
        IntStream.range(0, str.length())
                .forEach(index -> {
                    if (upperStr.charAt(index) != ' ') {
                        StringBuilder s = new StringBuilder(str);
                        s.setCharAt(index, upperStr.charAt(index));
                        wave.add(s.toString());
                    }
                });
        return wave.stream().toArray(String[]::new);
    }


    // best Practise
    public static String[] wave2(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(n -> new StringBuilder(str)
                        .replace(n, n + 1, Character.toString(Character.toUpperCase(str.charAt(n)))).toString())
                .filter(a -> !a.equals(str))
                .toArray(String[]::new);
    }

}