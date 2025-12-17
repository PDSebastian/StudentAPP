package app.course.service;

import app.course.model.Course;

import java.util.List;

public interface CoursesQueryService {
    List<Course> findAllCourses();
}
