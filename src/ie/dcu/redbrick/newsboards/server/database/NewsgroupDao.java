package ie.dcu.redbrick.newsboards.server.database;

import ie.dcu.redbrick.newsboards.shared.nntp.Model;

public abstract class NewsgroupDao <T extends Model<Integer>> extends BaseDao<T, Integer> {
    protected String getDsn() {
       return "java:comp/env/jdbc/newsgroupsdb";
    }

}
