package ma.ensa.studentmanagement.bean;

import ma.ensa.studentmanagement.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBean {
    private Student student= new Student();
    private List<Student> students= new ArrayList<Student>();
    private int nextId = 1;

    public void addStudent() {
        student.setId(nextId++);
        students.add(student);
        student = new Student();
    }

    public void deleteStudent(Student student) {}

    public void editStudent(Student student) {}

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
