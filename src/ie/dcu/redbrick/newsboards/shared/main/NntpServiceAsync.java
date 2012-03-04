package ie.dcu.redbrick.newsboards.shared.main;

import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NntpServiceAsync {
    void getMessage(AsyncCallback<String> callback);
    void getGroupList(AsyncCallback<ArrayList<NewsgroupModel>> callback);
}
