package takeATenMinuteWalk;

public class TenMinWalk {
    public static void main(String[] args) {
        System.out.println(isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        System.out.println(isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        System.out.println(isValid(new char[]{'w'}));
        System.out.println(isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));


    }

    public static boolean isValid(char[] walk) {
        if (walk.length == 10) {
            int numbersOfn = 0, numbersOfs = 0, numbersOfw = 0, numbersOfe = 0;
            for (char dir : walk) {
                switch (dir) {
                    case 'n': {
                        numbersOfn++;
                        break;
                    }
                    case 's':
                        numbersOfs++;
                        break;
                    case 'w':
                        numbersOfw++;
                        break;
                    case 'e':
                        numbersOfe++;
                        break;
                }
            }
            return (numbersOfn == numbersOfs) && (numbersOfw == numbersOfe);
        }
        return false;
    }

}
