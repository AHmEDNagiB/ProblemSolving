package codility.codilityLessons.lesson2.oddOccurrencesInArray;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        System.out.println( solution(new int[]{9, 3, 9, 3, 9, 7, 9}));

    }

    public static int solution(int[] A) {

        Map<Integer,Integer> values = new HashMap<>();
        for (int i = 0; i < A.length; i++) {

            if (values.containsKey(A[i])){
                values.replace(A[i],values.get(A[i])+1);
            }
            else values.put(A[i],1);
        }
         return values.entrySet().parallelStream().filter(s -> (s.getValue() % 2) != 0)
                .findFirst().get().getKey();


    }
}
