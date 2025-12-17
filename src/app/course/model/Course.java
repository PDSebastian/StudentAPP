package app.course.model;


import app.course.repository.Courserepository;
import app.users.model.Student;

public class Course implements Comparable<Course> {
    int id;
    String name;
    String department;


    public Course(Builder builder) {
        builder.id=this.id;
        builder.name = this.name;
        builder.department = this.department;

    }
    public Course(String text) {
        String[] properties =text.split(",");
        this.name = properties[0];
        this.department = properties[1];
        this.id = Integer.parseInt(properties[2]);
    }


    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public int getId() {
        return id;
    }
    @Override
    public int compareTo(Course course) {
        return this.name.compareTo(course.name);

    }
    @Override
    public String toString() {
        return "Course [name=" + name + ", department=" + department + "]";
    }
    @Override
    public boolean equals(Object o) {
        if(this.name.equals(((Course)o).name)) {
            return true;
        }
        return false;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private int id;
        private String name;
        private String department;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder department(String department) {
            this.department = department;
            return this;
        }
        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Course build() {
            return new Course(this);
        }
    }


}
