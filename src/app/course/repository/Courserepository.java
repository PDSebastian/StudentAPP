package app.course.repository;

import app.course.exceptions.CourseAlreadyExistsException;
import app.course.exceptions.CourseAlreadyHasBeenDeleted;
import app.course.model.Course;

import java.util.List;
import java.util.Optional;

public interface Courserepository {
        List<Course> findAll();
        Optional<Course> findById(int id);
        Optional<Course> addCourse(Course course) throws CourseAlreadyExistsException;
        Optional<Course> deleteCourse(Course course)throws CourseAlreadyHasBeenDeleted;
}
