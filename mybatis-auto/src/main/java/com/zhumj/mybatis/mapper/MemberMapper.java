package com.zhumj.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

//    @Select("select count(1) from member where id = #{id}")
    int count(int id);
}
