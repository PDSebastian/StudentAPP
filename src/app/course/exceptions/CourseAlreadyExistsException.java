package app.course.exceptions;
import app.system.UsersConstants;

public class CourseAlreadyExistsException extends Exception {

    public CourseAlreadyExistsException() {
        super(UsersConstants.COURSE_ALREADY_EXISTS);
    }
}
