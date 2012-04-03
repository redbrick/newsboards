package ie.dcu.redbrick.newsboards.server.database;

import ie.dcu.redbrick.newsboards.shared.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public abstract class BaseDao<T extends Model<U>, U> {
    protected static Logger logger = Logger.getLogger(BaseDao.class);
    
    protected Connection conn;
    
    public BaseDao() {
        try {
            Context initialContext = new InitialContext();
            DataSource ds = (DataSource)initialContext.lookup(getDsn());
            if (ds == null) {
                logger.error("Could not find datasource " + getDsn());
                return;
            }
            
            conn = ds.getConnection();
        } catch (NamingException e) {
            logger.error("Naming exception connecting to database", e);
        } catch (SQLException e) {
            logger.error("SQL exception connecting to database", e);
        }
    }
    
    /**
     * Return the table name for this DAO. This should be a constant string,
     * it is injected directly into SQL queries without being filtered.
     * 
     * @return table name
     */
    protected abstract String getTableName();
        
    /**
     * Return the JNDI data source name for this DAO to use.
     * 
     * @return jndi dsn
     */
    protected abstract String getDsn();
    
    /**
     * Return a RowMapper for this DAO to convert to/from result sets and
     * model objects.
     * 
     * @return row mapper
     */
    protected abstract RowMapper<T> getRowMapper();
    
    protected String getIdColumnName() {
        return "id";
    }
    
    protected Connection getConnection() {
        return conn;
    }
    
    public List<T> getAll() {
        String query = "SELECT * FROM " + getTableName();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> output = new ArrayList<T>();
        
        try {
            stmt = conn.prepareStatement(query);
            stmt.execute();
            
            rs = stmt.getResultSet();
            while(rs.next()) {
                output.add(getRowMapper().getModel(rs));
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {}
        }
        
        return output;
    }
    
    public T getById(U identifier) {
        String query = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(query);
            setUnknownParameter(stmt, 1, identifier);
            stmt.execute();
            rs = stmt.getResultSet();
            rs.next();
            
            return getRowMapper().getModel(rs);
        } catch (SQLException e) {
            logger.error("Error retrieving object from database", e);
            
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {}
        }
    }
    
    public void delete(T model) {
        deleteById(model.getId());
    }
    
    public void deleteById(U id) {
        String query = "DELETE * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        PreparedStatement stmt = null;
        
        try {
            logger.debug("Querying with " + query);
            stmt = getConnection().prepareStatement(query);
            setUnknownParameter(stmt, 1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting object id " + id + " from database", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {}
        }
    }
    
    protected List<T> findByQuery(String query, Object... params) {
        List<T> output = new ArrayList<T>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            logger.debug("Querying with " + query);
            stmt = getConnection().prepareStatement(query);
            
            for (int i = 0;i < params.length;i++) {
                setUnknownParameter(stmt, i + 1, params[i]);
            }
            
            stmt.execute();
            rs = stmt.getResultSet();
            
            while(rs.next()) {
                output.add(getRowMapper().getModel(rs));
            }
            
            return output;
        } catch (SQLException e) {
            logger.error("Error querying database", e);
            
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {}
        }
    }
    
    protected void updateByQuery(String query, Object... params) {
        PreparedStatement stmt = null;
        
        try {
            stmt = getConnection().prepareStatement(query);
            
            for (int i = 0;i < params.length;i++) {
                setUnknownParameter(stmt, i + 1, params[i]);
            }
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error querying database", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {}
        }
    }
    
    public void update(T object) {
        StringBuilder qb = new StringBuilder();
        qb.append("UPDATE ");
        qb.append(getTableName());
        qb.append(" WHERE ");
        qb.append(getIdColumnName());
        qb.append(" SET ");
        
        Map<String, Object> columns = getRowMapper().getMap(object);
        ArrayList<Object> params = new ArrayList<Object>();
        int size = columns.size();
        int count = 0;
        for (String key:columns.keySet()) {
            params.add(columns.get(key));
            
            qb.append(key);
            qb.append(" = ?");
            
            count++;
            if (count < size) {
                qb.append(",");
            }
        }
        
        PreparedStatement stmt = null;
        
        try {
            String query = qb.toString();
            logger.debug("Querying with " + query);
            stmt = getConnection().prepareStatement(query);
            
            for (int i = 0;i < params.size();i++) {
                setUnknownParameter(stmt, i + 1, params.get(i));
            }
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error executing update", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) {}
        }
    }
    
    public T create(T object) {
        Map<String, Object> map = getRowMapper().getMap(object);
        ArrayList<String> keys = new ArrayList<String>(map.keySet());
        
        StringBuilder qb = new StringBuilder();
        qb.append("INSERT INTO ");
        qb.append(getTableName());
        qb.append(" (");
        
        boolean first = true;
        
        StringBuilder paramBuilder = new StringBuilder();
        List<Object> params = new ArrayList<Object>();
        
        for (String key:keys) {
            if (!key.equals(getIdColumnName()) || map.get(key) != null) {
                if (!first) {
                    paramBuilder.append(", ");
                    qb.append(", ");
                }
                first = false;
                qb.append("`");
                qb.append(key);
                qb.append("`");
                
                paramBuilder.append("?");
                
                params.add(map.get(key));
            }
        }
        
        first = true;
        
        qb.append(") VALUES (");
        qb.append(paramBuilder.toString());
        qb.append(")");
        
        PreparedStatement stmt = null;
        ResultSet genKeys = null;
        try {
            String query = qb.toString();
            logger.debug("Querying with " + query);
             stmt = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
             
             for (int i = 0;i < params.size();i++) {
                 setUnknownParameter(stmt, i + 1, params.get(i));
             }
             
             stmt.executeUpdate();
             
             genKeys = stmt.getGeneratedKeys();
             genKeys.next();
             
             object.setId((U)genKeys.getObject(1));
             
             genKeys.close();
             
             return object;
        } catch (SQLException e) {
            logger.error("Error executing update", e);
            return null;
        } finally {
            try {
                if (genKeys != null) {
                    genKeys.close();
                }
                
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) {}
        }
    }
    
    protected static void setUnknownParameter(PreparedStatement stmt, int index, Object parameter) 
            throws SQLException {
        if (parameter instanceof String) {
            stmt.setString(index, (String)parameter);
        } else if (parameter instanceof Integer) {
            stmt.setInt(index, (Integer)parameter);
        } else if (parameter instanceof Double) {
            stmt.setDouble(index, (Double)parameter);
        } else if (parameter instanceof java.util.Date) {
            stmt.setDate(index, (java.sql.Date)new java.sql.Date(((java.util.Date)parameter).getTime()));
        } else {
            stmt.setObject(index, parameter);
        }
    }
}
