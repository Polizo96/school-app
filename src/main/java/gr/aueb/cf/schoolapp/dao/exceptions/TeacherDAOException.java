package gr.aueb.cf.schoolapp.dao.exceptions;

/**
 * A custom Teacher exception for DAO.
 */
public class TeacherDAOException extends Exception {
    private static final long serialVersionUID = 123456L;

    public TeacherDAOException(String s) {
        super(s);
    }
}
