package data;

import java.util.ArrayList;
import java.util.List;

public class StudentsGroup implements Comparable<StudentsGroup>{
    private List<User> groupMembers = new ArrayList<User>();

    public StudentsGroup() {
        this.groupMembers.clear();
    }
    public StudentsGroup(StudentsGroup group ) {
        this.groupMembers.addAll(group.getMembers());
    }

    public StudentsGroup(List<User> groupList) {
        SetMembers(groupList);
    }
    public void SetTeacher(Teacher teacher) {
        for(User u: this.groupMembers) {
            if (u.getClass().getSimpleName().equals("Teacher")) {
                this.groupMembers.remove(u);
                break;
            }
        }
        this.groupMembers.add(teacher);
    }

    public void AddStudent(Student student) {
        this.groupMembers.add(student);
    }
    public void SetMembers(List<User> studentsList) {
        this.groupMembers.clear();
        this.groupMembers.addAll(studentsList);
    }
    public Integer getSizeOfGroup() { return groupMembers.size(); }
    public Teacher getTeacher() {
        User teacher = null;
        for(User u: this.groupMembers) {
            if (u.getClass().getSimpleName().equals("Teacher")) {
                teacher = u;
                break;
            }
        }
        return (Teacher)teacher;
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        for(User u: this.groupMembers) {
            if (!u.getClass().getSimpleName().equals("Teacher")) {
                students.add((Student)u);
            }
        }
        return students;
    }

    public List<User> getMembers() {
        return this.groupMembers;
    }
    @Override
    public int compareTo(StudentsGroup anotherGroup) {
        return Integer.compare(this.getSizeOfGroup(),anotherGroup.getSizeOfGroup());
    }
}