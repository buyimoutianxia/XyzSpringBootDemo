package com.xyz.Service;

import com.xyz.Dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    DataDao dataDao;


    public int add1() {
        return dataDao.add1();
    }

    public int add2() {
        return dataDao.add2();
    }
}
