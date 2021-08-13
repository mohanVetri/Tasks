import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Student {
    @Id long id;
    String userName;
    String password;
    public Student(int id, String userName, String password) {
        this.id=id;
        this.userName=userName;
        this.password=password;
    }
    public Student(){
    }
}
