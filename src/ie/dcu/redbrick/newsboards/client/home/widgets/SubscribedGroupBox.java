package ie.dcu.redbrick.newsboards.client.home.widgets;

import ie.dcu.redbrick.newsboards.client.resources.NgCssResource;
import ie.dcu.redbrick.newsboards.client.resources.NgResources;
import ie.dcu.redbrick.newsboards.client.view.widgets.H4;
import ie.dcu.redbrick.newsboards.client.view.widgets.P;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class SubscribedGroupBox extends Composite {
    private FlowPanel panel;
    
    private NgCssResource css = NgResources.INSTANCE.css();
    
    public SubscribedGroupBox() {
        panel = new FlowPanel();
        panel.addStyleName(css.homepageSubscribedPanel());
        panel.add(new H4("group"));
        panel.add(new P("this is some text"));
        initWidget(panel);
    }
}
