package ie.dcu.redbrick.newsboards.client.view.widgets;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineHTML;

public class H2 extends Composite {
    public H2(String text) {
        SafeHtmlBuilder shb = new SafeHtmlBuilder();
        shb.appendHtmlConstant("<h2>");
        shb.appendEscaped(text);
        shb.appendHtmlConstant("</h2>");
        
        initWidget(new InlineHTML(shb.toSafeHtml()));
    }
}
