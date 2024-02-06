package com.hw.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CatalogMapper {
    List<Map<String, String>> selectCatalog();
}
