package Stage2.exceptions;

import Stage2.exceptions.exceptions.NoGroupsInFacultyException;

import java.util.List;
import java.util.Objects;

public class Faculty {

    private String facultyName;
    private List<Group> groupList;

    public Faculty(String facultyName, List<Group> groupList) {
        this.facultyName = facultyName;
        try {
            if (groupList.isEmpty()) {
                throw new NoGroupsInFacultyException("There are no groups in the faculty");
            } else {
                this.groupList = groupList;
            }
        } catch (NoGroupsInFacultyException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        try {
            if (groupList.isEmpty()) {
                throw new NoGroupsInFacultyException("There are no groups in the faculty");
            } else {
                this.groupList = groupList;
            }
        } catch (NoGroupsInFacultyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyName, faculty.facultyName) && Objects.equals(groupList, faculty.groupList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName, groupList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}


