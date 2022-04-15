package Stage2.exceptions;

import Stage2.exceptions.exceptions.NoFacultiesInUniversityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private List<Faculty> facultiesList;

    public University(String name, List<Faculty> facultiesList) {
        this.name = name;
        try {
            if (facultiesList.isEmpty()) {
                throw new NoFacultiesInUniversityException("There are no faculties in the university");
            } else {
                this.facultiesList = facultiesList;
            }
        } catch (NoFacultiesInUniversityException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFacultiesList() {
        return facultiesList;
    }

    public void setFacultiesList(List<Faculty> facultiesList) {
        try {
            if (facultiesList.isEmpty()) {
                throw new NoFacultiesInUniversityException("There are no faculties in the university");
            } else {
                this.facultiesList = facultiesList;
            }
        } catch (NoFacultiesInUniversityException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getFacultyGPA(String facultyName, String groupName, Subjects subject) {
        Faculty faculty = null;
        Group group = null;
        int sum = 0;
        List<Integer> marks = new ArrayList<>();

        for (Faculty f : facultiesList) {
            if (facultyName.equals(f.getFacultyName())) {
                faculty = f;
                break;
            }
        }
        for (Group g : faculty.getGroupList()) {
            if (groupName.equals(g.getGroupName())) {
                group = g;
                break;
            }
        }
        for (Student student : group.getStudentList()) {
            if (student.getGradeBook().containsKey(subject)) {
                Integer i = student.getGradeBook().get(subject);
                marks.add(i);
            }
        }
        for (Integer mark : marks) {
            sum += mark;
        }
        double facultyGPA = (double) sum / marks.size();
        return Math.round(facultyGPA * 100.0) / 100.0;
    }

    public double subjectGPA(Subjects subject) {
        int sum = 0;
        List<Integer> marks = new ArrayList<>();
        for (Faculty faculty : facultiesList) {
            for (Group group : faculty.getGroupList()) {
                for (Student student : group.getStudentList()) {
                    if (student.getGradeBook().containsKey(subject)) {
                        Integer i = student.getGradeBook().get(subject);
                        marks.add(i);
                    }
                }
            }
        }
        for (Integer mark : marks) {
            sum += mark;
        }
        double subjectGPA = (double) sum / marks.size();
        return Math.round(subjectGPA * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) && Objects.equals(facultiesList, that.facultiesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, facultiesList);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", facultiesList=" + facultiesList +
                '}';
    }
}
