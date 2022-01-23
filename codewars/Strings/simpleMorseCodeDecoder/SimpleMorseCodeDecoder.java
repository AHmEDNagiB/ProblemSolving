package simpleMorseCodeDecoder;
import numberInExpandedForm.NumberInExpandedForm;

import java.util.HashMap;
import java.util.Map;

public class SimpleMorseCodeDecoder {

    public static Map<String, String> MorseCode = new HashMap<String, String>();


    public static void main(String[] args) {

        System.out.println(decode(" ."));
        NumberInExpandedForm.expandedForm(12);
        System.out.print("***************************************");
        NumberInExpandedForm.expandedForm(42);
        System.out.print("***************************************");
        NumberInExpandedForm.expandedForm(70304);
    }

    public static String decode(String morseCode) {
        MorseCode.put("A", ".-");
        MorseCode.put(".-", "A");
        MorseCode.put("I", "..");
        MorseCode.put("..", "I");
        MorseCode.put("Q", "--.-");
        MorseCode.put("--.-", "Q");
        MorseCode.put("Y", "-.--");
        MorseCode.put("-.--", "Y");
        MorseCode.put("6", "-....");
        MorseCode.put("-....", "6");
        MorseCode.put("B", "-...");
        MorseCode.put("-...", "B");
        MorseCode.put("J", ".---");
        MorseCode.put(".---", "J");
        MorseCode.put("R", ".-.");
        MorseCode.put(".-.", "R");
        MorseCode.put("Z", "--..");
        MorseCode.put("--..", "Z");
        MorseCode.put("7", "--...");
        MorseCode.put("--...", "7");
        MorseCode.put("C", "-.-.");
        MorseCode.put("-.-.", "C");
        MorseCode.put("K", "-.-");
        MorseCode.put("-.-", "K");
        MorseCode.put("S", "...");
        MorseCode.put("...", "S");
        MorseCode.put("9", "----.");
        MorseCode.put("----.", "9");
        MorseCode.put("8", "---..");
        MorseCode.put("---..", "8");
        MorseCode.put("D", "-..");
        MorseCode.put("-..", "D");
        MorseCode.put("L", ".-..");
        MorseCode.put(".-..", "L");
        MorseCode.put("T", "-");
        MorseCode.put("-", "T");
        MorseCode.put("1", ".----");
        MorseCode.put(".----", "1");
        MorseCode.put("0", "-----");
        MorseCode.put("-----", "0");
        MorseCode.put("E", ".");
        MorseCode.put(".", "E");
        MorseCode.put("M", "--");
        MorseCode.put("--", "M");
        MorseCode.put("U", "..-");
        MorseCode.put("..-", "U");
        MorseCode.put("2", "..---");
        MorseCode.put("..---", "2");
        MorseCode.put("F", "..-.");
        MorseCode.put("..-.", "F");
        MorseCode.put("N", "-.");
        MorseCode.put("-.", "N");
        MorseCode.put("V", "...-");
        MorseCode.put("...-", "V");
        MorseCode.put("3", "...--");
        MorseCode.put("...--", "3");
        MorseCode.put("G", "--.");
        MorseCode.put("--.", "G");
        MorseCode.put("O", "---");
        MorseCode.put("---", "O");
        MorseCode.put("W", ".--");
        MorseCode.put(".--", "W");
        MorseCode.put("4", "....-");
        MorseCode.put("....-", "4");
        MorseCode.put("H", "....");
        MorseCode.put("....", "H");
        MorseCode.put("P", ".--.");
        MorseCode.put(".--.", "P");
        MorseCode.put("X", "-..-");
        MorseCode.put("-..-", "X");
        MorseCode.put("5", ".....");
        MorseCode.put(".....", "5");
        String res = "";
        String words[] = morseCode.trim().split("   ");
        for (String word : words) {
            String chars[] = word.split(" ");
            for (String charc : chars) {
                res += MorseCode.get(charc);
            }
            res += " ";

        }
        return res.trim();
    }
}
