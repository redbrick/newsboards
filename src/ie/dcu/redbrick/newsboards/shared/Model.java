package ie.dcu.redbrick.newsboards.shared;

import java.io.Serializable;

public abstract class Model<T> implements Serializable {
    private static final long serialVersionUID = 185573638974066831L;

    public abstract T getId();
}
