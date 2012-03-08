package ie.dcu.redbrick.newsboards.server.auth;

import com.google.inject.Inject;

import ie.dcu.redbrick.newsboards.server.database.UserDao;
import ie.dcu.redbrick.newsboards.shared.users.UserModel;

public class AuthServiceImpl implements AuthService {

    private ThreadLocal<String> username;
    private ThreadLocal<UserModel> userModel;
    
    @Inject
    private UserDao userDao;
    
    public AuthServiceImpl() {
        username = new ThreadLocal<String>();
        userModel = new ThreadLocal<UserModel>();
    }
    
    public String getUsername() {
        return username.get();
    }

    public UserModel getUserModel() {
        if (userModel.get() != null) {
            return userModel.get();
        }
        
        UserModel model = userDao.findByUsername(username.get());
        
        if (model == null) {
            model = new UserModel();
            model.setUsername(username.get());
            model.setDisplayName(username.get());
            model = userDao.create(model);
        }
        
        userModel.set(model);
        
        return model;
    }

    public void setUsername(String username) {
        this.username.set(username);
        this.userModel.set(null);
    }

}
