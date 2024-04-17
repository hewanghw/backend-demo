package com.hw.mapper;


import com.hw.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
   List<Account> selectAll();
   int updateMinus();
   int updatePlus();
}
