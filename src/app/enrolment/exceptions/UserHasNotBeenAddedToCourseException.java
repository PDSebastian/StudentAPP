package app.enrolment.exceptions;

import app.system.UsersConstants;

public class UserHasNotBeenAddedToCourseException extends Exception{
    public  UserHasNotBeenAddedToCourseException(){
        super(UsersConstants.USER_ALREADY_ADDED_TO_COURSE);

    }



}
