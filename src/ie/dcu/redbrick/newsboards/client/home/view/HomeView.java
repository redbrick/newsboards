package ie.dcu.redbrick.newsboards.client.home.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {
    void addGroup(String displayName, String name, Boolean subscribed);
}
