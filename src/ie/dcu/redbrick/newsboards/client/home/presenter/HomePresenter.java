package ie.dcu.redbrick.newsboards.client.home.presenter;

import ie.dcu.redbrick.newsboards.client.home.HomeEventBus;
import ie.dcu.redbrick.newsboards.client.home.view.HomeView;
import ie.dcu.redbrick.newsboards.client.home.view.HomeViewImpl;

import com.google.gwt.core.client.GWT;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=HomeViewImpl.class)
public class HomePresenter extends BasePresenter<HomeView, HomeEventBus> {
    public void onGoHome() {
        getEventBus().setContent(getView());
        GWT.log("Gone home");
    }
}
