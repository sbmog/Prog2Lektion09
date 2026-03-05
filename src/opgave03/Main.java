package opgave03;

public class Main {
    public static void main(String[] args) {
        double[][] input = {
                {23.5, 35, 2, 10},
                {4.5, 3, 45, 3.5},
                {35, 44, 5.5, 9.6}
        };
        int[] result = locateSmallest(input);
        System.out.println("Mindste tal er i " + result[0] + ", " + result[1]);
    }

    private static int[] locateSmallest(double[][] input) {
        double smallestInput = Double.MAX_VALUE;
        int [] smallestInputIndex = new int[2];

        for (int outer = 0; outer < input.length; outer++) {
            for (int inner = 0; inner < input[outer].length; inner++) {
                if (smallestInput > input[outer][inner]) {
                    smallestInput = input[outer][inner];
                    smallestInputIndex[0] = inner;
                    smallestInputIndex[1] = outer;
                }
            }
        }
        return smallestInputIndex;
        //Dårlig metode signatur, da det ikke fortæller noget om indholdet, med mindre man nærstudere indholdet.
        //Hvis nogen vil forsøge at tilgå et index, som ej er der, vil det resultere i outerbound.
        //Hellere gøre det via feltvariabler/attributter i selve klassen.
    }
}
