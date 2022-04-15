package Stage1.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    public Student() {
    }

    public Student(int id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Student(int id, String lastName, String firstName, String middleName, String dateOfBirth, String address,
                   String phoneNumber, String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static void getStudentsByFaculty(Student[] students, String faculty) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].faculty.equals(faculty)) {
                System.out.println(students[i]);
            }
        }
    }

    public static void getStudentsByFacultyAndCource(Student[] students, String faculty, int course) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].faculty.equals(faculty)) {
                System.out.println(students[i]);
            }
            if (students[i].course == course) {
                System.out.println(students[i]);
            }
        }
    }

    public static void getStudentsByDateOfBirth(Student[] students, String dateOfBirth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse(dateOfBirth);
        for (int i = 0; i < students.length; i++) {
            Date studentBirthDate = sdf.parse(students[i].dateOfBirth);
            if (date.compareTo(studentBirthDate) < 0) {
                System.out.println(students[i].toString());
            }
        }
    }

    public static void getStudentsByGroup(Student[] students, String group) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].group.equals(group)) {
                System.out.println(students[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                '}';
    }
}
