package ie.dcu.redbrick.newsboards.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface NgResources extends ClientBundle {
    public static final NgResources INSTANCE = GWT.create(NgResources.class);
    
    @Source("style.css")
    public NgCssResource css();
    
    @Source("xbutton.png")
    ImageResource xButton();
}
