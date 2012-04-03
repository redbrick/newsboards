package ie.dcu.redbrick.newsboards.client.home.widgets;

import ie.dcu.redbrick.newsboards.client.resources.NgCssResource;
import ie.dcu.redbrick.newsboards.client.resources.NgResources;
import ie.dcu.redbrick.newsboards.client.view.widgets.H4;
import ie.dcu.redbrick.newsboards.client.view.widgets.P;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class SubscribedGroupBoxImpl extends Composite implements SubscribedGroupBox{
    private FlowPanel panel;
    private Image closeButton;
    
    private NgResources resources = NgResources.INSTANCE;
    private NgCssResource css = NgResources.INSTANCE.css();
    
    public SubscribedGroupBoxImpl(String groupName, String groupDesc) {
        panel = new FlowPanel();
        panel.addStyleName(css.homepageSubscribedPanel());
        
        HorizontalPanel topPanel = new HorizontalPanel();
        topPanel.setWidth("100%");
        topPanel.add(new H4(groupName));
        
        closeButton = new Image(resources.xButton());
        topPanel.add(closeButton);
        topPanel.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_RIGHT);
        
        panel.add(new H4(groupName));
        panel.add(new P(groupDesc));
        initWidget(panel);
    }
    
    public HasClickHandlers getUnsubscribeButton() {
        return closeButton;
    }
}
