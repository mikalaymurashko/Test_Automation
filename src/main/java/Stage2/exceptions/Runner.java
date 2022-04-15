package Stage2.exceptions;

import java.util.*;

public class Runner {

    private static final List<Student> STUDENTS_Z_11 = Arrays.asList(
            new Student(1, "Dmitriy", "Gutcev", Map.of(Subjects.ECONOMICS, 4,
                    Subjects.MANAGEMENT, 6, Subjects.FOREIGN_LANGUAGE, 8)),
            new Student(2, "Ruslan", "Prokopenko",
                    Map.of(Subjects.ECONOMICS, 6, Subjects.MANAGEMENT, 7, Subjects.FOREIGN_LANGUAGE, 3)),
            new Student(3, "Alexey", "Usov",
                    Map.of(Subjects.ECONOMICS, 4, Subjects.MANAGEMENT, 4, Subjects.FOREIGN_LANGUAGE, 9)));
    private static final List<Student> STUDENTS_M_12 = Arrays.asList(
            new Student(4, "Igor", "Struk", Map.of(Subjects.MATH, 5, Subjects.HISTORY, 9,
                    Subjects.ACCOUNTING, 10)),
            new Student(5, "Elena", "Bekerina",
                    Map.of(Subjects.MATH, 8, Subjects.HISTORY, 7, Subjects.ACCOUNTING, 8)),
            new Student(6, "Ekaterina", "Sharova",
                    Map.of(Subjects.MATH, 6, Subjects.HISTORY, 6, Subjects.ACCOUNTING, 7)));
    private static final List<Student> STUDENTS_G_21 = Arrays.asList(
            new Student(7, "Tatiana", "Radionova", Map.of(Subjects.PHYSICAL_EDUCATION, 10,
                    Subjects.INFORMATIONAL_TECHNOLOGIES, 6, Subjects.LOGISTICS, 7)),
            new Student(8, "Daria", "Boichenko", Map.of(Subjects.PHYSICAL_EDUCATION, 10,
                    Subjects.INFORMATIONAL_TECHNOLOGIES, 9, Subjects.LOGISTICS, 9)),
            new Student(9, "Alyona", "Butevich", Map.of(Subjects.PHYSICAL_EDUCATION, 9,
                    Subjects.INFORMATIONAL_TECHNOLOGIES, 8, Subjects.LOGISTICS, 8)));
    private static final List<Student> STUDENTS_V_22 = Arrays.asList(
            new Student(10, "Vasily", "Galperov", Map.of(Subjects.STATISTICS, 10,
                    Subjects.LAW, 8, Subjects.PHILOSOPHY, 4)),
            new Student(11, "Julia", "Pashkevich",
                    Map.of(Subjects.STATISTICS, 9, Subjects.LAW, 8, Subjects.PHILOSOPHY, 8)),
            new Student(12, "Elena", "Mamonova",
                    Map.of(Subjects.STATISTICS, 7, Subjects.LAW, 10, Subjects.PHILOSOPHY, 5)));

    private static final Group Z_11 = new Group("Z-11", STUDENTS_Z_11);
    private static final Group M_12 = new Group("M-12", STUDENTS_M_12);
    private static final Group G_21 = new Group("G-21", STUDENTS_G_21);
    private static final Group V_22 = new Group("V-22", STUDENTS_V_22);
    private static final Faculty economic = new Faculty("Economics and Management",
            Arrays.asList(Z_11, M_12));
    private static final Faculty commercial = new Faculty("Commerce and finance", Arrays.asList(G_21, V_22));
    private static final University bteu = new University("Belorussian Trade and Economics University",
            Arrays.asList(economic, commercial));

    public static void main(String[] args) {
        System.out.println("Gpa of students: " + STUDENTS_Z_11.get(0).getStudentGPA());
        System.out.println(bteu.getFacultyGPA("Economics and Management", "Z-11",
                Subjects.ECONOMICS));
        System.out.println(bteu.subjectGPA(Subjects.ECONOMICS));

        new University("BSUOT", new ArrayList<>());
        new Faculty("Marketing", new ArrayList<>());
        new Student(20, "Anastasia", "Ivanova", Map.of());
        new Student(30, "Oleg", "Petrov", Map.of(Subjects.HISTORY, -1));
        new Group("H-15", List.of());
        new Group("V-22", STUDENTS_V_22).setStudentList(List.of());
        new Faculty("Transport", List.of());
        new Faculty("Architecture", List.of(Z_11, M_12)).setGroupList(List.of());
    }
}
