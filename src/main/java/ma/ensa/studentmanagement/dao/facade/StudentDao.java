package ma.ensa.studentmanagement.dao.facade;

import ma.ensa.studentmanagement.model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    List<Student> getStudents();
}
