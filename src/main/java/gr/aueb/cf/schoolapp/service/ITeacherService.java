package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;

import java.util.List;

/**
 * The operations that can be performed on teachers.
 */
public interface ITeacherService {

    /**
     * Inserts a teacher to the database.
     *
     * @param dto
     *              the teacher to be inserted.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              if SQL error in insert.
     */
    Teacher insertTeacher(TeacherInsertDTO dto) throws TeacherDAOException;

    /**
     * Updates a teacher from the database.
     *
     * @param dto
     *          the teacher to be updated.
     * @return
     *          the teacher.
     * @throws TeacherDAOException
     *          if SQL error in update.
     * @throws TeacherNotFoundException
     *          if teacher not found.
     */
    Teacher updateTeacher(TeacherUpdateDTO dto) throws TeacherDAOException, TeacherNotFoundException;

    /**
     * Deletes a teacher from the database by teacher's id.
     *
     * @param id
     *              the id of the teacher to be deleted.
     * @throws TeacherDAOException
     *              if SQL error in delete.
     * @throws TeacherNotFoundException
     *              if teacher not found.
     */
    void deleteTeacher(int id) throws TeacherDAOException, TeacherNotFoundException;

    /**
     * Gets a list with the teachers by lastname.
     * @param lastname
     *              the lastname of teachers.
     * @return
     *              the list of teachers.
     * @throws TeacherDAOException
     *              if SQL error in getting from database.
     */
    List<Teacher> getTeachersByLastname(String lastname) throws TeacherDAOException;

    /**
     * Gets a teacher by id from the database.
     *
     * @param id
     *              the id of the teacher.
     * @return
     *              the teacher.
     * @throws TeacherDAOException
     *              if SQL error in getting from database.
     * @throws TeacherNotFoundException
     *              if teacher not found.
     */
    Teacher getTeacherById(int id) throws TeacherDAOException, TeacherNotFoundException;
}
