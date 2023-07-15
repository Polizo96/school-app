package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.model.Student;

import java.util.List;

/**
 * Defines the operations that can be performed on students.
 */
public interface IStudentDAO {

    /**
     * Inserts a student to the Database.
     *
     * @param student
     *                  the given student.
     * @return
     *                  the student.
     * @throws StudentDAOException
     *                  custom exception.
     */
    Student insert(Student student) throws StudentDAOException;

    /**
     * Updates a student to the Database.
     *
     * @param student
     *              the given student.
     * @return
     *              the student.
     * @throws StudentDAOException
     *              custom exception.
     */
    Student update(Student student) throws StudentDAOException;

    /**
     * Deletes by id a student from the Database.
     *
     * @param id
     *              the id of the student to be deleted.
     * @throws StudentDAOException
     *              custom exception.
     */
    void delete(int id) throws StudentDAOException;

    /**
     * Gets a list with the students by lastname.
     *
     * @param lastname
     *              the given lastname.
     * @return
     *              the list of students.
     * @throws StudentDAOException
     *              custom exception.
     */
    List<Student> getByLastname(String lastname) throws StudentDAOException;

    /**
     * Gets a student by id.
     *
     * @param id
     *              the id of the student.
     * @return
     *              the student.
     * @throws StudentDAOException
     *              custom exception.
     */
    Student getById(int id) throws StudentDAOException;
}
