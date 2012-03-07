package ie.dcu.redbrick.newsboards.server.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.dcu.redbrick.newsboards.shared.users.UserModel;

public class UserDao extends NewsboardsDao<UserModel> {
    private RowMapper<UserModel> rowMapper = new RowMapper<UserModel>() {

        public UserModel getModel(ResultSet rs) throws SQLException {
            UserModel u = new UserModel();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setDisplayName(rs.getString("display_name"));
            return u;
        }

        public Map<String, Object> getMap(UserModel object) {
            HashMap<String, Object> m = new HashMap<String, Object>();
            m.put("id", object.getId());
            m.put("username", object.getUsername());
            m.put("display_name", object.getDisplayName());
            return m;
        }
        
    };
    
    protected String getTableName() {
        return "User";
    }

    protected RowMapper<UserModel> getRowMapper() {
        return rowMapper;
    }
    
    public UserModel findByUsername(String username) {
        List<UserModel> items = findByQuery("SELECT * FROM " + getTableName() + " WHERE username = ?", username);
        if (items.size() > 0) {
            return items.get(0);
        } else {
            return null;
        }
    }
}
