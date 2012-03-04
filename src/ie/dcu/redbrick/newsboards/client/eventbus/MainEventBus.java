package ie.dcu.redbrick.newsboards.client.eventbus;

import ie.dcu.redbrick.newsboards.client.home.HomeModule;
import ie.dcu.redbrick.newsboards.client.main.presenter.MainPresenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.event.EventBusWithLookup;

@Events(startPresenter=MainPresenter.class, historyOnStart=true)
@ChildModules({
    @ChildModule(moduleClass=HomeModule.class, async=true, autoDisplay=false)
})
public interface MainEventBus extends EventBusWithLookup {
    @Start
    @Event(handlers={MainPresenter.class})
    void start();
    
    @Event(handlers={MainPresenter.class})
    void setContent(IsWidget w);
    
    @Event(handlers={MainPresenter.class})
    void setNavigation(IsWidget w);
    
    @InitHistory
    @Event(forwardToModules=HomeModule.class, 
        historyConverter=NewsboardsHistoryConverter.class, 
        name="home")
    void goHome();
}
