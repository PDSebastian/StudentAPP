package app.users.exceptions;
import app.system.UsersConstants;

public class UserAlreadyHasBeenDeletedException extends Exception {

    public UserAlreadyHasBeenDeletedException() {
        super(UsersConstants.USER_ALREADY_DELETED_EXCEPTION_MESSAGE);
    }
}
