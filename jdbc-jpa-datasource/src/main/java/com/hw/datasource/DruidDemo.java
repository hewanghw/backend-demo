package com.hw.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.load(DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        for(int i = 0; i < 11; i++){
            Connection conn = ds.getConnection();
            System.out.println(conn);
            if(i == 9){
                conn.close();
            }
//
        }

    }
}
