package ie.dcu.redbrick.newsboards.client.eventbus;

import com.mvp4g.client.annotation.History;
import com.mvp4g.client.annotation.History.HistoryConverterType;
import com.mvp4g.client.history.HistoryConverter;

@History(type=HistoryConverterType.SIMPLE)
public class NewsboardsHistoryConverter implements HistoryConverter<MainEventBus> {

    public void convertFromToken(String historyName, String param,
            MainEventBus eventBus) {
        if (param == null || param.length() < 1) {
            eventBus.dispatch(historyName);
        } else {
            eventBus.dispatch(historyName, (Object[])param.split("/"));
        }
    }
    
    public String convertToToken(String historyName) {
        return "";
    }
    
    public boolean isCrawlable() {
        return true;
    }
    
}
