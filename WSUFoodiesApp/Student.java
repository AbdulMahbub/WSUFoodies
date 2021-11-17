

public class User {

    String firstName;
    String lastName;
    String password;
    String email;

    
    

    int age;

    enum Standing{
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, ALUMNUS, FACULTY
    }

    Standing standing;

    //Constructor with birthday given
    User(String fn, String ln, String pw, String em, Standing s, int bd){
        firstName = fn;
        lastName = ln;
        password = pw;
        email = em;
        age = bd;
        standing = s;
    }

    //constructor without birthday
    User(String fn, String ln, String pw, String em, Standing s){
        firstName = fn;
        lastName = ln;
        password = pw;
        email = em;
        standing = s;
        bday = null;  //leaves bday value null
    }

    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    String getPassword(){
        return password;
    }

    String getEmail(){
        return email;
    }


    bday getBDay(){
        return Bday;
    }

    Standing getStanding(){

        return standing;
    }

    void setFirstName(String f){
        firstName= f;
    }

    void setLastName(String l){
        lastName = l;
    }

    
    boolean newPassword(String old, String n){
        if (old == password){
            password = n;
            return true;
        }
        return false;
            
    }

    void setEmail(String e){
        email = e;
    }

    
    
    void setBday(Bday b){
        bday = b;
    }

    void setStanding(Standing s){
        standing = s;
    }
}
