package ie.dcu.redbrick.newsboards.server.auth;

import com.google.inject.Inject;

import ie.dcu.redbrick.newsboards.server.database.UserDao;
import ie.dcu.redbrick.newsboards.shared.users.UserModel;

public class AuthServiceImpl implements AuthService {

    private ThreadLocal<String> username;
    
    @Inject
    private UserDao userDao;
    
    public AuthServiceImpl() {
        username = new ThreadLocal<String>();
        
    }
    public String getUsername() {
        if (username.get() == null) {
            return "test";
        } else {
            return username.get();
        }
    }

    public UserModel getUserModel() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

}
