package com.hw.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hw.domain.Person;
import com.hw.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/getAll")
    Object getAll(@RequestParam Integer pageSize, @RequestParam Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        List<Person> people = personMapper.selectAll(pageSize, pageNum);
        return new PageInfo<>(people);
    }
}
