package com.hw.mapper;

import com.hw.domain.People;
import com.hw.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleMapper {
    int insertData(People people);
    List<People> getData();
}
