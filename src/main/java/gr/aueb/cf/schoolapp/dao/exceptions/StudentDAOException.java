package gr.aueb.cf.schoolapp.dao.exceptions;

/**
 * A custom student exception for DAO.
 */
public class StudentDAOException extends Exception{
    private static final long serialVersionUID = 123456L;

    public StudentDAOException(String s) {
        super(s);
    }
}
