package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.List;

public interface ITeacherDAO {
    /**
     *
     * @param teacher
     * @return
     * @throws TeacherDAOException
     */
    Teacher insert(Teacher teacher) throws TeacherDAOException;

    /**
     *
     * @param teacher
     * @return
     * @throws TeacherDAOException
     */
    Teacher update(Teacher teacher) throws TeacherDAOException;

    /**
     *
     * @param id
     * @throws TeacherDAOException
     */
    void delete(int id) throws TeacherDAOException;

    /**
     *
     * @param lastname
     * @return
     * @throws TeacherDAOException
     */
    List<Teacher> getByLastname(String lastname) throws TeacherDAOException;

    /**
     *
     * @param id
     * @return
     * @throws TeacherDAOException
     */
    Teacher getById(int id) throws TeacherDAOException;
}
