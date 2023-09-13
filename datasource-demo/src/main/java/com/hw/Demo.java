package com.hw;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "dm.jdbc.driver.DmDriver";

        String url = "jdbc:dm://10.110.55.25:5236?schema=IDB_DM_METADATA";

        String username = "SYSDBA";

        String password = "SYSDBA001";

        Class.forName(driver);

        Connection con = (Connection) DriverManager.getConnection(url,username,password);

        DatabaseMetaData metaData = (DatabaseMetaData) con.getMetaData();

        System.out.println("数据库的产品名称:" + metaData.getDatabaseProductName());
    }
}
