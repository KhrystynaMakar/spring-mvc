package com.springapp.mvc.repointerfaces;

import com.springapp.mvc.entity.Fruit;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Admin on 16.04.14.
 */
public interface RepoFruitInterface {
    int save(Fruit fruit) throws SQLException;
    Fruit findOne(int iID) throws SQLException;
    void update(Fruit fruit) throws SQLException;
    void delete(int iID) throws SQLException;
    void deleteAll() throws SQLException;
    ArrayList<Fruit> showAll() throws SQLException;
}
