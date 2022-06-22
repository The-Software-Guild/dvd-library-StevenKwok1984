package dao;



public class DvdLibraryDaoException extends Exception {

    public DvdLibraryDaoException(String message) {
        //calls matching constructor on the Exception class by calling super, so base constructors do
        //all the work of initialising our object.
        super(message);
    }

    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
