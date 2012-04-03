package ie.dcu.redbrick.newsboards.client.home.view;

import ie.dcu.redbrick.newsboards.client.home.widgets.SubscribedGroupBox;

import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {
    SubscribedGroupBox addSubscribedGroupBox(String name, String description);
}
