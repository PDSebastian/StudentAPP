package app.users.model;

import java.time.LocalDate;

public class Teacher extends User{
    private boolean titualar;
    private int norma;
    double  salariu;
    LocalDate dataAngajarii;

    public Teacher(Builder builder) {
        super(builder.id,builder.password,builder.email);
        this.norma = builder.norma;
        this.salariu = builder.salariu;
        this.dataAngajarii = builder.dataAngajarii;
        this.titualar = builder.titualar;



    }
    public Teacher(String text){
        super(text);
        String [] proprietati = text.split(",");
        this.norma = Integer.parseInt(proprietati[4]);
        this.salariu = Double.parseDouble(proprietati[5]);
        this.dataAngajarii = LocalDate.parse(proprietati[6]);
        this.titualar = Boolean.parseBoolean(proprietati[7]);


    }
    @Override
   public String toString(){
        return "Titular: "+titualar+" Norma"+norma+" Salariu: "+salariu+" data Angajarii: "+dataAngajarii;
    }
    @Override
    public boolean equals(Object o){
        if(this.salariu==((Teacher)o).salariu){
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(User o ) {
        if(this.norma>((Teacher)o).norma){
            return 1;
        }
        else if(this.norma<((Teacher)o).norma){
            return -1;
        }
        return 0;

    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
       private boolean titualar;
        private int norma;
       private double  salariu;
        LocalDate dataAngajarii;
        String id;
        String password;
        String email;

        public Builder setTItualar(boolean titualar){
            this.titualar = titualar;
            return this;

        }
        public Builder setNorma(int norma){
            this.norma = norma;
            return this;
        }
        public Builder setSalariu(double  salariu){
            this.salariu = salariu;
            return this;
        }
        public Builder setDataAngajarii(LocalDate dataAngajarii){
            this.dataAngajarii = dataAngajarii;
            return this;
        }
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
        public Teacher build(){
            return new Teacher(this);
        }





    }


}
