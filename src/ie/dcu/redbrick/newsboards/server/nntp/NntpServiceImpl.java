package ie.dcu.redbrick.newsboards.server.nntp;

import java.util.ArrayList;
import java.util.List;

import ie.dcu.redbrick.newsboards.server.auth.AuthService;
import ie.dcu.redbrick.newsboards.server.database.NewsgroupDao;
import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;
import ie.dcu.redbrick.newsboards.shared.nntp.NntpException;
import ie.dcu.redbrick.newsboards.shared.nntp.NntpService;

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
    private NewsgroupDao newsgroupDao;
    
    @Inject
    private AuthService authService;

    /**
     * Returns a list of groups on the nntp server, with the subscribed
     * flag set to true where appropriate.
     */
    public ArrayList<NewsgroupModel> getGroupList() throws NntpException {
        ArrayList<NewsgroupModel> groups = Lists.newArrayList(Lists.transform(getSession().listNewsgroups(),
                newsgroupInfoConverter));
        
        List<NewsgroupModel> userGroups = newsgroupDao.findByUser(authService.getUserModel());
        
        for (NewsgroupModel group:groups) {
            if (userGroups.contains(group)) {
                group.setSubscribed(true);
            } else {
                group.setSubscribed(false);
            }
        }
        
        return groups;
    }
    
    public Void subscribe(NewsgroupModel group) throws NntpException {
        String name = group.getName();
        group = newsgroupDao.findByName(name);
        
        if (group == null) {
            // check that the group exists
            ArrayList<NewsgroupModel> groups = Lists.newArrayList(Lists.transform(getSession().listNewsgroups(),
                    newsgroupInfoConverter));
            
            for (NewsgroupModel current:groups) {
                if (current.getName().equals(name)) {
                    group = newsgroupDao.create(current);
                }
            }
        }
        
        if (group == null) {
            throw new NntpException("Group doesn't exist");
        }
        
        newsgroupDao.subscribeUser(group, authService.getUserModel());
        return null;
    }
    
    protected NntpSession getSession() {
        return session;
    }

}
