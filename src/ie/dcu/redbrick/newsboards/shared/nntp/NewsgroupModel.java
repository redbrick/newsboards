package ie.dcu.redbrick.newsboards.shared.nntp;

import java.io.Serializable;

public class NewsgroupModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4951662735243156542L;
    private String name;
    private Long articleCount;
    
    public NewsgroupModel() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Long articleCount) {
        this.articleCount = articleCount;
    }
    
}
