package app.enrolment.service;
import app.enrolment.exceptions.UserHasNotBeenAddedToCourseException;
import app.enrolment.exceptions.UserHasNotBeenRemovedException;
import app.enrolment.model.UserEnrolment;
import app.enrolment.repository.EnrolmentRepositoryImpl;
import app.enrolment.repository.EnromentRepository;
import app.users.exceptions.UserAlreadyExistException;
import app.users.model.User;

import java.util.List;


public interface EnrolmentComandService {
    UserEnrolment addEnrolment(User user, int CourseID) throws UserHasNotBeenAddedToCourseException;
    UserEnrolment removeEnrolment(User user, int CourseID) throws UserHasNotBeenRemovedException;


}
