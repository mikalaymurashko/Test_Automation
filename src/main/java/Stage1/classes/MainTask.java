package Stage1.classes;

import java.text.ParseException;

import static Stage1.classes.Student.*;

public class MainTask {
    public static void main(String[] args) throws ParseException {
        Student student1 = new Student(1, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1990", "Kozhara 61", "+375447474295",
                "economy", 2, "Z-4");
        Student student2 = new Student(2, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1991", "Kozhara 61", "+375447474295",
                "design", 4, "Z-4");
        Student student3 = new Student(3, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1992", "Kozhara 61", "+375447474295",
                "IT", 4, "Z-4");
        Student student4 = new Student(4, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1993", "Kozhara 61", "+375447474295",
                "control", 5, "Z-4");
        Student student5 = new Student(5, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1994", "Kozhara 61", "+375447474295",
                "networks", 4, "Z-4");
        Student student6 = new Student(6, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1991", "Kozhara 61", "+375447474295",
                "design", 2, "Z-1");
        Student student7 = new Student(7, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1992", "Kozhara 61", "+375447474295",
                "design", 4, "Z-2");
        Student student8 = new Student(8, "Murashko", "Nicolai", "Nikolaevich",
                "19.07.1990", "Kozhara 61", "+375447474295",
                "design", 3, "Z-3");

        Student[] students = {student1, student2, student3, student4, student5, student6, student7, student8};
        getStudentsByFaculty(students, "design");
        getStudentsByFacultyAndCource(students, "design", 4);
        getStudentsByDateOfBirth(students, "31.12.1991");
        getStudentsByGroup(students, "Z-4");
    }
}
