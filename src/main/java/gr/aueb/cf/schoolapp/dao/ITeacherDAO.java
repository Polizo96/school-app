package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.List;

/**
 * Defines the operations that can be performed on teachers.
 */
public interface ITeacherDAO {
    /**
     * Inserts a teacher to the Database.
     *
     * @param teacher
     *              the given teacher.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              custom exception.
     */
    Teacher insert(Teacher teacher) throws TeacherDAOException;

    /**
     * Updates a teacher to the Database.
     *
     * @param teacher
     *              the given teacher.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              custom exception.
     */
    Teacher update(Teacher teacher) throws TeacherDAOException;

    /**
     * Deletes a teacher by id from the Database.
     *
     * @param id
     *              the given id of the teacher.
     * @throws TeacherDAOException
     *              custom exception.
     */
    void delete(int id) throws TeacherDAOException;

    /**
     * Gets a list with the teachers by lastname.
     *
     * @param lastname
     *              the given lastname.
     * @return
     *              the list of teachers.
     * @throws TeacherDAOException
     *              custom exception.
     */
    List<Teacher> getByLastname(String lastname) throws TeacherDAOException;

    /**
     * Gets a teacher by id.
     *
     * @param id
     *              the id of the teacher.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              custom exception.
     */
    Teacher getById(int id) throws TeacherDAOException;
}
