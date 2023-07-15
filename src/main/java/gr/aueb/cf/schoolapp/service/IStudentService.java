package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.exceptions.StudentNotFoundException;

import java.util.List;

/**
 * The operations that can be performed on students.
 */
public interface IStudentService {

    /**
     * Inserts a student to the database.
     *
     * @param dto
     *          the student to be inserted.
     * @return
     *          the student.
     * @throws StudentDAOException
     *          if SQL error in insert.
     */
    Student insertStudent(StudentInsertDTO dto) throws StudentDAOException;

    /**
     * Updates a student to the database.
     *
     * @param dto
     *          the student to be updated.
     * @return
     *          the student.
     * @throws StudentDAOException
     *          if SQL error in update.
     * @throws StudentNotFoundException
     *          if student not found.
     */
    Student updateStudent(StudentUpdateDTO dto) throws StudentDAOException, StudentNotFoundException;

    /**
     * Deletes a student from the database by student's id.
     *
     * @param id
     *          the id of the student to be deleted.
     * @throws StudentDAOException
     *          if SQL error in delete.
     * @throws StudentNotFoundException
     *          if student not found.
     */
    void deleteStudent(int id) throws StudentDAOException, StudentNotFoundException;

    /**
     * Gets a list with the students by lastname.
     *
     * @param lastname
     *              the lastname of students.
     * @return
     *              the list of students.
     * @throws StudentDAOException
     *              if SQL error in getting from database.
     */
    List<Student> getStudentsByLastname(String lastname) throws StudentDAOException;

    /**
     * Gets a student by id from the database.
     *
     * @param id
     *          the id of the student.
     * @return
     *          the student.
     * @throws StudentDAOException
     *          if SQL error in getting from database.
     * @throws StudentNotFoundException
     *          if student not found.
     */
    Student getStudentById(int id) throws StudentDAOException, StudentNotFoundException;
}
