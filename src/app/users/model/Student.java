package app.users.model;

import java.time.LocalDate;

public class Student extends User{
     int anul;
    int varsta;
    LocalDate dataInscrierii;
    boolean minimCredite;
    //todo:"id,password,email"
    public Student(Builder builder) {
        super(builder.id,builder.password,builder.email);
        this .anul=builder.anul;
        this.dataInscrierii=builder.dataInscrierii;
        this.minimCredite=builder.minimCredite;

    }
    public Student(String text) {
        super(text);
        String[] properties =text.split(",");
        this.anul = Integer.parseInt(properties[4]);
        this.varsta = Integer.parseInt(properties[5]);
        this.dataInscrierii = LocalDate.parse(properties[6]);
        this.minimCredite = Boolean.parseBoolean(properties[7]);

    }


    @Override
    public String toString() {
        return "Student Anul: "+anul+" Varsta: "+varsta+ "DataInscrierii: "+dataInscrierii.toString()+" minimCredite: "+minimCredite;
    }
    @Override
    public boolean equals(Object o) {
        if(this.anul==((Student)o).anul){
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(User o) {
       if(this.varsta==((Student)o).varsta){
           return 1;
       }
       else if(this.varsta>((Student)o).varsta){
           return -1;
       }
       return 0;
    }
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        String id;
        String password;
        String email;
        private int anul;
        private LocalDate dataInscrierii;
        private boolean minimCredite;


        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
      public   Builder setAnul(int anul){
            this.anul=anul;
            return this;
      }
      public Builder setDataInscrierii(LocalDate dataInscrierii){
            this.dataInscrierii=dataInscrierii;
            return this;
      }
      public Builder setMinimCredite(boolean minimCredite){
            this.minimCredite=minimCredite;
            return this;
      }
      public Student build(){
            return new Student(this);
      }





    }



}
