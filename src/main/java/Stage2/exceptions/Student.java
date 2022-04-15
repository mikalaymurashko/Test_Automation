package Stage2.exceptions;

import Stage2.exceptions.exceptions.GradeException;
import Stage2.exceptions.exceptions.NoSubjectsException;

import java.util.*;

public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private Map<Subjects, Integer> gradeBook;

    public Student(int id, String firstName, String secondName, Map<Subjects, Integer> gradeBook) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        if (checkGradeBook(gradeBook)) {
            this.gradeBook = gradeBook;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Map<Subjects, Integer> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(Map<Subjects, Integer> gradeBook) {
        if (checkGradeBook(gradeBook)) {
            this.gradeBook = gradeBook;
        }
    }

    public double getStudentGPA() {
        List<Integer> marks = new ArrayList<>(this.getGradeBook().values());
        int sum = 0;
        for (Integer mark : marks) {
            sum += mark;
        }
        double studentGPA = (double) sum / marks.size();
        return Math.round(studentGPA * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) &&
                Objects.equals(secondName, student.secondName) && Objects.equals(gradeBook, student.gradeBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, gradeBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gradeBook=" + gradeBook +
                '}';
    }

    private boolean checkGradeBook(Map<Subjects, Integer> gradeBook) {
        try {
            if (gradeBook.keySet().isEmpty()) {
                throw new NoSubjectsException("Student doesn't have subjects");
            } else if (!marksValid(gradeBook)) {
                throw new GradeException("Mark can't be < 0 or > 10");
            }
        } catch (NoSubjectsException | GradeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean marksValid(Map<Subjects, Integer> gradeBook) {
        for (Integer mark : gradeBook.values()) {
            if (mark < 0 || mark > 10) {
                return false;
            }
        }
        return true;
    }
}
