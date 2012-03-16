package ie.dcu.redbrick.newsboards.client.home.presenter;

import java.util.ArrayList;

import ie.dcu.redbrick.newsboards.client.home.HomeEventBus;
import ie.dcu.redbrick.newsboards.client.home.view.HomeView;
import ie.dcu.redbrick.newsboards.client.home.view.HomeViewImpl;
import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;
import ie.dcu.redbrick.newsboards.shared.nntp.NntpServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=HomeViewImpl.class)
public class HomePresenter extends BasePresenter<HomeView, HomeEventBus> {
    @Inject
    private NntpServiceAsync service;
    
    public void onGoHome() {
        
        service.getGroupList(new AsyncCallback<ArrayList<NewsgroupModel>>() {

            public void onFailure(Throwable caught) {
            }

            public void onSuccess(ArrayList<NewsgroupModel> result) {
                for (NewsgroupModel model:result) {
                    //getView().addGroup(model.getName(), model.getName(), model.getSubscribed());
                }
            }
            
        });
        getEventBus().setContent(getView());
    }
}
