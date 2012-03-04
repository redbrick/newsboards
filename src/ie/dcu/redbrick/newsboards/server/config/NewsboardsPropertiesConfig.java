package ie.dcu.redbrick.newsboards.server.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.google.inject.Singleton;

@Singleton
public class NewsboardsPropertiesConfig implements NewsboardConfig {
    private static Logger logger = Logger.getLogger(NewsboardsPropertiesConfig.class);
    
    private final String nntpServerName;
    private final Integer nntpServerPort;
    
    NewsboardsPropertiesConfig() {
        Properties props = new Properties();
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("newsboards.properties");
            
            props.load(is);
            
        } catch (IOException e) {
            logger.warn("Error reading configuration file, will use defaults", e);
        }
        
        nntpServerName = props.getProperty("nntp.hostname", "localhost");
        
        Integer parsedPort;
        try {
            parsedPort = Integer.parseInt(props.getProperty("nntp.port", "119"));
        } catch (NumberFormatException e) {
            logger.warn("Error reading NNTP port config line - must be an integer.");
            parsedPort = 119;
        }
        nntpServerPort = parsedPort;
    }
    
    public String getNntpServerName() {
        return nntpServerName;
    }

    public Integer getNntpServerPort() {
        return nntpServerPort;
    }

}
