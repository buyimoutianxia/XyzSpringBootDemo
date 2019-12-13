package com.xyz.Dao;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Map map) {
        int ret = 0;
        try {
            ret = jdbcTemplate.update("insert into t_user(username,address) values(?,?)", map.get("username"), map.get("address"));
        }catch (DataAccessException e) {
            return 0;
        }
        return ret;
    }

    public int delete(Map map) {
        int ret = 0;
        try {
            ret = jdbcTemplate.update("delete from t_user where username = ?", map.get("username"));
        }catch (DataAccessException e) {
            return 0;
        }
        return ret;
    }
}
