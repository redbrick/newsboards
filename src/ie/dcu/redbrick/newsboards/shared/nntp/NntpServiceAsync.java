package ie.dcu.redbrick.newsboards.shared.nntp;


import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NntpServiceAsync {
    void getMessage(AsyncCallback<String> callback);
    void getGroupList(AsyncCallback<ArrayList<NewsgroupModel>> callback);
}
