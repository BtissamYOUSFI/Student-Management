package ma.ensa.studentmanagement.model;


import java.util.Date;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Date birthdate;
    private boolean editing;


    public Student() {}

    public Student(int id, String firstName, String lastName, int age, String email, Date birthdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.birthdate = birthdate;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }
}
