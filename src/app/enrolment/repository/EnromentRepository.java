package app.enrolment.repository;

import app.enrolment.model.UserEnrolment;

import java.util.Optional;

public interface EnromentRepository {

    Optional<UserEnrolment> findEnrolment(int studentID, int courseID);
    UserEnrolment saveEnrolment(UserEnrolment userEnrolment);
    Optional<UserEnrolment> deleteEnrolment(int studentID, int courseID);


}
