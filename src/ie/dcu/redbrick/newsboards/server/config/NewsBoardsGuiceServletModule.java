package ie.dcu.redbrick.newsboards.server.config;

import ie.dcu.redbrick.newsboards.server.auth.AuthService;
import ie.dcu.redbrick.newsboards.server.auth.AuthServiceImpl;
import ie.dcu.redbrick.newsboards.server.auth.SetUserFilter;
import ie.dcu.redbrick.newsboards.server.nntp.NntpServiceImpl;
import ie.dcu.redbrick.newsboards.server.nntp.NntpSession;
import ie.dcu.redbrick.newsboards.server.nntp.NntpSessionImpl;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

public class NewsBoardsGuiceServletModule extends ServletModule {
    protected void configureServlets() {
        bind(NewsboardConfig.class).to(NewsboardsPropertiesConfig.class);
        bind(NntpSession.class).to(NntpSessionImpl.class);
        bind(AuthService.class).to(AuthServiceImpl.class).in(Singleton.class);
        
        
        filter("/newsboards/*").through(SetUserFilter.class);
        serve("/newsboards/nntpservice").with(NntpServiceImpl.class);
    }
}
