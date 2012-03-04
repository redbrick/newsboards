package ie.dcu.redbrick.newsboards.client.view;

import com.google.gwt.user.client.ui.InsertPanel;

public interface MainView {
    InsertPanel.ForIsWidget getNavPanel();
    InsertPanel.ForIsWidget getContentPanel();
    void clearContentPanel();
    void clearNavigation();
}
