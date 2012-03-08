package ie.dcu.redbrick.newsboards.shared.nntp;


import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("nntpservice")
public interface NntpService extends RemoteService {
    String getMessage();
    ArrayList<NewsgroupModel> getGroupList()
        throws NntpException;
}
