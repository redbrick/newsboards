package ie.dcu.redbrick.newsboards.client.home.view;

import ie.dcu.redbrick.newsboards.client.view.widgets.H2;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class HomeViewImpl extends Composite implements HomeView {
    private FlowPanel panel;
    
    public HomeViewImpl() {
        panel = new FlowPanel();
        
        panel.add(new H2("Homepage"));
        initWidget(panel);
    }
}
