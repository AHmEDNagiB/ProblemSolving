package railFenceCipher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RailFenceCipher {

    public static void main(String[] args) {
        System.out.println(encode("WEAREDISCOVEREDFLEEATONCE", 3));
        System.out.println(encode("WEAREDISCOVEREDFLEEATONCE", 3).equals("WECRLTEERDSOEEFEAOCAIVDEN"));
        System.out.println(encode("Hello, World!",4).equals( "H !e,Wdloollr"));
        System.out.println(decode("WECRLTEERDSOEEFEAOCAIVDEN",3).equals( "WEAREDISCOVEREDFLEEATONCE"));
//        System.out.println(decode("H !e,Wdloollr",4).equals( "Hello, World!"));
    }

    static String encode(String inputString, int n) {
        if (inputString.isEmpty()) return inputString;
        StringBuilder[] rails = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            rails[i] = new StringBuilder();
        }
        boolean isGoingDown = true;
        int step = 0;
        for (int i = 0; i < inputString.length(); i++) {
            rails[step].append(inputString.charAt(i));
            if (isGoingDown) {
                if (step == n-1) {
                    isGoingDown = false;
                }
            } else {
                if (step == 0) {
                    isGoingDown = true;
                }
            }
            if (isGoingDown) {
                step += 1;
            } else {
                step -= 1;
            }
        }
        StringBuilder encodedString = new StringBuilder();
        for (StringBuilder rail : rails) {
            encodedString.append(rail);
        }
        return encodedString.toString();
    }
    static String decode(String inputString, int n) {
        if (inputString.isEmpty()) return inputString;
        List<List<Integer>> rails = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rails.add(i,new ArrayList<>());
        }
        boolean isGoingDown = true;
        int step = 0;
        for (int i = 0; i < inputString.length(); i++) {
            rails.get(step).add(i);
            if (isGoingDown) {
                if (step == n-1) {
                    isGoingDown = false;
                }
            } else {
                if (step == 0) {
                    isGoingDown = true;
                }
            }
            if (isGoingDown) {
                step += 1;
            } else {
                step -= 1;
            }
        }
        List <Integer>indexes = rails.stream().flatMap(Collection::stream).collect(Collectors.toList());
        StringBuilder decodedString = new StringBuilder( inputString);
        for (int i = 0; i < inputString.length(); i++){
            decodedString.setCharAt(indexes.get(i),inputString.charAt(i));
        }


        return decodedString.toString();
    }
}
