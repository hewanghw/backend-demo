package com.hw.controller;

import com.hw.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final DataSource dataSource;

    public PersonController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/getAll")
    boolean getAll() throws SQLException {
        Connection conn = dataSource.getConnection();
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM person");
        //如果有数据，rs.next()返回true
        while (rs.next()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i);
                System.out.println(columnLabel + ": " + rs.getString(columnLabel));
            }
            System.out.println("============================");

        }
        return true;
    }
}
