package com.springapp.mvc.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class ShopConnector {

    @Autowired
    private DataSource dataSource;

    private Connection createConnection() throws SQLException{
        return dataSource.getConnection();
    }
    public Statement createStatement() throws SQLException {
        return createConnection().createStatement();
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = createStatement();
        stmt.executeUpdate(query, stmt.RETURN_GENERATED_KEYS);

        ResultSet generatedKeys = stmt.getGeneratedKeys();
        int iID = 0;
        while (generatedKeys.next()){
            iID = generatedKeys.getInt(1);
        }
        closeConnection(stmt.getConnection());
        return iID;
    }

    public void execute(String query) throws SQLException {
        Statement stmt = createStatement();
        stmt.execute(query);
        closeConnection(stmt.getConnection());
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
