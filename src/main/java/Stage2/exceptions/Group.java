package Stage2.exceptions;

import Stage2.exceptions.exceptions.NoStudentsInGroupException;

import java.util.List;
import java.util.Objects;

public class Group {

    private String groupName;
    private List<Student> studentList;

    public Group(String groupName, List<Student> studentList) {
        this.groupName = groupName;
        try {
            if (studentList.isEmpty()) {
                throw new NoStudentsInGroupException("List of students can't be empty");
            } else {
                this.studentList = studentList;
            }
        } catch (NoStudentsInGroupException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        try {
            if (studentList.isEmpty()) {
                throw new NoStudentsInGroupException("List of students can't be empty");
            } else {
                this.studentList = studentList;
            }
        } catch (NoStudentsInGroupException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Objects.equals(studentList, group.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, studentList);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}

