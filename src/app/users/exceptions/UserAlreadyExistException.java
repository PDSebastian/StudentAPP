package app.users.exceptions;

import app.system.UsersConstants;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException() {
        super(UsersConstants.USER_ALREADY_EXIST_EXCEPTION_MESSAGE);
    }


}
