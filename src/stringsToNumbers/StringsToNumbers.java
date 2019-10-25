package stringsToNumbers;

import java.util.HashMap;
import java.util.Map;

public class StringsToNumbers {
    private static final Map<String, Integer> names = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
        System.out.println(parseInt("twenty"));
        System.out.println(parseInt("two hundred two"));

    }

    private static void initMap() {
        names.put("zero", 0);     names.put("ten", 10);     names.put("twenty", 20);
        names.put("one", 1);      names.put("eleven", 11);     names.put("thirty", 30);
        names.put("two", 2);      names.put("twelve", 12);     names.put("forty", 40);
        names.put("three", 3);    names.put("thirteen", 13);     names.put("fifty", 50);
        names.put("four", 4);     names.put("fourteen", 14);     names.put("sixty", 60);
        names.put("five", 5);     names.put("fifteen", 15);     names.put("seventy", 70);
        names.put("six", 6);     names.put("sixteen", 16);     names.put("eighty", 80);
        names.put("seven", 7);     names.put("seventeen", 17);     names.put("ninety", 90);
        names.put("eight", 8);     names.put("eighteen", 18);
        names.put("nine", 9);     names.put("nineteen", 19);

    }
    private static int parseInt(String numStr) {
        initMap();
        int sum = 0;
        int thousands = 0;
        int hundreds = 0;
        int millions = 0;
        String[] numbers = numStr.split("-|\\s");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("millions")||numbers[i].equals("million")) {
                millions = sum * 1000000;
                sum = 0;
            }
            else if (numbers[i].equals("thousand")) {
                thousands = sum * 1000;
                sum = 0;
            } else if (thousands > 0 && numbers[i].equals("hundred")) {
                hundreds = sum * 100;
                sum = 0;
            }
            else if ( numbers[i].equals("hundred")){
                sum *= 100;
            }
            else {
            sum += names.getOrDefault(numbers[i].trim().toLowerCase(), 0);

            }
        }
        return millions +thousands + hundreds + sum;
    }
}
