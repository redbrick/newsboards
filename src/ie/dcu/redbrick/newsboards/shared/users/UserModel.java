package ie.dcu.redbrick.newsboards.shared.users;

import java.util.ArrayList;

import ie.dcu.redbrick.newsboards.shared.Model;
import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;

public class UserModel extends Model<Long> {

    private static final long serialVersionUID = -1066535714940681245L;
    private Long id;
    private String username;
    private String displayName;
    private ArrayList<NewsgroupModel> newsGroups;
    
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<NewsgroupModel> getNewsGroups() {
        return newsGroups;
    }

    public void setNewsGroups(ArrayList<NewsgroupModel> newsGroups) {
        this.newsGroups = newsGroups;
    }
    
    
    
    
}
