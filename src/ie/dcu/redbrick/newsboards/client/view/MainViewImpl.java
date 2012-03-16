package ie.dcu.redbrick.newsboards.client.view;

import ie.dcu.redbrick.newsboards.client.resources.NgCssResource;
import ie.dcu.redbrick.newsboards.client.resources.NgResources;
import ie.dcu.redbrick.newsboards.shared.resources.NgConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InsertPanel;

public class MainViewImpl extends Composite implements MainView {
    private FlowPanel panel;
    private FlowPanel contentPanel;
    private FlowPanel navPanel;
    
    private HorizontalPanel navBar;
    private FlowPanel usernamePanel;
    private FlowPanel navContentPanel;
    
    private NgConstants i18n = GWT.create(NgConstants.class);
    private NgCssResource css = NgResources.INSTANCE.css();
    
    public MainViewImpl() {
        NgResources.INSTANCE.css().ensureInjected();
        
        panel = new FlowPanel();
        initWidget(panel);
        
        navPanel = new FlowPanel();
        navPanel.addStyleName("child_nav"); // definted in external stylesheet
        
        navBar = new HorizontalPanel();
        navBar.setWidth("100%");
        
        navContentPanel = new FlowPanel();
        navBar.add(navContentPanel);
        
        usernamePanel = new FlowPanel();
        usernamePanel.addStyleName(css.mainUsername());
        navBar.add(usernamePanel);
        navBar.setCellWidth(usernamePanel, "200px");
        navBar.setCellHorizontalAlignment(usernamePanel, HasHorizontalAlignment.ALIGN_RIGHT);
        
        navPanel.add(navBar);
        
        contentPanel = new FlowPanel();
        contentPanel.addStyleName("content"); // defined in the external stylesheet
                
        panel.add(navPanel);
        panel.add(contentPanel);
    }

    public InsertPanel.ForIsWidget getNavPanel() {
        return navContentPanel;
    }

    public InsertPanel.ForIsWidget getContentPanel() {
        return contentPanel;
    }

    public void clearContentPanel() {
        contentPanel.clear();
    }

    public void clearNavigation() {
        navContentPanel.clear();
    }

    public void setUsername(String username) {
        SafeHtmlBuilder shb = new SafeHtmlBuilder();
        shb.appendEscaped(i18n.loggedInAs(username));
        usernamePanel.clear();
        usernamePanel.add(new HTML(shb.toSafeHtml()));
    }
}
