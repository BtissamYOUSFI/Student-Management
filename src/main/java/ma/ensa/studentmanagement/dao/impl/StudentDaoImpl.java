package ma.ensa.studentmanagement.dao.impl;

import ma.ensa.studentmanagement.dao.facade.StudentDao;
import ma.ensa.studentmanagement.db.DBConnection;
import ma.ensa.studentmanagement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private Connection conn= DBConnection.getInstance();
    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO student (first_name, last_name, email, birthday) VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setDate(4, new java.sql.Date(student.getBirthdate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE student SET first_name=?, last_name=?, email=?, birthday=? WHERE id=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setDate(4, new java.sql.Date(student.getBirthdate().getTime()));
            ps.setInt(5, student.getId());
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteStudent(Student student) {
        String sql = "DELETE FROM student WHERE id=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudents() {
        String sql = "SELECT* FROM student";
        List<Student> students = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                student.setBirthdate(new java.sql.Date(rs.getDate("birthday").getTime()));
                students.add(student);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
