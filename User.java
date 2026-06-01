
import java.io.Serializable;

public class User implements Serializable {

    private String name, id, password, roll; 
    private boolean hasVoted;

    public User(String name, String id, String password, String roll, boolean hasVoted) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.roll = roll;
        this.hasVoted = hasVoted;
    }

    public String getName() 
    { return name; }
    public String getId() 
    { return id; }
    public String getPasword() 
    { return password; } 
    
    public String getRoll() 
    { return roll; }

   
    public boolean gethasVoted() 
    { return hasVoted; }

   
    public void sethasVoted(boolean hasVoted)
     { this.hasVoted = hasVoted; }

}