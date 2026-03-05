package opgave04;

import opgave04.model.Absence;

public class Main {
    public static void main(String[] args) {
        Absence absence = new Absence();

        absence.print();
        System.out.println();

        System.out.println("Student 3 total absence: " + absence.totalAbsence(3));

        System.out.println("Student 3 average absence: " + absence.average(3));

        System.out.println("Number of student without absence: " + absence.studentWithoutAbsence());

        System.out.println("Studentnumber for student with the most absence: " + absence.mostAbsence());

        absence.reset(5);
        System.out.println("Reset student 5");
        absence.print();

    }
}
