package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDAO teacherDAO;

    public TeacherServiceImpl(ITeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

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
    @Override
    public Teacher insertTeacher(TeacherInsertDTO dto) throws TeacherDAOException {
        if (dto == null) return null;
        Teacher teacher;

        try {
            teacher = map(dto);
            return teacherDAO.insert(teacher);
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public Teacher updateTeacher(TeacherUpdateDTO dto) throws TeacherDAOException, TeacherNotFoundException {
        if (dto == null) return null;
        Teacher teacher;

        try {
            teacher = map(dto);
            if (teacherDAO.getById(teacher.getId()) == null) {
                throw new TeacherNotFoundException(teacher);
            }
            return teacherDAO.update(teacher);
        } catch (TeacherDAOException | TeacherNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public void deleteTeacher(int id) throws TeacherDAOException, TeacherNotFoundException {
        Teacher teacher;

        try {
            teacher = teacherDAO.getById(id);
            if (teacher == null) {
                throw new TeacherNotFoundException("Teacher with id: " + id + " was not found");
            }

            teacherDAO.delete(id);
        } catch (TeacherDAOException | TeacherNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets a list with the teachers by lastname.
     * @param lastname
     *              the lastname of teachers.
     * @return
     *              the list of teachers.
     * @throws TeacherDAOException
     *              if SQL error in getting from database.
     */
    @Override
    public List<Teacher> getTeachersByLastname(String lastname) throws TeacherDAOException {
        List<Teacher> teachers;

        try {
            teachers = teacherDAO.getByLastname(lastname);
            return teachers;
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public Teacher getTeacherById(int id) throws TeacherDAOException, TeacherNotFoundException {
        Teacher teacher;

        try {
            teacher = teacherDAO.getById(id);
            if (teacher == null) {
                throw new TeacherNotFoundException("Search Error: Teacher with id: " + id + " was not found");
            }
            return teacher;
        } catch (TeacherDAOException | TeacherNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Maps a {@link TeacherInsertDTO} to a {@link Teacher}
     * @param dto
     *              the TeacherInsertDTO obj.
     * @return
     *              the Teacher obj.
     */
    private Teacher map(TeacherInsertDTO dto) {
        return new Teacher(null, dto.getFirstname(), dto.getLastname());
    }

    /**
     * Maps a {@link TeacherUpdateDTO} to a {@link Teacher}
     * @param dto
     *          the TeacherUpdateDTO obj.
     * @return
     *          the Teacher obj.
     */
    private Teacher map(TeacherUpdateDTO dto) {
        return new Teacher(dto.getId(), dto.getFirstname(), dto.getLastname());
    }
}
