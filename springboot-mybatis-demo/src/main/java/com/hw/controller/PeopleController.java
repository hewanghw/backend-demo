package com.hw.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hw.domain.People;
import com.hw.domain.Person;
import com.hw.mapper.PeopleMapper;
import com.hw.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/people")
@RestController
public class PeopleController {
    @Autowired
    private PeopleMapper peopleMapper;

//    @GetMapping("/getAll")
//    Object getAll(@RequestParam Integer pageSize, @RequestParam Integer pageNum){
//        PageHelper.startPage(pageNum, pageSize);
//        List<Person> people = personMapper.selectAll(pageSize, pageNum);
//        return new PageInfo<>(people);
//    }


    @GetMapping("/insert")
    boolean insertData(){
        People people = new People();
        people.setId(2);
        people.setName("李四");
        Date date = new Date();
        System.out.println(date);
        people.setCreateTime(date);
        people.setUpdateTime(date);
      int i = peopleMapper.insertData(people);
      return i > 0;
    }


    @GetMapping("/get")
    List<People> getData() throws SQLException {
//        &serverTimezone=GMT%2B8
//        List<People> peoples = peopleMapper.getData();
//        System.out.println("peoples: " + peoples);
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hw_demo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B0",
                "root", "root");

        Statement stat = conn.createStatement();

        stat.executeQuery("SELECT * FROM people");

        ResultSet resultSet = stat.getResultSet();

        while (resultSet.next()){
            int id = resultSet.getInt(1);

            String name = resultSet.getString(2);

            String updateTimeStr = resultSet.getString(3);
            LocalDateTime updateTime = resultSet.getTimestamp(3).toLocalDateTime();

            String createTimeStr = resultSet.getString(4);
            LocalDateTime localDateTime = resultSet.getTimestamp(4).toLocalDateTime();


            System.out.println( id);

            System.out.println( name);

            System.out.println( updateTimeStr);
            System.out.println( updateTime);

            System.out.println( createTimeStr);
            System.out.println( localDateTime);

            System.out.println("====================");
        }

        return new ArrayList<>();
    }


    @GetMapping("/get1")
    List<People> getData1() throws SQLException {
//        &serverTimezone=GMT%2B8
        List<People> peoples = peopleMapper.getData();
        System.out.println("peoples: " + peoples);
        return peoples;
    }

}
