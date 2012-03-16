package ie.dcu.redbrick.newsboards.client.view.widgets;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineHTML;

public class H3 extends Composite {
    public H3(String text) {
        SafeHtmlBuilder shb = new SafeHtmlBuilder();
        shb.appendHtmlConstant("<h3>");
        shb.appendEscaped(text);
        shb.appendHtmlConstant("</h3>");
        
        initWidget(new InlineHTML(shb.toSafeHtml()));
    }
}
