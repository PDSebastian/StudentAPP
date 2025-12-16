package app.enrolment.repository;

import app.enrolment.model.UserEnrolment;
import app.enrolment.service.EnrolmentComandService;

import java.util.List;
import java.util.Optional;

public class EnrolmentRepositoryImpl implements EnromentRepository {
    private List<UserEnrolment> userEnrolmentList;

    @Override
    public Optional<UserEnrolment> findEnrolment(int studentID, int courseID) {
       return this.userEnrolmentList.stream().filter(userEnrolment -> userEnrolment.getStudentID() == studentID && userEnrolment.getCourseID() == courseID).findFirst();

    }

    @Override
    public UserEnrolment saveEnrolment(UserEnrolment userEnrolment) {
        this.userEnrolmentList.add(userEnrolment);
        System.out.println("Userul"+userEnrolment.getStudentID()+"s-a inregistrat cu succes");
        return userEnrolment;
    }

    @Override
    public Optional<UserEnrolment> deleteEnrolment(int studentID, int courseID) {
        Optional<UserEnrolment> userEnrolment = this.findEnrolment(studentID, courseID);
        if(userEnrolment.isPresent()) {
            this.userEnrolmentList.remove(userEnrolment.get());
        }
        return userEnrolment;


    }
}
