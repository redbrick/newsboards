package ie.dcu.redbrick.newsboards.client.home.view;

import ie.dcu.redbrick.newsboards.client.home.widgets.SubscribedGroupBox;
import ie.dcu.redbrick.newsboards.client.home.widgets.SubscribedGroupBoxImpl;
import ie.dcu.redbrick.newsboards.client.resources.NgCssResource;
import ie.dcu.redbrick.newsboards.client.resources.NgResources;
import ie.dcu.redbrick.newsboards.client.view.widgets.H2;
import ie.dcu.redbrick.newsboards.client.view.widgets.H3;
import ie.dcu.redbrick.newsboards.shared.resources.NgConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HomeViewImpl extends Composite implements HomeView {
    private FlowPanel panel;
    private HorizontalPanel horizontalPanel;
    private FlowPanel subscribedListPanel;
    private VerticalPanel availableListPanel;
    
    private FlowPanel groupList;
    
    private NgConstants i18n = GWT.create(NgConstants.class);
    private NgCssResource css = NgResources.INSTANCE.css();
    
    public HomeViewImpl() {
        panel = new FlowPanel();
        
        subscribedListPanel = new FlowPanel();
        subscribedListPanel.addStyleName(css.homepageLeftOuterPanel());
        
        availableListPanel = new VerticalPanel();
        availableListPanel.addStyleName(css.homepageRightOuterPanel());
        
        subscribedListPanel.add(new H3(i18n.subscribedGroups()));
        availableListPanel.add(new H3(i18n.availableGroups()));
        
        horizontalPanel = new HorizontalPanel();
        horizontalPanel.addStyleName(css.homepageMainSplit());        
        horizontalPanel.add(subscribedListPanel);
        horizontalPanel.add(availableListPanel);
        
        groupList = new FlowPanel();
        
        panel.add(new H2(i18n.newsboardsHome()));
        panel.add(horizontalPanel);
        panel.add(groupList);
        
        
        initWidget(panel);
    }

    public SubscribedGroupBox addSubscribedGroupBox(String name,
            String description) {
        SubscribedGroupBoxImpl box = new SubscribedGroupBoxImpl(name, description);
        subscribedListPanel.add(box);
        return box;
    }
}
