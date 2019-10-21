/*
In this kata you have to write a simple Morse code decoder.
 While the Morse code is now mostly superceded by voice and digital data communication channels,
 it still has its use in some applications around the world.
The Morse code encodes every character as a sequence of "dots" and "dashes".
For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−.
The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code,
a single space is used to separate the character codes and 3 spaces are used to separate words.
 For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.

NOTE: Extra spaces before or after the code have no meaning and should be ignored.

In addition to letters, digits and some punctuation, there are some special service codes,
 the most notorious of those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···.
  These special codes are treated as single special characters, and usually are transmitted as separate words.

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.

For example:

MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
//should return "HEY JUDE"
NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.

The Morse code table is preloaded for you as a dictionary, feel free to use it. In CoffeeScript,
C++, Go, JavaScript, PHP, Python, Ruby and TypeScript, the table can be accessed like this: MORSE_CODE['.--'],
in Java it is MorseCode.get(".--"), in C# it is MorseCode.Get(".--") (returns string),
 in Haskell the codes are in a Map String String and can be accessed like this: morseCodes ! ".--",
 in Elixir it is morse_codes variable, in Rust it is self.morse_code.

All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions.
In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise
the engine would simply ignore the tests, resulting in a "valid" solution.
* */

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
