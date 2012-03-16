package ie.dcu.redbrick.newsboards.shared.users;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userservice")
public interface UserService extends RemoteService {
    UserModel getUser();
}
