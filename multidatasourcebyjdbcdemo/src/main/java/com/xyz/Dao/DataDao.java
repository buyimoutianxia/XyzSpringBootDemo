package com.xyz.Dao;

import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

    @Autowired
    JdbcTemplate jdbcTemplateOne;

    @Autowired
    JdbcTemplate jdbcTemplateTwo;

    public int add1() {
        int ret = 0;
        try {
           ret = jdbcTemplateOne.update("insert into t_user(username,address) values(?,?)","sourceone", "addressone");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }finally {
            return ret;
        }
    }

    public int add2() {
        int ret = 0;
        try {
          ret = jdbcTemplateTwo.update("insert into t_user(username) values(?)", "sourcetwo");
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            return ret;
        }
    }
}
