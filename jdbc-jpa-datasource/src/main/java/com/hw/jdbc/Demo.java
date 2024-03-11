package com.hw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/jdbc_demo?useUnicode=true&userSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "root",
                "root");
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, username, create_time FROM user_info");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("username") + " 创建时间：" + rs.getString("create_time"));
        }

    }

}
