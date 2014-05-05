package com.springapp.mvc.repointerfaces;

import com.springapp.mvc.entity.Order;

import java.sql.SQLException;

/**
 * Created by Admin on 16.04.14.
 */
public interface RepoOrderInterface {
    int save(Order order) throws SQLException;
    Order findOne(int iID) throws SQLException;
    void update(Order order) throws SQLException;
    void delete(int iID) throws SQLException;
    void deleteAll() throws SQLException;
}
