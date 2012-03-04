package ie.dcu.redbrick.newsboards.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InsertPanel;

public class MainViewImpl extends Composite implements MainView {
    private FlowPanel panel;
    private FlowPanel contentPanel;
    private FlowPanel navPanel;
    
    public MainViewImpl() {
        panel = new FlowPanel();
        initWidget(panel);
        
        navPanel = new FlowPanel();
        navPanel.addStyleName("child_nav"); // definted in external stylesheet
                
        contentPanel = new FlowPanel();
        contentPanel.addStyleName("content"); // defined in the external stylesheet
                
        panel.add(navPanel);
        panel.add(contentPanel);
    }

    public InsertPanel.ForIsWidget getNavPanel() {
        return navPanel;
    }

    public InsertPanel.ForIsWidget getContentPanel() {
        return contentPanel;
    }

    public void clearContentPanel() {
        contentPanel.clear();
    }

    public void clearNavigation() {
        navPanel.clear();
    }
}
