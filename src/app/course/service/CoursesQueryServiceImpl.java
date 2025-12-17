package app.course.service;

import app.course.model.Course;
import app.course.repository.CourseRepositoryImpl;
import app.course.repository.Courserepository;

import java.util.List;

public class CoursesQueryServiceImpl implements CoursesQueryService {
    private Courserepository courserepository;

    public CoursesQueryServiceImpl(CourseRepositoryImpl courseRepository) {
        this.courserepository=courserepository;
    }

    @Override
    public List<Course> findAllCourses() {
        return courserepository.findAll();
    }
}
