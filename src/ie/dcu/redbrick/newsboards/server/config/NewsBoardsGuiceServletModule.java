package ie.dcu.redbrick.newsboards.server.config;

import ie.dcu.redbrick.newsboards.server.main.NntpServiceImpl;
import ie.dcu.redbrick.newsboards.server.nntp.NntpSession;
import ie.dcu.redbrick.newsboards.server.nntp.NntpSessionImpl;

import com.google.inject.servlet.ServletModule;

public class NewsBoardsGuiceServletModule extends ServletModule {
    protected void configureServlets() {
        bind(NewsboardConfig.class).to(NewsboardsPropertiesConfig.class);
        bind(NntpSession.class).to(NntpSessionImpl.class);
        
        serve("/newsboards/nntpservice").with(NntpServiceImpl.class);
    }
}
