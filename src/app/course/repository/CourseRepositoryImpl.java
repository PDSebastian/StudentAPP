package app.course.repository;

import app.course.exceptions.CourseAlreadyExistsException;
import app.course.exceptions.CourseAlreadyHasBeenDeleted;
import app.course.model.Course;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CourseRepositoryImpl implements Courserepository{
    private List<Course> courses;

    public CourseRepositoryImpl() {

        this.courses=new ArrayList<>();
        this.loadCourses();


    }
    private void loadCourses(){
        try{
            Scanner sc=new Scanner(new File("C:\\Users\\adria\\Desktop\\mycode\\java-basics\\StudentAPP\\src\\app\\course\\data\\text"));
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                switch (line.split(" ")[0]){
                    case "1":
                        this.courses.add(new Course(line));
                        break;

                }
            }




        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Optional<Course> findById(int id) {
        return courses.stream().filter(c->c.getId()==id).findFirst();
    }

    @Override
    public Optional<Course> addCourse(Course course) throws CourseAlreadyExistsException {
       if(findById(course.getId()).isPresent()){
           throw new CourseAlreadyExistsException();
       }
       this.courses.add(course);
       System.out.println("Course added successfully");
       return Optional.of(course);
    }

    @Override
    public Optional<Course> deleteCourse(Course course)  throws CourseAlreadyHasBeenDeleted {
        boolean deleted = this.courses.remove(course);
        if(!deleted){
            throw new CourseAlreadyHasBeenDeleted();
        }
        System.out.println("Course deleted successfully");
        return Optional.of(course);
    }
}
