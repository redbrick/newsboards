package ie.dcu.redbrick.newsboards.server.database;

import ie.dcu.redbrick.newsboards.shared.nntp.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface RowMapper<T extends Model<?>> {
    T getModel(ResultSet rs) throws SQLException;
    Map<String, Object> getMap(T object);
}
