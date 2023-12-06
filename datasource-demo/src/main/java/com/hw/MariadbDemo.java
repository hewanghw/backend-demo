package com.hw;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariadbDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "org.mariadb.jdbc.Driver";

        String url = "jdbc:mariadb://10.110.124.127:30005/conservatory_data";

        String username = "root";

        String password = "Idb@1024";

        Class.forName(driver);

        Connection con = DriverManager.getConnection(url,username,password);

        DatabaseMetaData metaData = con.getMetaData();

        System.out.println("数据库的产品名称:" + metaData.getDatabaseProductName());
    }
}
