package ie.dcu.redbrick.newsboards.shared.nntp;


import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NntpServiceAsync {
    void getGroupList(AsyncCallback<ArrayList<NewsgroupModel>> callback);
    void subscribe(NewsgroupModel group, AsyncCallback<Void> callback);
}
