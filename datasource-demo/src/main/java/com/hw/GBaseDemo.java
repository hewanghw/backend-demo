package com.hw;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GBaseDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "com.gbasedbt.jdbc.Driver";

        String url = "jdbc:gbasedbt-sqli://10.110.55.25:port/idb_dm_catalog:GBASEDBTSERVER=gbase01;DELIMIDENT=y;SQLMODE=Oracle;DB_LOCALE=zh_CN.57372;";

        String username = "XX";

        String password = "xxxx";

        Class.forName(driver);

        Connection con = DriverManager.getConnection(url,username,password);

        DatabaseMetaData metaData = con.getMetaData();

        System.out.println("数据库的产品名称:" + metaData.getDatabaseProductName());
    }
}
