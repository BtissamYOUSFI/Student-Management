package ma.ensa.studentmanagement.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.faces.component.html.HtmlInputText;
import ma.ensa.studentmanagement.dao.facade.StudentDao;
import ma.ensa.studentmanagement.dao.impl.StudentDaoImpl;
import ma.ensa.studentmanagement.model.Student;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentBean {
    private Student student= new Student();
    private List<Student> students= new ArrayList<Student>();
    private StudentDao dao = new StudentDaoImpl();

    private HtmlInputText firstNameInput;
    private HtmlInputText lastNameInput;
    private HtmlInputText emailInput;
    private HtmlInputText birthDateInput;
    private HtmlDataTable dataTable;


    @PostConstruct
    public void init() {
        students = dao.getStudents();
    }

    public void addStudent() {
        dao.addStudent(student);
        students = dao.getStudents();
        student = new Student();

    }

    public void deleteStudent(Student student) {
        dao.deleteStudent(student);
        students = dao.getStudents();
    }

    public void editStudent(Student student) {
//        Student s = (Student) dataTable.getRowData();
        student.setEditing(true);
    }

    public void saveEditStudent() {
        Student s = (Student) dataTable.getRowData();
        s.setFirstName((String) firstNameInput.getValue());
        s.setLastName((String) lastNameInput.getValue());
        s.setEmail((String) emailInput.getValue());
        s.setBirthdate((Date) birthDateInput.getValue());
        dao.updateStudent(s);
        s.setEditing(false);
        students = dao.getStudents();
    }

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


    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public HtmlInputText getBirthDateInput() {
        return birthDateInput;
    }

    public void setBirthDateInput(HtmlInputText birthDateInput) {
        this.birthDateInput = birthDateInput;
    }

    public HtmlInputText getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(HtmlInputText emailInput) {
        this.emailInput = emailInput;
    }

    public HtmlInputText getLastNameInput() {
        return lastNameInput;
    }

    public void setLastNameInput(HtmlInputText lastNameInput) {
        this.lastNameInput = lastNameInput;
    }

    public HtmlInputText getFirstNameInput() {
        return firstNameInput;
    }

    public void setFirstNameInput(HtmlInputText firstNameInput) {
        this.firstNameInput = firstNameInput;
    }
}
