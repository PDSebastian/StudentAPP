package app.enrolment.model;

import app.books.model.Book;
import app.users.model.User;

import java.time.LocalDate;

public class UserEnrolment implements Comparable<UserEnrolment> {

   private int studentID;
   private int courseID;
   private LocalDate createdAt;



    public UserEnrolment(Builder builder) {
        this.studentID = builder.studentID;
        this.courseID = builder.courseID;
        this.createdAt = builder.createdAt;



    }
    public UserEnrolment(String text) {
      String[] properties=text.split(",");
      this.studentID = Integer.parseInt(properties[0]);
      this.courseID = Integer.parseInt(properties[1]);
      this.createdAt = LocalDate.parse(properties[2]);


    }
    public int getStudentID() {
        return studentID;
    }
    public int getCourseID() {
        return courseID;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String toString(){
       return "studentul "+studentID+"este inscris la cursul  "+courseID+" pe data de "+createdAt;
   }
   public boolean equals(UserEnrolment e){
       if(e.courseID==courseID && e.studentID==studentID){
           return true;
       }
       return false;
   }
   public int compareTo(UserEnrolment e){
       if(e.createdAt.isBefore(this.createdAt)){
           return 1;
       }
       else if(e.createdAt.isAfter(this.createdAt)){
           return -1;
       }
       return 0;
    }

    public static Builder builder (){
       return new Builder();
    }
    public static class Builder{

       private int studentID;
         private int courseID;
         private LocalDate createdAt;

         public Builder studentID(int studentID){
             this.studentID = studentID;
             return this;
         }
         public Builder courseID(int courseID){
             this.courseID = courseID;
             return this;
         }
         public Builder createdAt(LocalDate createdAt){
             this.createdAt = createdAt;
             return this;
         }
         public UserEnrolment build(){
             return new UserEnrolment(this);

         }
    }

}
