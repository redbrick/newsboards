package ie.dcu.redbrick.newsboards.server.nntp;

import ie.dcu.redbrick.newsboards.server.config.NewsboardConfig;
import ie.dcu.redbrick.newsboards.shared.nntp.NntpException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.nntp.NNTPClient;
import org.apache.commons.net.nntp.NNTPConnectionClosedException;
import org.apache.commons.net.nntp.NewsgroupInfo;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class NntpSessionImpl implements NntpSession {
    private static Logger logger = Logger.getLogger(NntpSessionImpl.class);
    
    private NewsboardConfig config;
    private NNTPClient client;
            
    @Inject
    NntpSessionImpl(NewsboardConfig config) {
        this.config = config;
        
        reopenConnection();
    }
    
    public synchronized List<NewsgroupInfo> listNewsgroups() throws NntpException {
        try {
            return Arrays.asList(client.listNewsgroups());
        } catch (NNTPConnectionClosedException e) {
            logger.info("NNTP server connection gone, reconnecting and retrying.");
            reopenConnection();
            return listNewsgroups();
        } catch (IOException e) {
            logger.error("Unknown I/O exception getting newsgroup list", e);
            throw new NntpException(e);
        }
    }
    
    private void reopenConnection() {
        client = new NNTPClient();
        
        try {
            client.connect(config.getNntpServerName(), config.getNntpServerPort());
        } catch (IOException e) {
            logger.error("Error connecting to NNTP server!", e);
        }
        
    }

}
