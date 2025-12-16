package app.users.exceptions;

import app.system.UsersConstants;

public class UserHasAlreadyBeenauthenticatedException  extends Exception{

    public UserHasAlreadyBeenauthenticatedException()
    {
       super(UsersConstants.USER_ALREADY_HAS_BEEN_AUTHENTIFICATED);
    }


}
