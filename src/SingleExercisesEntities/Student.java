package SingleExercisesEntities;

public class Student {

    public String name;
    public double grade1, grade2, grade3, finalGrade, missingPoints;

    public double finalGradeCalc() {
        finalGrade = ((0.30 * grade1) + (0.35 * grade2) + (0.35 * grade3)) / 3;
        return finalGrade;
    }

    public double missingPointsCalc() {
        missingPoints = 60 - finalGrade;
        return missingPoints;
    }

}
