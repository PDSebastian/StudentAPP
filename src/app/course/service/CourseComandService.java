package app.course.service;

import app.course.exceptions.CourseAlreadyExistsException;
import app.course.exceptions.CourseAlreadyHasBeenDeleted;
import app.course.model.Course;

public interface CourseComandService {
    void addCourse(Course course) throws CourseAlreadyExistsException;
    void  deleteCourse(Course course) throws CourseAlreadyHasBeenDeleted;









}
