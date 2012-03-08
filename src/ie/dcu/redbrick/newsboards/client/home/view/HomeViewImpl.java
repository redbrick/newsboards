package ie.dcu.redbrick.newsboards.client.home.view;

import ie.dcu.redbrick.newsboards.client.view.widgets.H2;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;

public class HomeViewImpl extends Composite implements HomeView {
    private FlowPanel panel;
    
    private FlowPanel groupList;
    public HomeViewImpl() {
        panel = new FlowPanel();
        groupList = new FlowPanel();
        
        panel.add(new H2("Homepage"));
        panel.add(groupList);
        initWidget(panel);
    }
    
    public void addGroup(String displayName, String name, Boolean subscribed) {
        if (subscribed) {
            displayName = "[S] " + displayName;
        }
        Hyperlink groupLink = new Hyperlink(displayName, "!group?" + name);
        
        groupList.add(groupLink);
    }
    
    
}
