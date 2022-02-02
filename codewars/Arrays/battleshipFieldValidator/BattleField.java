package battleshipFieldValidator;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class CellIndex {
    int xIndex;
    int yIndex;

    public CellIndex() {
        this.xIndex = 0;
        this.yIndex = 0;
    }

    public CellIndex(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int getxIndex() {
        return xIndex;
    }

    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public int getyIndex() {
        return yIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CellIndex.class.getSimpleName() + "[", "]")
                .add("xIndex=" + xIndex)
                .add("yIndex=" + yIndex)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellIndex cellIndex = (CellIndex) o;
        return xIndex == cellIndex.xIndex && yIndex == cellIndex.yIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xIndex, yIndex);
    }
}

public class BattleField {
    private static final int[][] battleFields2 = {
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private static final int[][] battleFields1 = {
            {0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 1}
    };

    public static void main(String[] args) {
        System.out.println(BattleField.fieldValidator(battleFields2) == true);
    }

    public static boolean fieldValidator(int[][] field) {

        // 10 sets that represent sets of "indexes or fields" of ships : 10 ships each one represented in set of fields
        List<Set<CellIndex>> ships = IntStream.range(0, 10).mapToObj(i -> new HashSet<CellIndex>()).collect(Collectors.toList());

        // Iterate throw the 2 diminution array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] != 0) {
                    // Check that the field doe not contact with other ship
                    if ((leftSideHasValue(field, i, j) && upperSideHasValue(field, i, j)) || upperCornersHasValue(field, i, j)) {
                        return false;
                    } else if (leftSideHasValue(field, i, j) || upperSideHasValue(field, i, j)) {
                        try {
                            addFieldToSet(ships, i, j);
                        } catch (Exception e) {
                            return false;
                        }
                    }
                    //There is no previous connected field
                    else {
                        try {
                            addFieldToFirstEmptySet(ships, i, j);
                        } catch (Exception e) {
                            return false;
                        }
                    }
                }

            }
        }
        Map<Integer, Long> group = ships.stream().collect(Collectors.groupingBy(Set::size, Collectors.counting()));
        return group.getOrDefault(1, 0L) == 4
                && group.getOrDefault(2, 0L) == 3
                && group.getOrDefault(3, 0L) == 2
                && group.getOrDefault(4, 0L) == 1;
    }

    private static void addFieldToSet(List<Set<CellIndex>> ships, int i, int j) throws Exception {
        // Add filed to the correct set
        int finalI = i;
        int finalJ = j;
        Optional<Set<CellIndex>> requiredSet = ships.stream().filter(ship -> ship.contains(new CellIndex(finalI - 1, finalJ))
                || ship.contains(new CellIndex(finalI, finalJ - 1))
        ).findFirst();
        // there is a set that contains a previous connected field
        if (requiredSet.isPresent()) {
            requiredSet.get().add(new CellIndex(i, j));
        } else {
            // There is no set that contains a previous connected field add we add to the 1set empty set
            addFieldToFirstEmptySet(ships, i, j);
        }
    }

    private static void addFieldToFirstEmptySet(List<Set<CellIndex>> ships, int i, int j) throws Exception {
        Optional<Set<CellIndex>> emptySet = ships.stream().filter(Set::isEmpty).findFirst();
        if (emptySet.isPresent()) {
            emptySet.get().add(new CellIndex(i, j));
        } else {
            // There is already 10 ships
            throw new Exception("There is already 10 ships");
        }
    }

    private static boolean leftSideHasValue(int[][] field, int i, int j) {
        return j != 0 && field[i][j - 1] != 0;
    }

    private static boolean upperSideHasValue(int[][] field, int i, int j) {
        return i != 0 && field[i - 1][j] != 0;
    }

    private static boolean upperCornersHasValue(int[][] field, int i, int j) {
        return i != 0 && ((j != 0 && field[i - 1][j - 1] != 0) || (j < field.length - 1 && field[i - 1][j + 1] != 0));
    }
}
