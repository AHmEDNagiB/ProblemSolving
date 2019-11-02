package codility.codilityLessons.lesson2.cyclicRotation;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] a1 = solution(new int[]{1, 2, 3, 4}, 5);
        for (int a : a1) {
            System.out.println(a);

        }
    }

    public static int[] solution(int[] A, int K) {

        int[] result = new int[A.length];

        for (int index = 0; index < A.length; index++) {
            result[getNextIndex(index, K, A.length)] = A[index];
        }
        return result;
    }

    public static int getNextIndex(int currentIndex, int k, int arrayLength) {
        int nextIndex = k + currentIndex;
        if (nextIndex > arrayLength - 1) {

            while (nextIndex > arrayLength - 1) {
                nextIndex = nextIndex - arrayLength;
            }
            return nextIndex;

        } else return nextIndex;
    }
}
