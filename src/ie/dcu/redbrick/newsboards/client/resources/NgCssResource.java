package ie.dcu.redbrick.newsboards.client.resources;

import com.google.gwt.resources.client.CssResource;

public interface NgCssResource extends CssResource {
    @ClassName("ng-HomePage-MainSplit")
    String homepageMainSplit();
    
    @ClassName("ng-HomePage-SubscribedPanel")
    String homepageSubscribedPanel();
    
    @ClassName("ng-HomePage-LeftOuterPanel")
    String homepageLeftOuterPanel();
    
    @ClassName("ng-HomePage-RightOuterPanel")
    String homepageRightOuterPanel();
    
    @ClassName("ng-Main-Username")
    String mainUsername();
}
