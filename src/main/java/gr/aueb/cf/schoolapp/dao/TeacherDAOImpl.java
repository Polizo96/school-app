package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements ITeacherDAO{

    /**
     * Inserts a teacher to the Database.
     *
     * @param teacher
     *                  the given teacher.
     * @return
     *                  the teacher.
     * @throws TeacherDAOException
     *                  if SQL error in insert.
     */
    @Override
    public Teacher insert(Teacher teacher) throws TeacherDAOException {
        String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            String firstname = teacher.getFirstname();
            String lastname = teacher.getLastname();

            ps.setString(1, firstname);
            ps.setString(2, lastname);

            int n = ps.executeUpdate();
            if (n >= 1) {
                JOptionPane.showMessageDialog(null,  n + " rows affected", "Successful insert", JOptionPane.PLAIN_MESSAGE);
                return teacher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher Insert: " + teacher);
        }
    }

    /**
     * Updates a teacher to the Database.
     *
     * @param teacher
     *              the given teacher.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              if SQL error in update.
     */
    @Override
    public Teacher update(Teacher teacher) throws TeacherDAOException {
        String sql = "UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            int id = teacher.getId();
            String firstname = teacher.getFirstname();
            String lastname = teacher.getLastname();

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setInt(3, id);

            int n = ps.executeUpdate();
            if (n >= 1) {
                JOptionPane.showMessageDialog(null,  n + " rows affected", "Successful update", JOptionPane.PLAIN_MESSAGE);
                return teacher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher Update: " + teacher);
        }
    }

    /**
     * Deletes a teacher by id from the Database.
     *
     * @param id
     *              the given id of the teacher.
     * @throws TeacherDAOException
     *              if SQL error in delete.
     */
    @Override
    public void delete(int id) throws TeacherDAOException {
        String sql = "DELETE FROM TEACHERS WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                int n = ps.executeUpdate();
                if (n >= 1) {
                    JOptionPane.showMessageDialog(null, n + " rows affected", "Successful Delete", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No rows affected", "Delete", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher Delete with id: " + id);
        }
    }

    /**
     * Gets a list with the teachers by lastname.
     *
     * @param lastname
     *              the given lastname.
     * @return
     *              the list of teachers.
     * @throws TeacherDAOException
     *              if SQL error in get by lastname.
     */
    @Override
    public List<Teacher> getByLastname(String lastname) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
        List<Teacher> teachers = new ArrayList<>();
        ResultSet rs = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, lastname + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"));
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher with lastname: " + lastname);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return teachers;
    }

    /**
     * Gets a teacher by id.
     *
     * @param id
     *              the id of the teacher.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              if SQL error in get by id.
     */
    @Override
    public Teacher getById(int id) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE ID = ?";
        Teacher teacher = null;
        ResultSet rs = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                teacher = new Teacher(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher with id: " + id);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return teacher;
    }
}
