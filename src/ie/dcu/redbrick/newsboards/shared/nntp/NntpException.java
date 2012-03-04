package ie.dcu.redbrick.newsboards.shared.nntp;

public class NntpException extends Exception {
    private static final long serialVersionUID = 5317335172373043034L;

    public NntpException() {
        
    }
    
    public NntpException(String s) {
        super(s);
    }
    
    public NntpException(Throwable t) {
        super(t);
    }
}
