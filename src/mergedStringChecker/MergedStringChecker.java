package mergedStringChecker;


public class MergedStringChecker {
    public static void main(String[] args) {
        System.out.println(MergedStringChecker.isMerge("codewars", "code", "wasr"));
    }

    public static boolean isMerge(String s, String part1, String part2) {
        String part1Temp = part1;
        String part2Temp = part2;
        System.out.println( s);
        System.out.println( part1);
        System.out.println( part2);
        if (s.length() == (part1 + part2).length()) {
            if (s.length() != 0 &&  part1.length() != 0&&  part2.length()!= 0 ) {
                for (int i = 0; i < s.length(); i++) {
                    System.out.println( "s : "+s.charAt(i));
                    if (part1Temp.length() != 0 && s.charAt(i) == part1Temp.charAt(0)) {
                        System.out.println( "part1Temp : "+part1Temp.charAt(0));
                        part1Temp = part1Temp.substring(1);
                    } else if (part2Temp.length() != 0 && s.charAt(i) == part2Temp.charAt(0)) {
                        System.out.println( "part2Temp : "+part2Temp.charAt(0));
                        part2Temp = part2Temp.substring(1);
                    } else {
                        return false;
                    }
                }
            } else {
                System.out.println("s'length is 0");
                return true;
            }
        } else {
            return false;
        }
        System.out.println("s is done");
        return true;
    }
}
