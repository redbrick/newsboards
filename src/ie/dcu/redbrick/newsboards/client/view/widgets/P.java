package ie.dcu.redbrick.newsboards.client.view.widgets;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineHTML;

public class P extends Composite {
    public P(String text) {
        SafeHtmlBuilder shb = new SafeHtmlBuilder();
        shb.appendHtmlConstant("<p>");
        shb.appendEscaped(text);
        shb.appendHtmlConstant("</p>");
        
        initWidget(new InlineHTML(shb.toSafeHtml()));
    }
}
