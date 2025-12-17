package app.course.exceptions;

import app.system.UsersConstants;

public class CourseAlreadyHasBeenDeleted extends Exception {
    public CourseAlreadyHasBeenDeleted() {
        super(UsersConstants.COURSE_HAS_ALREADY_BEEN_DELETED);
    }
}
