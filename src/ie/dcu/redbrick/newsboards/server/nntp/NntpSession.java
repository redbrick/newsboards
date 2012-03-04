package ie.dcu.redbrick.newsboards.server.nntp;

import ie.dcu.redbrick.newsboards.shared.nntp.NntpException;

import java.util.List;

import org.apache.commons.net.nntp.NewsgroupInfo;

public interface NntpSession {
    List<NewsgroupInfo> listNewsgroups()
        throws NntpException;
}
