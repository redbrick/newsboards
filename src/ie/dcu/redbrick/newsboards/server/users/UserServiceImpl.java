package ie.dcu.redbrick.newsboards.server.users;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import ie.dcu.redbrick.newsboards.server.auth.AuthService;
import ie.dcu.redbrick.newsboards.shared.users.UserModel;
import ie.dcu.redbrick.newsboards.shared.users.UserService;

@Singleton
public class UserServiceImpl extends RemoteServiceServlet implements UserService {

    @Inject
    private AuthService authService;
    
    private static final long serialVersionUID = -5239932832573426257L;

    public UserModel getUser() {
        return authService.getUserModel();
    }

}
