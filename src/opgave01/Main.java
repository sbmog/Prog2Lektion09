package opgave01;

public class Main {
    private char[][] input = {
            {'M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'},
            {'M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'},
            {'A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'},
            {'M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'},
            {'X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'},
            {'X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'},
            {'S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'},
            {'S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'},
            {'M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'},
            {'M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X'}
    };

    public static void main(String[] args) {
        Main main = new Main();
        int count = main.countXMAS();
        System.out.println("Antal forekomster af 'XMAS': " + count);
    }

    private int countXMAS() {
        int count = 0;
        int outer = input.length;
        int inner = input[0].length;


        int[][] directions = {
                {0, 1},   // Højre
                {1, 0},   // Nedad
                {1, 1},   // Diagonal ned-højre
                {1, -1},  // Diagonal ned-venstre
                {0, -1},  // Venstre
                {-1, 0},  // Opad
                {-1, 1},  // Diagonal op-højre
                {-1, -1}  // Diagonal op-venstre
        };

        for (int outerIndex = 0; outerIndex < outer; outerIndex++) {
            for (int innerIndex = 0; innerIndex < inner; innerIndex++) {
                if (input[outerIndex][innerIndex] == 'X') {
                    for (int[] direction : directions) {
                        if (checkXMAS(outerIndex, innerIndex, direction[0], direction[1])) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean checkXMAS(int outerIndex, int innerIndex, int outerDirection, int innerDirection) {
        int outer = input.length;
        int inner = input[0].length;
        String word = "XMAS";

        for (int index = 0; index < word.length(); index++) {
            int newOuterIndex = outerIndex + index * outerDirection;
            int newInnerIndex = innerIndex + index * innerDirection;

            if (newOuterIndex < 0 ||
                    newOuterIndex >= outer ||
                    newInnerIndex < 0 ||
                    newInnerIndex >= inner) {
                return false;
            }

            if (input[newOuterIndex][newInnerIndex] != word.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
