package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.exceptions.StudentNotFoundException;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private IStudentDAO studentDAO;

    public StudentServiceImpl(IStudentDAO studentDAO) { this.studentDAO = studentDAO; }

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
    @Override
    public Student insertStudent(StudentInsertDTO dto) throws StudentDAOException {
        if (dto == null) return null;
        Student student;

        try {
            student = map(dto);
            return studentDAO.insert(student);
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public Student updateStudent(StudentUpdateDTO dto) throws StudentDAOException, StudentNotFoundException {
        if (dto == null) return null;
        Student student;

        try {
            student = map(dto);
            if (studentDAO.getById(student.getId()) == null) {
                throw new StudentNotFoundException(student);
            }
            return studentDAO.update(student);
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public void deleteStudent(int id) throws StudentDAOException, StudentNotFoundException {
        Student student;

        try {
            student = studentDAO.getById(id);
            if (student == null) {
                throw new StudentNotFoundException("Student with id: " + id + " was not found");
            }

            studentDAO.delete(id);
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public List<Student> getStudentsByLastname(String lastname) throws StudentDAOException {
        List<Student> students;

        try {
            students = studentDAO.getByLastname(lastname);
            return students;
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
    @Override
    public Student getStudentById(int id) throws StudentDAOException, StudentNotFoundException {
        Student student;

        try {
            student = studentDAO.getById(id);
            if (student == null) {
                throw new StudentNotFoundException("Search Error: Student with id: " + id + " was not found");
            }
            return student;
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Maps a {@link StudentInsertDTO} to a {@link Student}.
     *
     * @param dto
     *              the StudentInsertDTO obj.
     * @return
     *              the Student obj.
     */
    private Student map(StudentInsertDTO dto) {
        return new Student(null, dto.getFirstname(), dto.getLastname());
    }

    /**
     * Maps a {@link StudentUpdateDTO} to a {@link Student}.
     *
     * @param dto
     *              the StudentUpdateDTO obj.
     * @return
     *              the Student obj.
     */
    private Student map(StudentUpdateDTO dto) {
        return new Student(dto.getId(), dto.getFirstname(), dto.getLastname());
    }
}
