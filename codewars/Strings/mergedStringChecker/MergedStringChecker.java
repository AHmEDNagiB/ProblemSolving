package mergedStringChecker;


public class MergedStringChecker {
    public static void main(String[] args) {
        System.out.println(MergedStringChecker.isMerge("Bananas from Bahamas", "Bahas", "Bananas from am"));
        System.out.println(MergedStringChecker.isMerge("codewars", "code", "wars"));
        System.out.println(MergedStringChecker.isMerge("codewars", "cdwr", "oeas"));
        System.out.println(MergedStringChecker.isMerge("codewars", "cod", "wars"));
        System.out.println(MergedStringChecker.isMerge("bxxxxxxb", "bxxx", "xxxb"));
        System.out.println(MergedStringChecker.isMerge("#k?NX\\kyOq)xx0oO6 h*bmE&U^zm", "k?NXyO)xO6 *bEzm", "#\\kqx0ohm&U^"));
    }

    public static boolean isMerge(String s, String part1, String part2) {
        StringBuilder p1 = new StringBuilder(part1);
        StringBuilder p2 = new StringBuilder(part2);
        int matchedIndexes = 0;
        for (int index = 0; index < s.length(); index++) {
            if (p1.length() > matchedIndexes && p2.length() > matchedIndexes &&
                    s.charAt(index) == p1.charAt(matchedIndexes) && s.charAt(index) == p2.charAt(matchedIndexes)) {
                matchedIndexes++;
            } else if (p1.length() > matchedIndexes && s.charAt(index) == p1.charAt(matchedIndexes)) {
                p1.delete(0, matchedIndexes + 1);
                matchedIndexes = 0;
            } else if (p2.length() > matchedIndexes && s.charAt(index) == p2.charAt(matchedIndexes)) {
                p2.delete(0, matchedIndexes + 1);
                matchedIndexes = 0;
            } else if (matchedIndexes > 0 && s.charAt(index) == p1.charAt(0)) {
                p1.delete(0, 1);
                p2.delete(0, matchedIndexes );
                matchedIndexes = 0;
            } else{
                return false;
            }
        }

        return p1.length() == 0 && p2.length() == 0;
    }


    // best practices and it is very awesome
    public static boolean isMerge2(String s, String part1, String part2) {
        if(s.length() != part1.length() + part2.length()) return false;
        if(s.length() == 0) return true;
        return (part1.length() > 0 && part1.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1.substring(1), part2)) ||
                (part2.length() > 0 && part2.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1, part2.substring(1)));
    }

}
