package app.enrolment.service;

import app.course.service.CoursesQueryServiceImpl;
import app.enrolment.exceptions.UserHasNotBeenAddedToCourseException;
import app.enrolment.exceptions.UserHasNotBeenRemovedException;
import app.enrolment.model.UserEnrolment;
import app.enrolment.repository.EnromentRepository;
import app.users.model.User;
import app.users.service.UserCommandService;
import app.users.service.UserQueryService;

import java.time.LocalDate;

public class EnrolmentComandServiceImpl implements EnrolmentComandService {
    EnromentRepository enrolmentRepository;
    UserQueryService userQueryService;
    UserCommandService userCommandService;

    public EnrolmentComandServiceImpl(EnromentRepository enrolmentRepository, UserQueryService userQueryService, UserCommandService userCommandService, CoursesQueryServiceImpl coursesQueryService) {
        this.userQueryService=userQueryService;
        this.userCommandService=userCommandService;
        this.enrolmentRepository=enrolmentRepository;
    }

    @Override
    public UserEnrolment addEnrolment(User user, int CourseID) throws UserHasNotBeenAddedToCourseException {
        int studentId;
        try{
             studentId = Integer.parseInt(user.getId());
        }catch(NumberFormatException e){
            throw new UserHasNotBeenAddedToCourseException();
        }
        UserEnrolment userEnrolment=UserEnrolment.builder().studentID(studentId).courseID(CourseID).createdAt(LocalDate.now()).build();
        UserEnrolment savedEnrolment=enrolmentRepository.saveEnrolment(userEnrolment);
        System.out.println("Student "+userEnrolment.getStudentID()+" has been added");
        return savedEnrolment;

    }

    @Override
    public UserEnrolment removeEnrolment(User user, int CourseID) throws UserHasNotBeenRemovedException{
       int studentId ;
       try{
           studentId = Integer.parseInt(user.getId());

       }catch(NumberFormatException e){
           throw new UserHasNotBeenRemovedException();
       }
       UserEnrolment deleteUserEnrolment=enrolmentRepository.deleteEnrolment(studentId,CourseID).orElse(null);
        if(deleteUserEnrolment!=null){
            System.out.println("Student "+deleteUserEnrolment.getStudentID()+" has been removed");
        }
        return deleteUserEnrolment;


    }
}
