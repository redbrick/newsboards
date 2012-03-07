package ie.dcu.redbrick.newsboards.server.main;

import java.util.ArrayList;

import ie.dcu.redbrick.newsboards.server.auth.AuthService;
import ie.dcu.redbrick.newsboards.server.nntp.NewsgroupInfo2NewsgroupModel;
import ie.dcu.redbrick.newsboards.server.nntp.NntpSession;
import ie.dcu.redbrick.newsboards.shared.main.NntpService;
import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;
import ie.dcu.redbrick.newsboards.shared.nntp.NntpException;

import com.google.common.collect.Lists;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class NntpServiceImpl extends RemoteServiceServlet implements
        NntpService {

    private static final long serialVersionUID = 7054452626040802249L;

    @Inject
    private NntpSession session;
    
    @Inject
    private NewsgroupInfo2NewsgroupModel newsgroupInfoConverter;
    
    @Inject
    private AuthService authService;
    
    public String getMessage() {
        return authService.getUsername();
    }

    public ArrayList<NewsgroupModel> getGroupList() throws NntpException {
        return Lists.newArrayList(Lists.transform(getSession().listNewsgroups(), newsgroupInfoConverter));
    }
    
    protected NntpSession getSession() {
        return session;
    }

}
