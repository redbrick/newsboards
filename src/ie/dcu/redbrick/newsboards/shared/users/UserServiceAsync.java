package ie.dcu.redbrick.newsboards.shared.users;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
    void getUser(AsyncCallback<UserModel> callback);
}
