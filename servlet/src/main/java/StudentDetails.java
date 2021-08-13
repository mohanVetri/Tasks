import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class StudentDetails {
    @Id long id;
    String firstName;
    String lastName;
    String userName;
    String password;
    String emailId;

    public StudentDetails(String firstName, String lastName, String userName, String password, String emailId){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
        this.emailId=emailId;
    }

    public StudentDetails(){
    }
}
