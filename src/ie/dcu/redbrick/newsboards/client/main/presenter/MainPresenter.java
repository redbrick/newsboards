package ie.dcu.redbrick.newsboards.client.main.presenter;

import ie.dcu.redbrick.newsboards.client.eventbus.MainEventBus;
import ie.dcu.redbrick.newsboards.client.view.MainView;
import ie.dcu.redbrick.newsboards.client.view.MainViewImpl;
import ie.dcu.redbrick.newsboards.shared.users.UserModel;
import ie.dcu.redbrick.newsboards.shared.users.UserServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = MainViewImpl.class)
public class MainPresenter extends BasePresenter<MainView, MainEventBus> {
    @Inject
    private UserServiceAsync userService;
    
    public void onStart() {
        userService.getUser(new AsyncCallback<UserModel>() {

            public void onFailure(Throwable caught) {
                
            }

            public void onSuccess(UserModel result) {
                getView().setUsername(result.getDisplayName());
            }
            
        });
    }
    
    public void onSetContent(IsWidget w) {
        getView().clearContentPanel();
        getView().getContentPanel().add(w);
    }
    
    public void onSetNavigation(IsWidget w) {
        getView().clearNavigation();
        getView().getNavPanel().add(w);
    }
}
