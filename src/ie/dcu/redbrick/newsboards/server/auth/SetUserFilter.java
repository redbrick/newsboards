package ie.dcu.redbrick.newsboards.server.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SetUserFilter implements Filter {

    @Inject
    private AuthService authService;
    
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String authName = ((HttpServletRequest)request).getRemoteUser();
            
            if (authName == null) {
                authName = System.getProperty("fakeAuthName");
            }
            
            if (authName != null) {
                authService.setUsername(authName);
                chain.doFilter(request, response);
            } else {
                throw new ServletException("No user");
            }
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
