package ie.dcu.redbrick.newsboards.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.dcu.redbrick.newsboards.shared.nntp.NewsgroupModel;
import ie.dcu.redbrick.newsboards.shared.users.UserModel;

public class NewsgroupDao extends NewsboardsDao<NewsgroupModel> {
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
                + " INNER JOIN Newsgroup ON un.newsgroup_id = ng.id"
                + " WHERE un.user_id = ?";
        return findByQuery(query, userModel.getId());
    }
}
