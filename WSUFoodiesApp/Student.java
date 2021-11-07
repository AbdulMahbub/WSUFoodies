

public class Student {

    String firstName;
    String lastName;
    String password;
    String email;
    int idNum;
    
    class Bday {
        int day;
        int month;
        int year;
    };

    Bday bday;

    enum Standing{
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, ALUMNUS, FACULTY
    }

    Standing standing;

    //Constructor with birthday given
    Student(String fn, String ln, String pw, String em, int id, Standing s, bday bd){
        firstName = fn;
        lastName = ln;
        password = pw;
        email = em;
        id = idNum;
        bday = bd;
        standing = s;
    }

    //constructor without birthday
    Student(String fn, String ln, String pw, String em, int id, Standing s){
        firstName = fn;
        lastName = ln;
        password = pw;
        email = em;
        id = idNum;
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

    int getIdNum(){
        return idNum;
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

    void setIdNum(int id){
        idNum = id;
    }
    
    void setBday(Bday b){
        bday = b;
    }

    void setStanding(Standing s){
        standing = s;
    }
}