package ie.dcu.redbrick.newsboards.shared.nntp;

import ie.dcu.redbrick.newsboards.shared.Model;


public class NewsgroupModel extends Model<Integer> {
    private static final long serialVersionUID = 4951662735243156542L;
    private Integer id; // database id
    private String name;
    private String description;
    private String displayName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
}
