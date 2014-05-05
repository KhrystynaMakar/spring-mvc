package com.springapp.mvc.repo;

import com.springapp.mvc.entity.Order;
import com.springapp.mvc.repointerfaces.RepoOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class RepoOrder implements RepoOrderInterface {


    @Autowired
    private ShopConnector connector;

    @Override
    public int save(Order order) throws SQLException {
        String query = "INSERT INTO Orders (o_id, city) VALUES (0, '" + order.getCity() + ");";
        return connector.executeUpdate(query);
    }

    @Override
    public Order findOne(int iID) throws SQLException {
        String query = "SELECT * FROM Orders WHERE o_id = " + iID + ";";
        Statement stmt = connector.createStatement();
        ResultSet result = stmt.executeQuery(query);
        Order order = new Order();
        while (result.next()){
            order.setiID(result.getInt("o_id"));
            order.setCity(result.getString("city"));
        }
        connector.closeConnection(stmt.getConnection());
        return order;
    }

    @Override
    public void update(Order order) throws SQLException {
        String query = "UPDATE Orders SET city = '" + order.getCity()
                + " WHERE o_id = " + order.getiID() + ";";
        connector.execute(query);
    }

    @Override
    public void delete(int iID) throws SQLException {
        String query = "DELETE FROM Orders WHERE o_id = " + iID + ";";
        connector.execute(query);
    }

    @Override
    public void deleteAll() throws SQLException {
        String query = "DELETE FROM Orders;";
        connector.execute(query);
    }
}
