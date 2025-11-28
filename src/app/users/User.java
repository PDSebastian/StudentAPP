package app.users;

import java.util.Locale;

public class User  implements Comparable<User>{

    protected  String id;
    protected String password;
    protected String email;


    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

  //todo:"id,password,email"
  public User(String text){
      String[] proprietati = text.split(",");
      this.id=proprietati[0];
      this.password=proprietati[1];
      this.email=proprietati[2];
  }

    @Override
    public int compareTo(User o) {
        if(this.password.length()>(o.password).length()){
            return 1;
        }
        else if(this.password.length()<o.password.length()){
            return -1;
        }
        return 0;
    }
    @Override
    public boolean equals(Object o){
        return id.equals(((User)o).id);
    }
    @Override
    public String toString(){
        return "UserID:  "+ id+" email: "+email+" password: "+password;

    }




}
