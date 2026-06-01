
import java.io.Serializable;
 public class Candidate implements Serializable {

    private String id;
    private String name;
    private String party;
    private int voteCount;

    public Candidate(String id, String name, String party, int voteCount){
 this.id = id;
 this.name = name;
 this.party = party;
 this.voteCount = voteCount;
}

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;

    }
    public void setParty(String party){
        this.party = party;
    }
    public String getParty(){
        return party;
    }
  
    public int getVoteCount(){
        return voteCount;
    }
      public void addvote(){
       this.voteCount++;
       
    }
    
}
