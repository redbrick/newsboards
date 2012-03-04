package ie.dcu.redbrick.newsboards.client.home;

import ie.dcu.redbrick.newsboards.client.home.presenter.HomePresenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBusWithLookup;

@Events(module=HomeModule.class, startPresenter = HomePresenter.class)
public interface HomeEventBus extends EventBusWithLookup {
    @Event(handlers={HomePresenter.class})
    void goHome();
    
    @Event(forwardToParent=true)
    void setContent(IsWidget w);
    
    @Event(forwardToParent=true)
    void setNavigation(IsWidget w);
}
