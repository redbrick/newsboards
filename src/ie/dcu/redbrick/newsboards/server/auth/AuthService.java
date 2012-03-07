package ie.dcu.redbrick.newsboards.server.auth;

import ie.dcu.redbrick.newsboards.shared.users.UserModel;

public interface AuthService {
    String getUsername();
    
    void setUsername(String username);
    
    UserModel getUserModel();
}
