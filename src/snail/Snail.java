package snail;

import java.util.ArrayList;
import java.util.List;

public class Snail {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] array2 = new int[][]{{1, 2}, {3, 4}};
        int[][] array3 = new int[][]{{1}, {3}};
        int[][] array4 = new int[][]{{}};
        int[][] array5 = new int[][]{{1, 2, 3, 9}, {4, 5, 6, 4}, {7, 8, 9, 1}, {1, 2, 3, 4}};

        snail(array);
        snail(array2);
        snail(array3);
        snail(array4);
        snail(array5);
    }

    public static int[] snail(int[][] array) {
        if (array.length == 0 || array[0].length == 0)
            return new int[]{};
        List<Integer> visitedValues = new ArrayList<>();
        List<Integer[]> visitedPositions = new ArrayList<>();
        visitedValues.add(array[0][0]);
        visitedPositions.add(new Integer[]{0, 0});
        boolean madeMove = true;
        while (madeMove) {
            madeMove = false;
            Integer[] lastVisitedPositions = visitedPositions.get(visitedPositions.size() - 1);
            while (canGoRight(lastVisitedPositions, visitedPositions, array)) {
                lastVisitedPositions = new Integer[]{lastVisitedPositions[0], lastVisitedPositions[1] + 1};
                makeMove(lastVisitedPositions, visitedValues, visitedPositions, array);
                madeMove = true;
            }
            while (canGoDown(lastVisitedPositions, visitedPositions, array)) {
                lastVisitedPositions = new Integer[]{lastVisitedPositions[0] + 1, lastVisitedPositions[1]};
                makeMove(lastVisitedPositions, visitedValues, visitedPositions, array);
                madeMove = true;
            }
            while (canGoLeft(lastVisitedPositions, visitedPositions)) {
                lastVisitedPositions = new Integer[]{lastVisitedPositions[0], lastVisitedPositions[1] - 1};
                makeMove(lastVisitedPositions, visitedValues, visitedPositions, array);
                madeMove = true;
            }
            while (canGoUp(lastVisitedPositions, visitedPositions)) {
                lastVisitedPositions = new Integer[]{lastVisitedPositions[0] - 1, lastVisitedPositions[1]};
                makeMove(lastVisitedPositions, visitedValues, visitedPositions, array);
                madeMove = true;
            }
        }
//        visitedValues.stream().forEach(System.out::print);
        return visitedValues.stream().mapToInt(i -> i).toArray();
    }

    private static boolean canGoRight(Integer[] lastVisitedPositions, List<Integer[]> visitedPositions, int[][] array) {

        return lastVisitedPositions[1] < array[0].length - 1 &&
                isNextPositionNotVisited(0, 1, lastVisitedPositions, visitedPositions);

    }

    private static boolean canGoDown(Integer[] lastVisitedPositions, List<Integer[]> visitedPositions, int[][] array) {
        return lastVisitedPositions[0] < array.length - 1 &&
                isNextPositionNotVisited(1, 0, lastVisitedPositions, visitedPositions);
    }

    private static boolean canGoLeft(Integer[] lastVisitedPositions, List<Integer[]> visitedPositions) {
        return lastVisitedPositions[1] != 0 &&
                isNextPositionNotVisited(0, -1, lastVisitedPositions, visitedPositions);
    }

    private static boolean canGoUp(Integer[] lastVisitedPositions, List<Integer[]> visitedPositions) {
        return lastVisitedPositions[0] != 0 &&
                isNextPositionNotVisited(-1, 0, lastVisitedPositions, visitedPositions);
    }

    private static boolean isNextPositionNotVisited(final int xMove, final int yMove, Integer[] lastVisitedPositions,
                                                   List<Integer[]> visitedPositions) {
        return visitedPositions.parallelStream().noneMatch(arr ->
                arr[0] == (lastVisitedPositions[0] + xMove) && arr[1] == (lastVisitedPositions[1] + yMove));
    }

    private static void makeMove(Integer[] nextPosition, List<Integer> visitedValues,
                                List<Integer[]> visitedPositions, int[][] array) {
        visitedPositions.add(nextPosition);
        visitedValues.add(array[nextPosition[0]][nextPosition[1]]);

    }

}
