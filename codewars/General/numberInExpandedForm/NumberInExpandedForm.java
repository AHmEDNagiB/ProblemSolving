package numberInExpandedForm;

public class NumberInExpandedForm {

    public static void main(String[] args) {

        expandedForm(12);
        System.out.println("***************************************");
        expandedForm(42);
        System.out.println("***************************************");
        expandedForm(70304);
        System.out.println("***************************************");
        expandedForm(1);
        System.out.println("***************************************");
        expandedForm(00);
    }

    public static String expandedForm(int num) {
        int index = 1;
        String res = "";
        boolean addPlus = false;
        while (num > 0) {
            if (num % 10 > 0) {
                if (addPlus) {
                    res = ((num % 10) * index) + " + " + res;
                } else {
                    res = ((num % 10) * index) + "";
                    addPlus=true;
                }
                num = (int) num / 10;
            } else {
                num = (int) num / 10;
            }
            index *= 10;
        }
        System.out.println(res);
        return res;

    }

}
