package opgave02;

public class Main {
    public static void main(String[] args) {
        double[][] input = {
                {1, 2, 3, 4.0},
                {5, 6.5, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(avarageMajorDiagonal(input));
    }

    private static double avarageMajorDiagonal(double[][] input) {
        double diagonalSum = 0;
        int count = 0;
        for (int index = 0; index < input.length; index++) {
                diagonalSum += input[index][index];
                count++;
            }
        return diagonalSum/count;
    }

}
