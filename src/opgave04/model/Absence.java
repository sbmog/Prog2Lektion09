package opgave04.model;

public class Absence {
    private int[][] absenceSchema = {
            {2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0},
            {1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0},
            {5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0}
    };

    public void print() {
        System.out.printf("%-4s", " ");
        for (int index = 0; index < absenceSchema[0].length; index++) {
            System.out.printf("%-4d", index + 1);
        }
        System.out.println();
        for (int outer = 0; outer < absenceSchema.length; outer++) {
            System.out.printf("%-4d", outer + 1);
            for (int inner = 0; inner < absenceSchema[outer].length; inner++) {
                System.out.printf("%-4d", absenceSchema[outer][inner]);
            }
            System.out.println();
        }
    }

    public int totalAbsence(int studentNumber) {
        int outer = studentNumber - 1;
        int sum = 0;
        for (int inner = 0; inner < absenceSchema[outer].length; inner++) {
            sum += absenceSchema[outer][inner];
        }
        return sum;
    }

    public double average(int studentNumber) {
        int outer = studentNumber - 1;
        int count = 0;
        double sum = 0;

        for (int inner = 0; inner < absenceSchema[outer].length; inner++) {
            sum += absenceSchema[outer][inner];
            count++;
        }
        // return sum/count;
        return (double) totalAbsence(studentNumber) / absenceSchema[studentNumber - 1].length;
        //Bedre håndtering, pga. kodegenbrug
    }

    public int studentWithoutAbsence() {
        int numberOfStudent = 0;
        for (int outer = 0; outer < absenceSchema.length; outer++) {
            int count = 0;
            for (int inner = 0; inner < absenceSchema[outer].length; inner++) {
                count += absenceSchema[outer][inner];
            }
            if (count == 0) {
                numberOfStudent++;
            }
        }
        return numberOfStudent;
    }

    public int mostAbsence() {
        int studentWithMostAbsence = 0;
        int mostAbsence = 0;
        for (int outer = 0; outer < absenceSchema.length; outer++) {
            int absence = totalAbsence(outer + 1);
            if (absence > mostAbsence) {
                mostAbsence = absence;
                studentWithMostAbsence = outer + 1;
            }
        }

        return studentWithMostAbsence;
    }

    public void reset(int studentNumber) {
        int outer = studentNumber - 1;
        for (int inner = 0; inner < absenceSchema[outer].length; inner++) {
            absenceSchema[outer][inner] = 0;
        }
    }
}
