package ie.dcu.redbrick.newsboards.server.database;

import ie.dcu.redbrick.newsboards.shared.Model;

public abstract class NewsboardsDao <T extends Model<Long>> extends BaseDao<T, Long> {
    protected String getDsn() {
       return "java:comp/env/jdbc/newsgroupsdb";
    }

}
