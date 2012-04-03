package ie.dcu.redbrick.newsboards.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;
import ie.dcu.redbrick.newsboards.shared.users.UserModel;

public class NewsgroupDao extends NewsboardsDao<NewsgroupModel> {
    public static final String USER_LINK_NAME = "User_Newsgroup";
    
    private RowMapper<NewsgroupModel> rowMapper = new RowMapper<NewsgroupModel>() {

        public NewsgroupModel getModel(ResultSet rs) throws SQLException {
            NewsgroupModel ng = new NewsgroupModel();
            
            ng.setId(rs.getLong("id"));
            ng.setName(rs.getString("name"));
            ng.setDisplayName(rs.getString("display_name"));
            ng.setDescription(rs.getString("description"));
            
            return ng;
        }

        public Map<String, Object> getMap(NewsgroupModel object) {
            HashMap<String, Object> m = new HashMap<String, Object>();
            
            m.put("id", object.getId());
            m.put("name", object.getName());
            m.put("display_name", object.getDisplayName());
            m.put("description", object.getDescription());
            
            return m;
        }
        
    };
    
    protected String getTableName() {
        return "Newsgroup";
    }

    protected RowMapper<NewsgroupModel> getRowMapper() {
        return rowMapper;
    }
    
    public List<NewsgroupModel> findByUser(UserModel userModel) {
        String query = "SELECT ng.id AS id, ng.name AS name,"
        		+ " ng.display_name AS display_name,"
                + " ng.description AS description"
                + " FROM User_Newsgroup un"
                + " INNER JOIN " + getTableName() + " ng ON un.newsgroup_id = ng.id"
                + " WHERE un.user_id = ?";
        return findByQuery(query, userModel.getId());
    }
    
    public void subscribeUser(NewsgroupModel newsgroup, UserModel user) {
        String query = "INSERT INTO User_Newsgroup (user_id, newsgroup_id)"
                + " VALUES (?, ?)";
        
        
        updateByQuery(query, user.getId(), newsgroup.getId());
    }
    
    public NewsgroupModel findByName(String name) {
        String query = "SELECT *"
                + " FROM " + getTableName()
                + " WHERE name = ?"
                + " LIMIT 1";
        
        List<NewsgroupModel> result = findByQuery(query, name);
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
