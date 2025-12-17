package app.course.service;

import app.course.exceptions.CourseAlreadyExistsException;
import app.course.exceptions.CourseAlreadyHasBeenDeleted;
import app.course.model.Course;
import app.course.repository.Courserepository;

import java.util.Optional;

public class CourseComandServiceImpl implements CourseComandService{
    Courserepository courserepository;
    public CourseComandServiceImpl(Courserepository courserepository){
        this.courserepository = courserepository;
    }

    @Override
    public void addCourse(Course course) throws CourseAlreadyExistsException {
        if(courserepository.findById(course.getId()).isPresent()){
            System.out.println("Course already exists");

        }else{
            courserepository.addCourse(course);
            System.out.println("Course added successfully");

        }
    }

    @Override
    public void  deleteCourse(Course course) throws CourseAlreadyHasBeenDeleted {
        Optional<Course> deleteCourse = courserepository.deleteCourse(course);
        if(deleteCourse.isPresent()){
            System.out.println("Course deleted successfully");
        }
        else{
            System.out.println("Course not deleted successfully");
        }

    }
}
