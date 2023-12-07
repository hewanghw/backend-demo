package com.hw.mapper;

import com.hw.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    List<Person> selectAll(Integer pageSize, Integer pageNum);
}
