package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.CountryLanguage;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryLanguageMapper {

    @Select("select * from countrylanguage limit 10")
    public List<CountryLanguage> find10Records();
}