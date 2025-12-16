package app.enrolment.exceptions;

import app.system.UsersConstants;

public class UserHasNotBeenRemovedException extends Exception{
    public UserHasNotBeenRemovedException(){
        super(UsersConstants.USER_ALREADY_REMOVED_FROM_COURSE);
    }



}
