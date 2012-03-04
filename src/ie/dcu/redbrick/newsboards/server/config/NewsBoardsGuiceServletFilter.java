package ie.dcu.redbrick.newsboards.server.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class NewsBoardsGuiceServletFilter extends GuiceServletContextListener {

    protected Injector getInjector() {
        return Guice.createInjector(new NewsBoardsGuiceServletModule());
    }

}
