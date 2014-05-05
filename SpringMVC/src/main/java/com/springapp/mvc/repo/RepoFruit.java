package com.springapp.mvc.repo;

import com.springapp.mvc.entity.Fruit;
import com.springapp.mvc.repointerfaces.RepoFruitInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class RepoFruit implements RepoFruitInterface {

    @Autowired
    private ShopConnector connector;

    @Override
    public int save(Fruit fruit) throws SQLException {
        String query = "INSERT INTO Fruits (f_id, name, price, weight, citrus, order_id) VALUES (0, '" + fruit.getName() + "', "
                + fruit.getPrice() + ", " + fruit.getWeight() + ", " + fruit.isCitrus() + ", " + fruit.getOrderID() + ");";
        return connector.executeUpdate(query);
    }

    @Override
    public Fruit findOne(int iID) throws SQLException {
        String query = "SELECT * FROM Fruits WHERE f_id = " + iID + ";";
        Statement stmt = connector.createStatement();
        ResultSet result = stmt.executeQuery(query);
        Fruit fruit = new Fruit();
        while (result.next()){
            fruit.setiID(result.getInt("f_id"));
            fruit.setName(result.getString("name"));
            fruit.setPrice(result.getDouble("price"));
            fruit.setWeight(result.getDouble("weight"));
            fruit.setCitrus(result.getBoolean("citrus"));
            fruit.setOrderID(result.getInt("order_id"));
        }
        connector.closeConnection(stmt.getConnection());
        return fruit;
    }

    @Override
    public void update(Fruit fruit) throws SQLException {
        String query = "UPDATE Fruits SET name = '" + fruit.getName() + "', price = " + fruit.getPrice()
                + ", weight = " + fruit.getWeight() + ", citrus = " + fruit.isCitrus() + ", order_id = " + fruit.getOrderID()
                + " WHERE f_id = " + fruit.getiID() + ";";
        connector.execute(query);
    }

    @Override
    public void delete(int iID) throws SQLException {
        String query = "DELETE FROM Fruits WHERE f_id = " + iID + ";";
        connector.execute(query);
    }

    @Override
    public void deleteAll() throws SQLException {
        String query = "DELETE FROM Fruits;";
        connector.execute(query);
    }

    @Override
    public ArrayList<Fruit> showAll() throws SQLException {
        String query = "SELECT * FROM FRUITS;";
        Statement stmt = connector.createStatement();
        ResultSet result = stmt.executeQuery(query);

        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        while (result.next()){
            Fruit fruit = new Fruit();
            fruit.setiID(result.getInt("f_id"));
            fruit.setName(result.getString("name"));
            fruit.setPrice(result.getDouble("price"));
            fruit.setWeight(result.getDouble("weight"));
            fruit.setCitrus(result.getBoolean("citrus"));
            fruit.setOrderID(result.getInt("order_id"));
            fruits.add(fruit);
        }
        connector.closeConnection(stmt.getConnection());
        return fruits;
    }
}
